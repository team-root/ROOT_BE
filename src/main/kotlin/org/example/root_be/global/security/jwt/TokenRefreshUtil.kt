package org.example.root_be.global.security.jwt

import org.example.root_be.domain.auth.domain.repository.RefreshTokenRepository
import org.springframework.stereotype.Component

@Component
class TokenRefreshUtil(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtTokenProvider: JwtTokenProvider
) {

    fun refreshAccessToken(refreshToken: String): String {
        val token = refreshTokenRepository.findByToken(refreshToken)
            ?: throw RuntimeException("Refresh Token Not Found")
        
        return jwtTokenProvider.generateAccessToken(token.userId)
    }
}
