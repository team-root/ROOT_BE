package org.example.rootbe.domain.applications.presentation.dto.response

data class ApplicationElement(
    val applicationId: Long,
    val userId: Long,
    val name: String,
    val grade: Int,
    val classNum: Int,
    val number: Int,
)
