package org.example.rootbe.domain.schedule.service

import org.example.rootbe.domain.schedule.domain.repository.ScheduleRepository
import org.example.rootbe.domain.schedule.facade.ScheduleFacade
import org.example.rootbe.domain.schedule.presentation.dto.response.GetScheduleResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class GetScheduleService(
    private val scheduleRepository: ScheduleRepository,
    private val scheduleFacade: ScheduleFacade,
) {
    @Transactional(readOnly = true)
    fun execute(date: LocalDate): GetScheduleResponse {
        val schedule = scheduleFacade.findScheduleByDate(date)

        val title = schedule.title
        val allSchedules = scheduleRepository.findByTitle(title)

        val startDate = allSchedules.minOf { it.date }
        val endDate = allSchedules.maxOf { it.date }

        return GetScheduleResponse(
            id = schedule.id,
            title = title,
            startDate = startDate,
            endDate = endDate,
        )
    }
}
