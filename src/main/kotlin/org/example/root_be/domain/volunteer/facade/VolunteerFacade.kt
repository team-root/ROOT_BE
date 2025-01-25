package org.example.root_be.domain.volunteer.facade

import org.example.root_be.domain.volunteer.domain.VolunteerPost
import org.example.root_be.domain.volunteer.domain.repository.VolunteerPostRepository
import org.example.root_be.domain.volunteer.exception.VolunteerPostNotFoundException
import org.springframework.stereotype.Component

@Component
class VolunteerFacade(
    private val volunteerPostRepository: VolunteerPostRepository
) {
    fun getVolunteerPostById(
        postId: Long
    ): VolunteerPost {
        return volunteerPostRepository.getVolunteerPostById(postId)
            ?: throw VolunteerPostNotFoundException
    }
}