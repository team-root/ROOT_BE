package org.example.root_be.domain.post.presentation.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import org.example.root_be.domain.detail.domain.VolunteerDetail
import org.example.root_be.domain.post.domain.VolunteerPost
import org.example.root_be.domain.post_day.domain.PostDay
import java.time.LocalDate

@JsonInclude(JsonInclude.Include.NON_NULL)
data class GetVolunteerPostResponse(
    val id: Long,
    val title: String,
    val activityDetails: String?,
    val applicationPeriod: List<ApplicationPeriodResponse>,
    val workDate: List<WorkDateResponse>?,
    val dayOfWeek: List<DayOfWeekResponse>?,
    val place: String,
    val time: String,
    val personnel: String,
    val role: List<RoleResponse>
) {
    constructor(
        volunteerPost: VolunteerPost,
        volunteerDetail: VolunteerDetail,
        postDay: PostDay
    ): this(
        id = volunteerPost.id,
        title = volunteerPost.title,
        activityDetails = volunteerDetail.activityDetails,
        applicationPeriod = listOf(ApplicationPeriodResponse(volunteerPost)),
        workDate = listOf(WorkDateResponse(volunteerPost)),
        dayOfWeek = volunteerPost.dayOfWeek.map { DayOfWeekResponse(it.id, it.dayOfWeek) },
        place = volunteerDetail.place,
        time = volunteerDetail.time,
        personnel = volunteerPost.personnel,
        role = volunteerPost.roles.map { RoleResponse(it.id, it.title) }
    )
    data class ApplicationPeriodResponse(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        val startDate: LocalDate?,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        val endDate: LocalDate?
    ) {
        constructor(volunteerPost: VolunteerPost): this(
            startDate = volunteerPost.applicationStartDate,
            endDate = volunteerPost.applicationEndDate
        )
    }

    data class WorkDateResponse(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        val startDate: LocalDate?,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        val endDate: LocalDate?
    ) {
        constructor(volunteerPost: VolunteerPost): this(
            startDate = volunteerPost.workStartDate,
            endDate = volunteerPost.workEndDate
        )
    }

    data class RoleResponse(
        val id: Long,
        val title: String
    )

    data class DayOfWeekResponse(
        val id: Long,
        val dayOfWeek: String
    )
}