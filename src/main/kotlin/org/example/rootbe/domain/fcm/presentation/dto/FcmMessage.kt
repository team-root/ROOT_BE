package org.example.rootbe.domain.fcm.presentation.dto

data class FcmMessage(
    val validateOnly: Boolean = false,
    val message: Message,
) {
    data class Message(
        val alarm: Alarm,
        val deviceToken: String,
    )

    data class Alarm(
        val title: String,
        val body: String,
    )
}
