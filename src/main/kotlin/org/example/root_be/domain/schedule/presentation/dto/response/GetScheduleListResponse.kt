package org.example.root_be.domain.schedule.presentation.dto.response

import org.example.root_be.domain.schedule.domain.Schedule
import java.time.LocalDate

data class GetScheduleListResponse(
    val events: List<ScheduleResponse>
) {
    data class ScheduleResponse(
        val title: String,
        val startDate: LocalDate,
        val endDate: LocalDate,
    )
}