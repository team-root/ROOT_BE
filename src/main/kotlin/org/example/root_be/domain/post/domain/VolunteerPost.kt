package org.example.root_be.domain.post.domain

import jakarta.persistence.*
import org.example.root_be.domain.role.domain.VolunteerRole
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "VOLUNTEER_POST")
class VolunteerPost(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    val id: Long = 0,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "activity_details")
    var activityDetails: String?,

    @Column(name = "application_start_date", nullable = false)
    var applicationStartDate: LocalDate,

    @Column(name = "application_end_date", nullable = false)
    var applicationEndDate: LocalDate,

    @Column(name = "work_start_date")
    var workStartDate: LocalDate?,

    @Column(name = "work_end_date")
    var workEndDate: LocalDate?,

    @Column(name = "day_of_week")
    var dayOfWeek: String?,

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
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "volunteerPost")
    val roles: List<VolunteerRole> = listOf()
)