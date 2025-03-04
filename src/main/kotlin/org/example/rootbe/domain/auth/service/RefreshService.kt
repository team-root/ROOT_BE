package org.example.rootbe.domain.auth.service

import org.example.rootbe.domain.auth.domain.repository.RefreshTokenRepository
import org.example.rootbe.domain.auth.exception.RefreshTokenNotFoundException
import org.example.rootbe.domain.auth.presentation.dto.request.RefreshRequest
import org.example.rootbe.domain.auth.presentation.dto.response.RefreshResponse
import org.example.rootbe.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RefreshService(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtTokenProvider: JwtTokenProvider,
) {
    @Transactional
    fun execute(refreshRequest: RefreshRequest): RefreshResponse {
        val refreshToken =
            refreshTokenRepository.findByToken(refreshRequest.refreshToken)
                ?: throw RefreshTokenNotFoundException()

        return RefreshResponse(
            accessToken = jwtTokenProvider.generateAccessToken(refreshToken.userId),
        )
    }
}
