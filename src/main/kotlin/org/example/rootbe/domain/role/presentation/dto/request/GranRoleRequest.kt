package org.example.rootbe.domain.role.presentation.dto.request

import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

data class GranRoleRequest(
    @field:NotNull
    val userId: Long,
    @field:NotBlank(message = "역할을 비워둘 수 없습니다.")
    val role: String,
)
