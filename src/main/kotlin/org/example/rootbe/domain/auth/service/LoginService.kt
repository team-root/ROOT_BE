package org.example.rootbe.domain.auth.service

import org.example.rootbe.domain.auth.domain.RefreshToken
import org.example.rootbe.domain.auth.domain.repository.RefreshTokenRepository
import org.example.rootbe.domain.auth.exception.InvalidRoleException
import org.example.rootbe.domain.auth.presentation.dto.request.LoginRequest
import org.example.rootbe.domain.auth.presentation.dto.response.LoginResponse
import org.example.rootbe.domain.user.domain.User
import org.example.rootbe.domain.user.domain.repository.UserRepository
import org.example.rootbe.domain.user.domain.type.Role
import org.example.rootbe.global.security.jwt.JwtProperties
import org.example.rootbe.global.security.jwt.JwtTokenProvider
import org.example.rootbe.infrastructure.openfeign.client.DsmAuthClient
import org.example.rootbe.infrastructure.openfeign.client.dto.request.UserInfoRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LoginService(
    private val userRepository: UserRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    private val jwtProperties: JwtProperties,
    private val dsmAuthClient: DsmAuthClient,
) {
    @Transactional
    fun execute(loginRequest: LoginRequest): LoginResponse {
        val userInfo =
            dsmAuthClient.getUserInfo(
                UserInfoRequest(
                    accountId = loginRequest.xquareId,
                    password = loginRequest.password,
                ),
            )

        val role =
            when (userInfo.userRole) {
                "SCH" -> Role.ADMIN
                "STU" -> Role.STUDENT
                else -> throw InvalidRoleException()
            }

        val user =
            userRepository.findByDsmId(userInfo.accountId)
                ?.apply {
                    name = userInfo.name
                    grade = userInfo.grade
                    classNum = userInfo.classNum
                } ?: userRepository.save(
                User(
                    id = 0L,
                    dsmId = userInfo.accountId,
                    name = userInfo.name,
                    num = userInfo.num,
                    grade = userInfo.grade,
                    classNum = userInfo.classNum,
                    userRole = role,
                    totalVolunteerTime = 0,
                    deviceToken = loginRequest.deviceToken,
                ),
            )

        val accessToken = jwtTokenProvider.generateAccessToken(user.id)
        val refreshToken = jwtTokenProvider.generateRefreshToken(user.id)

        refreshTokenRepository.save(
            RefreshToken(
                id = user.id.toString(),
                token = refreshToken,
                ttl = jwtProperties.refreshExpiration,
                userId = user.id,
            ),
        )

        return LoginResponse(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
    }
}
