package org.example.root_be.domain.post_day.domain.repository

import org.example.root_be.domain.post.domain.VolunteerPost
import org.example.root_be.domain.post_day.domain.DayOfWeek
import org.springframework.data.jpa.repository.JpaRepository

interface DayOfWeekRepository: JpaRepository<DayOfWeek, Long> {
    fun findAllByVolunteerPost(post: VolunteerPost): List<DayOfWeek>
}