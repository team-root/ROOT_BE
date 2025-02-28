package org.example.root_be.domain.schedule.facade

import org.example.root_be.domain.schedule.domain.Schedule
import org.example.root_be.domain.schedule.domain.repository.ScheduleRepository
import org.example.root_be.domain.schedule.exception.ScheduleNotFoundException
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class ScheduleFacade(
    private val scheduleRepository: ScheduleRepository,
) {
    fun findScheduleByDate(date: LocalDate): Schedule {
        return scheduleRepository.findByDate(date)
            ?: throw ScheduleNotFoundException
    }
}
