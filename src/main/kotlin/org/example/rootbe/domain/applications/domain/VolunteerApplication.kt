package org.example.rootbe.domain.applications.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.example.rootbe.domain.post.domain.VolunteerPost
import org.example.rootbe.domain.role.domain.VolunteerRole
import org.example.rootbe.domain.user.domain.User
import java.time.LocalDateTime

@Entity
@Table(name = "volunteer_application")
class VolunteerApplication(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    val volunteerPost: VolunteerPost,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    var volunteerRole: VolunteerRole? = null,
    @Column(nullable = false)
    var isApplied: Boolean = false,
    @Column(nullable = false)
    var isAccepted: Boolean = false,
    @Column(nullable = false)
    val appliedAt: LocalDateTime = LocalDateTime.now(),
)
