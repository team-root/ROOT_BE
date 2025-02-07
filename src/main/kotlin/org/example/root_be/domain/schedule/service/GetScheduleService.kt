package org.example.root_be.domain.schedule.service

import org.springframework.transaction.annotation.Transactional
import org.example.root_be.domain.schedule.domain.repository.ScheduleRepository
import org.example.root_be.domain.schedule.facade.ScheduleFacade
import org.example.root_be.domain.schedule.presentation.dto.response.GetScheduleResponse
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class GetScheduleService(
    private val scheduleRepository: ScheduleRepository,
    private val scheduleFacade: ScheduleFacade
) {
    @Transactional(readOnly = true)
    fun execute(
        date: LocalDate
    ): GetScheduleResponse {
        val schedule = scheduleFacade.findScheduleByDate(date)

        val title = schedule.title
        val allSchedules = scheduleRepository.findByTitle(title)

        val startDate = allSchedules.minOf { it.date }
        val endDate = allSchedules.maxOf { it.date }

        return GetScheduleResponse(
            id = schedule.id,
            title = title,
            startDate = startDate,
            endDate = endDate
        )
    }
}