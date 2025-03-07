package org.example.rootbe.domain.applications.presentation.dto.response

data class GetAcceptedStudentsResponse(
    val students: List<AcceptedStudentsResponse>,
    val roles: List<String>
) {
    data class AcceptedStudentsResponse(
        val userId: Long,
        val name: String,
        val grade: Int
    )
}