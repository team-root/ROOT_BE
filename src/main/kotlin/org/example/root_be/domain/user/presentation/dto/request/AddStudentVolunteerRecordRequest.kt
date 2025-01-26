package org.example.root_be.domain.user.presentation.dto.request

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import org.jetbrains.annotations.NotNull

data class AddStudentVolunteerRecordRequest(
    @NotEmpty(message = "사용자 ID 목록은 필수입니다")
    val userIds: List<Long>,

    @NotBlank(message = "활동 상세내용은 필수입니다")
    val detail: String,

    @NotNull
    @Min(value = 1, message = "봉사시간은 1시간 이상이어야 합니다")
    val time: Int,

    @NotBlank(message = "봉사장소는 필수입니다")
    val place: String
)