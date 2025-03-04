package org.example.rootbe.domain.detail.facade

import org.example.rootbe.domain.detail.domain.VolunteerDetail
import org.example.rootbe.domain.detail.domain.repository.VolunteerDetailRepository
import org.example.rootbe.domain.detail.exception.VolunteerDetailNotFoundException
import org.springframework.stereotype.Component

@Component
class DetailFacade(
    private val volunteerDetailRepository: VolunteerDetailRepository,
) {
    fun getVolunteerDetailsByPostId(postId: Long): VolunteerDetail {
        return volunteerDetailRepository.findById(postId)
            .orElseThrow { VolunteerDetailNotFoundException }
    }
}
