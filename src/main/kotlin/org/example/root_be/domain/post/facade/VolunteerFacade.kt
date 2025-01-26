package org.example.root_be.domain.post.facade

import org.example.root_be.domain.post.domain.VolunteerPost
import org.example.root_be.domain.post.domain.repository.VolunteerPostRepository
import org.example.root_be.domain.post.exception.VolunteerPostNotFoundException
import org.springframework.stereotype.Component

@Component
class VolunteerFacade(
    private val volunteerPostRepository: VolunteerPostRepository
) {
    fun getVolunteerPostById(
        postId: Long
    ): VolunteerPost {
        return volunteerPostRepository.findById(postId)
            .orElseThrow() { VolunteerPostNotFoundException }
    }
}