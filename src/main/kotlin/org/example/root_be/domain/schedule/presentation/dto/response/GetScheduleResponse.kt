package org.example.root_be.domain.schedule.presentation.dto.response

import java.time.LocalDate

data class GetScheduleResponse(
    val id: Long,
    val title: String,
    val startDate: LocalDate,
    val endDate: LocalDate
)
