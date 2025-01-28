package org.example.root_be.domain.schedule.presentation.dto.request

import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull
import java.time.LocalDate

data class GenerateScheduleRequest(
    @field:NotBlank(message = "제목을 비워둘 수 없습니다.")
    @field:Length(min = 1, max = 30, message = "제목은 최소 1글자, 최대 30글자까지 작성 가능합니다.")
    val title: String,

    @field:NotNull
    val startDate: LocalDate,

    @field:NotNull
    val endDate: LocalDate
)
