package org.example.root_be.domain.volunteer.presentation.dto.request

import java.time.LocalDateTime

data class WorkDateElement(
    val startDate: LocalDateTime,
    val endDate: LocalDateTime
)
