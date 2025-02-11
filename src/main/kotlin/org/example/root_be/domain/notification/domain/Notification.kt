package org.example.root_be.domain.notification.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "NOTIFICATION")
class Notification(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "body")
    val body: String,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)