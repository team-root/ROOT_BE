package org.example.root_be.domain.notification.presentation

import jakarta.validation.Valid
import org.example.root_be.domain.fcm.service.FirebaseCloudMessageService
import org.example.root_be.domain.notification.presentation.dto.request.generateNotificationRequest
import org.example.root_be.domain.notification.presentation.dto.response.GetNotificationListResponse
import org.example.root_be.domain.notification.service.GetNotificationListService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notifications")
@Validated
class NotificationController(
    private val firebaseCloudMessageService: FirebaseCloudMessageService,
    private val getNotificationService: GetNotificationListService,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun generateNotification(
        @Valid
        @RequestBody request: generateNotificationRequest,
    ) {
        firebaseCloudMessageService.sendAllUsers(request)
    }

    @GetMapping
    fun getNotifications(): GetNotificationListResponse {
        return getNotificationService.execute()
    }
}
