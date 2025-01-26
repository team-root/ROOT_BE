package org.example.root_be.domain.activity.domain

import jakarta.persistence.*
import org.example.root_be.domain.user.domain.User
import org.example.root_be.domain.post.domain.VolunteerPost
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
    @JoinColumn(name = "post_id", nullable = false)
    val volunteerPost: VolunteerPost,

    @Column(nullable = false)
    val activityDate: LocalDateTime,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)