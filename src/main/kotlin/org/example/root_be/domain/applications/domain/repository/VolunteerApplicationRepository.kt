package org.example.root_be.domain.applications.domain.repository

import org.example.root_be.domain.applications.domain.VolunteerApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VolunteerApplicationRepository : JpaRepository<VolunteerApplication, Long> {
    fun findAllByVolunteerPostId(postId: Long): List<VolunteerApplication>
}