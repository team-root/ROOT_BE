package org.example.root_be.domain.post.domain

import jakarta.persistence.*
import org.example.root_be.domain.detail.domain.VolunteerDetail
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

    @OneToOne
    @JoinColumn(name = "detail_id")
    var volunteerDetail: VolunteerDetail,

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
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "volunteerPost")
    val roles: List<VolunteerRole> = listOf()
) {
    fun modifyPost(
        isRegular: Boolean,
        title: String,
        volunteerDetail: VolunteerDetail,
        applicationStartDate: LocalDate,
        applicationEndDate: LocalDate,
        workStartDate: LocalDate?,
        workEndDate: LocalDate?,
        dayOfWeek: String?,
        place: String,
        time: String,
        personnel: String,
        updatedAt: LocalDateTime
    ) {
        this.isRegular = isRegular
        this.title = title
        this.volunteerDetail = volunteerDetail
        this.applicationStartDate = applicationStartDate
        this.applicationEndDate = applicationEndDate
        this.workStartDate = workStartDate
        this.workEndDate = workEndDate
        this.dayOfWeek = dayOfWeek
        this.place = place
        this.time = time
        this.personnel = personnel
        this.updatedAt = LocalDateTime.now()
    }
}