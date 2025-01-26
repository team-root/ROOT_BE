package org.example.root_be.domain.applications.domain

import jakarta.persistence.*
import org.example.root_be.domain.role.domain.Role
import org.example.root_be.domain.user.domain.User
import org.example.root_be.domain.volunteer.domain.VolunteerPost
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
    val volunteerRole: Role? = null,

    @Column(nullable = false)
    var isApplied: Boolean = false,

    @Column(nullable = false)
    var isAccepted: Boolean = false,

    @Column(nullable = false)
    val appliedAt: LocalDateTime = LocalDateTime.now()
)