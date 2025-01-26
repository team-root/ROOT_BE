package org.example.root_be.domain.activity.domain.repository

import org.example.root_be.domain.activity.domain.VolunteerActivity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VolunteerActivityRepository : JpaRepository<VolunteerActivity, Long> {
    fun findAllByUserId(userId: Long): List<VolunteerActivity>
}