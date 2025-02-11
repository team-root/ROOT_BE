package org.example.root_be.domain.notification.service

import org.example.root_be.domain.notification.domain.repository.NotificationRepository
import org.example.root_be.domain.notification.presentation.dto.response.GetNotificationListResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetNotificationListService(
    private val notificationRepository: NotificationRepository
) {
    @Transactional(readOnly = true)
    fun execute():GetNotificationListResponse {
        return GetNotificationListResponse(
            notificationRepository.findBy()
                .map { GetNotificationListResponse.NotificationResponse(it) }
        )
    }
}