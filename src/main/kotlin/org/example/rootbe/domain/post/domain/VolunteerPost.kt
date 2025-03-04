package org.example.rootbe.domain.post.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.example.rootbe.domain.detail.domain.VolunteerDetail
import org.example.rootbe.domain.role.domain.VolunteerRole
import org.example.rootbe.domain.weekDays.domain.WeekDays
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
    @OneToOne(cascade = [CascadeType.ALL])
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
    @OneToMany(mappedBy = "volunteerPost", cascade = [CascadeType.ALL], orphanRemoval = true)
    var weekDays: MutableList<WeekDays> = mutableListOf(),
    @Column(name = "is_regular", nullable = false)
    var isRegular: Boolean,
    @Column(name = "personnel", nullable = false)
    var personnel: String,
    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    @OneToMany(mappedBy = "volunteerPost", cascade = [CascadeType.ALL], orphanRemoval = true)
    val roles: List<VolunteerRole> = listOf(),
) {
    fun modifyPost(
        isRegular: Boolean,
        title: String,
        applicationStartDate: LocalDate,
        applicationEndDate: LocalDate,
        workStartDate: LocalDate?,
        workEndDate: LocalDate?,
        personnel: String,
        updatedAt: LocalDateTime,
    ) {
        this.isRegular = isRegular
        this.title = title
        this.applicationStartDate = applicationStartDate
        this.applicationEndDate = applicationEndDate
        this.workStartDate = workStartDate
        this.workEndDate = workEndDate
        this.personnel = personnel
        this.updatedAt = LocalDateTime.now()
    }
}
