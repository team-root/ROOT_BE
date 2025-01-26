package org.example.root_be.domain.activity.domain

import jakarta.persistence.*
import org.example.root_be.domain.detail.domain.VolunteerDetail
import org.example.root_be.domain.user.domain.User

import java.time.LocalDateTime

@Entity
@Table(name = "volunteer_activity")
class VolunteerActivity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_id", nullable = false)
    val volunteerDetail: VolunteerDetail,

    @Column(nullable = false)
    val activityDate: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)