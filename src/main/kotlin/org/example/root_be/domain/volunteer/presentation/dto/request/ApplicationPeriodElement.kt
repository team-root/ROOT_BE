package org.example.root_be.domain.volunteer.presentation.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class ApplicationPeriodElement(
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    val startDate: LocalDate,
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    val endDate: LocalDate
)
