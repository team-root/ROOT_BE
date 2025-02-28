package org.example.root_be.domain.fcm.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.auth.oauth2.GoogleCredentials
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.example.root_be.domain.fcm.presentation.dto.FcmMessage
import org.example.root_be.domain.notification.domain.Notification
import org.example.root_be.domain.notification.presentation.dto.request.generateNotificationRequest
import org.example.root_be.domain.notification.domain.repository.NotificationRepository
import org.example.root_be.domain.user.domain.repository.UserRepository
import org.springframework.core.io.ClassPathResource
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class FirebaseCloudMessageService(
    private val objectMapper: ObjectMapper,
    private val userRepository: UserRepository,
    private val notificationRepository: NotificationRepository
) {
    companion object {
        const val API_URL = "https://fcm.googleapis.com/v1/projects/root-15624/messages:send"
    }

    private fun getAccessToken(): String {
        val firebaseConfigPath = "firebase/firebase_service_key.json"
        val credentials = GoogleCredentials
            .fromStream(ClassPathResource(firebaseConfigPath).inputStream)
            .createScoped(listOf("https://www.googleapis.com/auth/cloud-platform"))
        credentials.refreshIfExpired()
        return credentials.accessToken.tokenValue
    }

    private fun sendDirectTo(
        fcmToken: String,
        title: String,
        body: String
    ) {
        val message = makeMessage(fcmToken, title, body)

        val client = OkHttpClient()
        val requestBody = message
            .toRequestBody("application/json; charset=utf-8".toMediaType())
        val request = Request.Builder()
            .url(API_URL)
            .post(requestBody)
            .addHeader("Authorization", "Bearer ${getAccessToken()}")
            .build()
        val response = client.newCall(request).execute()

        println(response.body!!.string())
    }

    @Async
    fun sendAllUsers(
        request: generateNotificationRequest
    ) {
        saveNotification(request)

        val title = request.title
        val body = request.body

        userRepository.findAll()
            .forEach {
                it.deviceToken?.let { token ->
                    sendDirectTo(token, title, body)
                }
            }
    }

    private fun makeMessage(
        fcmToken: String,
        title: String,
        body: String
    ): String {
        val alarm = FcmMessage.alarm(title = title, body = body)
        val message = FcmMessage.Message(deviceToken = fcmToken, alarm = alarm)
        return objectMapper.writeValueAsString(FcmMessage(message = message))
    }

    private fun saveNotification(
        request: generateNotificationRequest
    ) {
        notificationRepository.save(
            Notification(
                title = request.title,
                body = request.body
            )
        )
    }
}