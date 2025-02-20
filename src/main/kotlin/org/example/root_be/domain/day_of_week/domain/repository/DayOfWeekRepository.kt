package org.example.root_be.domain.day_of_week.domain.repository

import org.example.root_be.domain.post.domain.VolunteerPost
import org.example.root_be.domain.day_of_week.domain.DayOfWeek
import org.springframework.data.jpa.repository.JpaRepository

interface DayOfWeekRepository: JpaRepository<DayOfWeek, Long> {
    fun findAllByVolunteerPost(post: VolunteerPost): List<DayOfWeek>
}