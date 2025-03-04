package org.example.rootbe.domain.post.domain.repository

import org.example.rootbe.domain.post.domain.VolunteerPost
import org.springframework.data.jpa.repository.JpaRepository

interface VolunteerPostRepository : JpaRepository<VolunteerPost, Long> {
    fun findBy(): List<VolunteerPost>
}
