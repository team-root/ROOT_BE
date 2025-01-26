package org.example.root_be.domain.applications.presentation.dto.response

data class ApplicationElement(
    val applicationId: Long,
    val userId: Long,
    val name: String,
    val grade: Int,
    val classNum: Int,
    val number: Int
)