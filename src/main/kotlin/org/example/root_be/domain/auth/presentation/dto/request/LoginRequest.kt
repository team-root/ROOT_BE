package org.example.root_be.domain.auth.presentation.dto.request

import jakarta.validation.constraints.NotBlank

data class LoginRequest(
    val deviceToken: String?,

    @field:NotBlank(message = "xquareId는 필수 값입니다")
    val xquareId: String,

    @field:NotBlank(message = "비밀번호는 필수 값입니다")
    val password: String
)