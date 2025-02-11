package org.example.root_be.domain.notification.domain.repository

import org.example.root_be.domain.notification.domain.Notification
import org.springframework.data.jpa.repository.JpaRepository

interface NotificationRepository: JpaRepository<Notification, Long> {
    fun findBy(): List<Notification>
}