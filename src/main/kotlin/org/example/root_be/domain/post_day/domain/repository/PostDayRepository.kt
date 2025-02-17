package org.example.root_be.domain.post_day.domain.repository

import org.example.root_be.domain.post.domain.VolunteerPost
import org.example.root_be.domain.post_day.domain.PostDay
import org.springframework.data.jpa.repository.JpaRepository

interface PostDayRepository: JpaRepository<PostDay, Long> {
    fun findAllByVolunteerPost(post: VolunteerPost): List<PostDay>
}