package org.example.rootbe.domain.applications.domain.repository

import org.example.rootbe.domain.applications.domain.VolunteerApplication
import org.example.rootbe.domain.post.domain.VolunteerPost
import org.example.rootbe.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VolunteerApplicationRepository : JpaRepository<VolunteerApplication, Long> {
    fun findAllByVolunteerPostId(postId: Long): List<VolunteerApplication>

    fun findByUserAndVolunteerPost(
        user: User,
        volunteerPost: VolunteerPost,
    ): VolunteerApplication?

    fun findAllByVolunteerPost(post: VolunteerPost): List<VolunteerApplication>
}
