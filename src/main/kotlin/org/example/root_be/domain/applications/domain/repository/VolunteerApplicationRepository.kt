package org.example.root_be.domain.applications.domain.repository

import org.example.root_be.domain.applications.domain.VolunteerApplication
import org.example.root_be.domain.post.domain.VolunteerPost
import org.example.root_be.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VolunteerApplicationRepository : JpaRepository<VolunteerApplication, Long> {
    fun findAllByVolunteerPostId(postId: Long): List<VolunteerApplication>

    fun findByUserAndVolunteerPost(
        user: User,
        volunteerPost: VolunteerPost,
    ): VolunteerApplication?
}
