package org.example.root_be.domain.post.presentation.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull
import java.time.LocalDate

data class GenerateVolunteerPostRequest(
    @field:NotNull
    val isRegular: Boolean,

    @field:NotBlank(message = "제목을 비워둘 수 없습니다.")
    @field:Length(min = 1, max = 30, message = "제목은 최소 1글자, 최대 30글자까지 작성 가능합니다.")
    val title: String,

    @field:NotBlank(message = "설명을 비워둘 수 없습니다.")
    @field:Length(min = 1, max = 150, message = "설명은 최소 1글자, 최대 150글자까지 작성 가능합니다.")
    val activityDetails: String,

    @field:NotNull
    val applicationPeriod: List<ApplicationPeriodElement>,

    val workDate: List<WorkDateElement>?,

    val dayOfWeek: String?,

    @field:NotNull
    val place: String,

    @field:NotNull
    val time: String,

    @field:NotNull
    val personnel: String,

    @field:NotNull
    val role: List<RoleElement>
) {
    data class ApplicationPeriodElement(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        val startDate: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        val endDate: LocalDate
    )

    data class WorkDateElement(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        val startDate: LocalDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        val endDate: LocalDate
    )

    data class RoleElement(
        val id: Long,
        val title: String
    )
}
