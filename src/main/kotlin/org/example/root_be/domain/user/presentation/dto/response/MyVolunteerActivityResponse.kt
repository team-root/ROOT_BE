package org.example.root_be.domain.user.presentation.dto.response

data class MyVolunteerActivityResponse(
    val totalVolunteerTime: Int,
    val volunteerList: List<VolunteerElement>,
)
