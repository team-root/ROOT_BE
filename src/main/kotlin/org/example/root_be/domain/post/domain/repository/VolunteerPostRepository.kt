package org.example.root_be.domain.post.domain.repository

import org.example.root_be.domain.post.domain.VolunteerPost
import org.springframework.data.jpa.repository.JpaRepository

interface VolunteerPostRepository: JpaRepository<VolunteerPost, Long> {
    fun findBy(): List<VolunteerPost>
}