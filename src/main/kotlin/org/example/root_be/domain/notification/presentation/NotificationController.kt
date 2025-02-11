package org.example.root_be.domain.notification.presentation

import org.example.root_be.domain.fcm.service.FirebaseCloudMessageService
import org.example.root_be.domain.notification.presentation.dto.request.generateNotificationRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/notifications")
class NotificationController(
    private val firebaseCloudMessageService: FirebaseCloudMessageService
) {
    @PostMapping
    fun generateNotification(
        @RequestBody request: generateNotificationRequest
    ) {
        firebaseCloudMessageService.sendAllUsers(request)
    }
}