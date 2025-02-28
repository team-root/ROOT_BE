package org.example.root_be.domain.schedule.presentation.dto.request

import java.time.LocalDate

data class ModifyScheduleRequest(
    val title: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
)
