package org.example.root_be.domain.applications.presentation.dto.response

data class ApplyVolunteerResponse(
    val applicationId: Long,
    val userId: Long,
    val postId: Long
)