package org.example.root_be.domain.week_days.domain

import jakarta.persistence.*
import org.example.root_be.domain.post.domain.VolunteerPost

@Entity
@Table(name = "WEEK_DAYS")
class WeekDays(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "volunteer_post_id")
    val volunteerPost: VolunteerPost,

    @Column(name = "day_of_week", nullable = false)
    var dayOfWeek: String
)