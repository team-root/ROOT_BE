package org.example.rootbe.domain.notification.presentation.dto.response

import org.example.rootbe.domain.notification.domain.Notification

data class GetNotificationListResponse(
    val content: List<NotificationResponse>,
) {
    data class NotificationResponse(
        val id: Long,
        val title: String,
        val body: String,
    ) {
        constructor(
            notification: Notification,
        ) : this(
            id = notification.id,
            title = notification.title,
            body = notification.body,
        )
    }
}
