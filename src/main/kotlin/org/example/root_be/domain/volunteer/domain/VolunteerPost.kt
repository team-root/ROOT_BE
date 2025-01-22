package org.example.root_be.domain.volunteer.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "VOLUNTEER_POST")
class VolunteerPost(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "activity_details")
    var activityDetails: String?,

    @Column(name = "application_start_date", nullable = false)
    var applicationStartDate: LocalDateTime,

    @Column(name = "application_end_date", nullable = false)
    var applicationEndDate: LocalDateTime,

    @Column(name = "work_start_date")
    var workStartDate: LocalDateTime?,

    @Column(name = "work_end_date")
    var workEndDate: LocalDateTime?,

    @Column(name = "work_date")
    var workDate: String?,

    @Column(name = "is_regular", nullable = false)
    var isRegular: Boolean,

    @Column(name = "place", nullable = false)
    var place: String,

    @Column(name = "time", nullable = false)
    var time: String,

    @Column(name = "personnel", nullable = false)
    var personnel: String,

    @Column(name = "created_at", nullable = false)
    val createAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()
)