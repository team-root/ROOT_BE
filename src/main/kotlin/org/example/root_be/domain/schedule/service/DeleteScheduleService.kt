package org.example.root_be.domain.schedule.service

import org.example.root_be.domain.schedule.domain.repository.ScheduleRepository
import org.example.root_be.domain.schedule.facade.ScheduleFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class DeleteScheduleService(
    private val scheduleFacade: ScheduleFacade,
    private val scheduleRepository: ScheduleRepository
) {
    @Transactional
    fun execute(
        date: LocalDate
    ) {
        val schedule = scheduleFacade.findScheduleByDate(date)
        val title = schedule.title
        val deleteSchedules = scheduleRepository.findByTitle(title)

        scheduleRepository.deleteAll(deleteSchedules)
    }
}