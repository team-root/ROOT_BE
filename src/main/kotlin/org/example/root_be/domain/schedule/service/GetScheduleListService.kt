package org.example.root_be.domain.schedule.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.schedule.domain.repository.ScheduleRepository
import org.example.root_be.domain.schedule.presentation.dto.response.GetScheduleListResponse
import org.springframework.stereotype.Service

@Service
class GetScheduleListService(
    private val scheduleRepository: ScheduleRepository
) {
    @Transactional
    fun execute(): GetScheduleListResponse {
        return GetScheduleListResponse(
            scheduleRepository.findBy()
                .map { GetScheduleListResponse.ScheduleElement(it) }
        )
    }
}