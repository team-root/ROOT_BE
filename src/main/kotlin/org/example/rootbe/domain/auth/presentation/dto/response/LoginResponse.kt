package org.example.rootbe.domain.auth.presentation.dto.response

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
)
