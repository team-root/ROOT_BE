package org.example.rootbe.domain.role.domain.repository

import org.example.rootbe.domain.post.domain.VolunteerPost
import org.example.rootbe.domain.role.domain.VolunteerRole
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<VolunteerRole, Long> {
    fun findAllByVolunteerPost(post: VolunteerPost): List<VolunteerRole>
}
