package org.example.rootbe.domain.auth.presentation.dto.request

import jakarta.validation.constraints.NotBlank

data class RefreshRequest(
    @field:NotBlank(message = "refreshToken은 필수 값입니다")
    val refreshToken: String,
)
