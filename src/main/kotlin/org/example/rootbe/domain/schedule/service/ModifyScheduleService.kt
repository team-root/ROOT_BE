package org.example.rootbe.domain.schedule.service

import org.example.rootbe.domain.schedule.domain.Schedule
import org.example.rootbe.domain.schedule.domain.repository.ScheduleRepository
import org.example.rootbe.domain.schedule.facade.ScheduleFacade
import org.example.rootbe.domain.schedule.presentation.dto.request.ModifyScheduleRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.temporal.ChronoUnit.DAYS

@Service
class ModifyScheduleService(
    private val scheduleFacade: ScheduleFacade,
    private val scheduleRepository: ScheduleRepository,
) {
    @Transactional
    fun execute(
        date: LocalDate,
        request: ModifyScheduleRequest,
    ) {
        val existingSchedule = scheduleFacade.findScheduleByDate(date)
        val oldTitle = existingSchedule.title
        val allSchedules = scheduleRepository.findByTitle(oldTitle)

        val modifyDates = modifyDates(request.startDate, request.endDate)
        val existingSchedulesByDate = allSchedules.associateBy { it.date }

        val schedulesToKeep = allSchedules.filter { it.date in modifyDates }
        schedulesToKeep.forEach { it.modifySchedule(request.title) }

        val schedulesToDelete = allSchedules.filterNot { it.date in modifyDates }
        scheduleRepository.deleteAll(schedulesToDelete)

        val schedulesToAdd =
            modifyDates
                .filterNot { it in existingSchedulesByDate.keys }
                .map {
                    Schedule(
                        title = request.title,
                        date = it,
                    )
                }

        scheduleRepository.saveAll(schedulesToKeep + schedulesToAdd)
    }

    private fun modifyDates(
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<LocalDate> {
        return (0..DAYS.between(startDate, endDate))
            .map { startDate.plusDays(it) }
    }
}
