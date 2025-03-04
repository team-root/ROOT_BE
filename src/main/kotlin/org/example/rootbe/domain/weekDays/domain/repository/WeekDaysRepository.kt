package org.example.rootbe.domain.weekDays.domain.repository

import org.example.rootbe.domain.post.domain.VolunteerPost
import org.example.rootbe.domain.weekDays.domain.WeekDays
import org.springframework.data.jpa.repository.JpaRepository

interface WeekDaysRepository : JpaRepository<WeekDays, Long> {
    fun findAllByVolunteerPost(post: VolunteerPost): List<WeekDays>
}
