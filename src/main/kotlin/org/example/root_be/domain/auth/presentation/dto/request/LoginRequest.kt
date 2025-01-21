package org.example.root_be.domain.auth.presentation.dto.request

data class LoginRequest (
    val xquareId: String,
    val password: String
)