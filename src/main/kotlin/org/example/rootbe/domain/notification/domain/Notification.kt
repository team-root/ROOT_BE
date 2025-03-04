package org.example.rootbe.domain.notification.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
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
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
