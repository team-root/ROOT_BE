package org.example.root_be.domain.volunteer.presentation.dto.request

import org.example.root_be.domain.role.domain.Role

data class GenerateVolunteerPostRequest(
    val isRegular: Boolean,
    val title: String,
    val activityDetails: String,
    val applicationPeriod: List<ApplicationPeriodElement>,
    val workDate: List<WorkDateElement>?,
    val dayOfWeek: String?,
    val place: String,
    val time: String,
    val personnel: String,
    val role: List<Role>
)
