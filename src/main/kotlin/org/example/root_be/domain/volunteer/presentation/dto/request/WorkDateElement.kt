package org.example.root_be.domain.volunteer.presentation.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class WorkDateElement(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val startDate: LocalDateTime,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val endDate: LocalDateTime
)
