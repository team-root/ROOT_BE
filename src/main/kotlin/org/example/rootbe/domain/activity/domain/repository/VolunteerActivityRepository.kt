package org.example.rootbe.domain.activity.domain.repository

import org.example.rootbe.domain.activity.domain.VolunteerActivity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VolunteerActivityRepository : JpaRepository<VolunteerActivity, Long> {
    fun findAllByUserId(userId: Long): List<VolunteerActivity>
}
