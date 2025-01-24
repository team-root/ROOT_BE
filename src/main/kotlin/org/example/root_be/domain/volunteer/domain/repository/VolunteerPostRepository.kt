package org.example.root_be.domain.volunteer.domain.repository

import org.example.root_be.domain.volunteer.domain.VolunteerPost
import org.springframework.data.jpa.repository.JpaRepository

interface VolunteerPostRepository: JpaRepository<VolunteerPost, Long> {
    fun findBy(): List<VolunteerPost>
}