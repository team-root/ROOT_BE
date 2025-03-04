package org.example.rootbe.domain.notification.presentation

import jakarta.validation.Valid
import org.example.rootbe.domain.fcm.service.FirebaseCloudMessageService
import org.example.rootbe.domain.notification.presentation.dto.request.GenerateNotificationRequest
import org.example.rootbe.domain.notification.presentation.dto.response.GetNotificationListResponse
import org.example.rootbe.domain.notification.service.GetNotificationListService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

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
        @RequestBody request: GenerateNotificationRequest,
    ) {
        firebaseCloudMessageService.sendAllUsers(request)
    }

    @GetMapping
    fun getNotifications(): GetNotificationListResponse {
        return getNotificationService.execute()
    }
}
