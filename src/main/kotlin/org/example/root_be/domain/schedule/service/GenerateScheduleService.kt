package org.example.root_be.domain.schedule.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.schedule.domain.Schedule
import org.example.root_be.domain.schedule.domain.repository.ScheduleRepository
import org.example.root_be.domain.schedule.presentation.dto.request.GenerateScheduleRequest
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class GenerateScheduleService(
    private val scheduleRepository: ScheduleRepository,
) {
    @Transactional
    fun execute(request: GenerateScheduleRequest) {
        val dates = generateDates(request.startDate, request.endDate)

        scheduleRepository.saveAll(
            dates.map {
                Schedule(
                    title = request.title,
                    date = it,
                )
            },
        )
    }

    private fun generateDates(
        start: LocalDate,
        end: LocalDate,
    ): List<LocalDate> {
        return (0..java.time.temporal.ChronoUnit.DAYS.between(start, end))
            .map { start.plusDays(it) }
    }
}
