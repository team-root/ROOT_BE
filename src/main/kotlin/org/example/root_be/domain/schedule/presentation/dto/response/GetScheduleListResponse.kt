package org.example.root_be.domain.schedule.presentation.dto.response

import org.example.root_be.domain.schedule.domain.Schedule
import java.time.LocalDate

data class GetScheduleListResponse(
    val events: List<ScheduleElement>
) {
    data class ScheduleElement(
        val title: String,
        val startDate: LocalDate,
        val endDate: LocalDate,
    ) {
        constructor(
            schedule: Schedule
        ): this(
            schedule.title,
            schedule.startDate,
            schedule.endDate
        )
    }
}