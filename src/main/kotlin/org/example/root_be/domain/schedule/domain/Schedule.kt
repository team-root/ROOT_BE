package org.example.root_be.domain.schedule.domain

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "SCHEDULE")
class Schedule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "title", nullable = false)
    var title: String,
    @Column(name = "date", nullable = false)
    val date: LocalDate,
    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null,
) {
    fun modifySchedule(title: String) {
        this.title = title
        this.updatedAt = LocalDateTime.now()
    }
}
