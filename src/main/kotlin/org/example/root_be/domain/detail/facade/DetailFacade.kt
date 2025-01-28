package org.example.root_be.domain.detail.facade

import org.example.root_be.domain.detail.domain.VolunteerDetail
import org.example.root_be.domain.detail.domain.repository.VolunteerDetailRepository
import org.example.root_be.domain.detail.exception.VolunteerDetailNotFoundException
import org.springframework.stereotype.Component

@Component
class DetailFacade(
    private val volunteerDetailRepository: VolunteerDetailRepository
) {
    fun getVolunteerDetailsByPostId(
        postId: Long
    ): VolunteerDetail {
        return volunteerDetailRepository.findById(postId)
            .orElseThrow { VolunteerDetailNotFoundException }
    }
}