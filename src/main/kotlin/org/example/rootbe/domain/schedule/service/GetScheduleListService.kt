package org.example.rootbe.domain.schedule.service

import org.example.rootbe.domain.schedule.domain.repository.ScheduleRepository
import org.example.rootbe.domain.schedule.presentation.dto.response.GetScheduleListResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetScheduleListService(
    private val scheduleRepository: ScheduleRepository,
) {
    @Transactional(readOnly = true)
    fun execute(): GetScheduleListResponse {
        val dates = scheduleRepository.findAll()

        val scheduleResponses =
            dates.groupBy { it.title }
                .map { (title, date) ->
                    val id = date.first().id
                    val startDate = date.minOf { it.date }
                    val endDate = date.maxOf { it.date }
                    GetScheduleListResponse.ScheduleResponse(id, title, startDate, endDate)
                }

        return GetScheduleListResponse(scheduleResponses)
    }
}
