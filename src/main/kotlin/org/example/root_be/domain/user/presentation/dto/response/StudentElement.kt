package org.example.root_be.domain.user.presentation.dto.response

data class StudentElement(
    val id: Long,
    val name: String,
    val grade: Int,
    val classNum: Int,
    val number: Int,
    val volunteerTime: Int,
)
