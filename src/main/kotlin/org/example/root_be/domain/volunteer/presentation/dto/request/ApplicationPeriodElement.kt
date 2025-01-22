package org.example.root_be.domain.volunteer.presentation.dto.request

import java.time.LocalDateTime

data class ApplicationPeriodElement(
    val startDate: LocalDateTime,
    val endDate: LocalDateTime
)
