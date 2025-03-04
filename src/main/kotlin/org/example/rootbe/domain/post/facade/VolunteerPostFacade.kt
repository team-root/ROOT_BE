package org.example.rootbe.domain.post.facade

import org.example.rootbe.domain.post.domain.VolunteerPost
import org.example.rootbe.domain.post.domain.repository.VolunteerPostRepository
import org.example.rootbe.domain.post.exception.VolunteerPostNotFoundException
import org.springframework.stereotype.Component

@Component
class VolunteerPostFacade(
    private val volunteerPostRepository: VolunteerPostRepository,
) {
    fun getVolunteerPostById(postId: Long): VolunteerPost {
        return volunteerPostRepository.findById(postId)
            .orElseThrow { throw VolunteerPostNotFoundException }
    }
}
