package org.example.root_be.domain.auth.service

import org.example.root_be.domain.auth.domain.repository.RefreshTokenRepository
import org.example.root_be.domain.auth.exception.RefreshTokenNotFoundException
import org.example.root_be.domain.auth.presentation.dto.response.RefreshResponse
import org.example.root_be.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RefreshService(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtTokenProvider: JwtTokenProvider
) {
    @Transactional
    fun execute(refreshToken: String): RefreshResponse {
        val token = refreshTokenRepository.findByToken(refreshToken)
            ?: throw RefreshTokenNotFoundException()

        return RefreshResponse(
            accessToken = jwtTokenProvider.generateAccessToken(token.userId)
        )
    }
}