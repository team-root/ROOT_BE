package org.example.rootbe.domain.user.presentation.dto.response

data class MyVolunteerActivityResponse(
    val totalVolunteerTime: Int,
    val volunteerList: List<VolunteerElement>,
)
