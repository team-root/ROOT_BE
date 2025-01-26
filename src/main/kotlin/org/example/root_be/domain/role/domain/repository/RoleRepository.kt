package org.example.root_be.domain.role.domain.repository

import org.example.root_be.domain.post.domain.VolunteerPost
import org.example.root_be.domain.role.domain.VolunteerRole
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<VolunteerRole, Long> {
    fun findAllByVolunteerPostId(postId: Long): List<VolunteerRole>
}