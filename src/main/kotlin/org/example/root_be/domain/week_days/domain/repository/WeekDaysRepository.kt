package org.example.root_be.domain.week_days.domain.repository

import org.example.root_be.domain.post.domain.VolunteerPost
import org.example.root_be.domain.week_days.domain.WeekDays
import org.springframework.data.jpa.repository.JpaRepository

interface WeekDaysRepository : JpaRepository<WeekDays, Long> {
    fun findAllByVolunteerPost(post: VolunteerPost): List<WeekDays>
}
