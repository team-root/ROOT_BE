package org.example.root_be.domain.schedule.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.schedule.domain.Schedule
import org.example.root_be.domain.schedule.domain.repository.ScheduleRepository
import org.example.root_be.domain.schedule.presentation.dto.request.GenerateScheduleRequest
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GenerateScheduleService(
    private val scheduleRepository: ScheduleRepository
) {
    @Transactional
    fun execute(
        request: GenerateScheduleRequest
    ) {
        val schedule =
            request.run {
                Schedule(
                    title = title,
                    startDate = startDate,
                    endDate = endDate,
                    createdAt = LocalDateTime.now()
                )
            }
        scheduleRepository.save(schedule)
    }
}