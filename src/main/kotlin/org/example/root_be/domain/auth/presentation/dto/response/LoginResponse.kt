package org.example.root_be.domain.auth.presentation.dto.response

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
)
