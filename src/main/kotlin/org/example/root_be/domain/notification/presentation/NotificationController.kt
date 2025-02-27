package org.example.root_be.domain.notification.presentation

import jakarta.validation.Valid
import org.example.root_be.domain.fcm.service.FirebaseCloudMessageService
import org.example.root_be.domain.notification.presentation.dto.request.generateNotificationRequest
import org.example.root_be.domain.notification.presentation.dto.response.GetNotificationListResponse
import org.example.root_be.domain.notification.service.GetNotificationListService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/notifications")
class NotificationController(
    private val firebaseCloudMessageService: FirebaseCloudMessageService,
    private val getNotificationService: GetNotificationListService
) {
    @PostMapping
    fun generateNotification(
        @Valid
        @RequestBody request: generateNotificationRequest
    ) {
        firebaseCloudMessageService.sendAllUsers(request)
    }

    @GetMapping
    fun getNotifications(): GetNotificationListResponse {
        return getNotificationService.execute()
    }
}