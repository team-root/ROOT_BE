package org.example.root_be.domain.fcm

data class FcmMessage(
    val validateOnly: Boolean = false,
    val message: Message
) {
    data class Message(
        val alarm: alarm,
        val fcmToken: String
    )

    data class alarm(
        val title: String,
        val body: String
    )
}