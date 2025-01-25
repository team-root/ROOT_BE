package org.example.root_be.domain.volunteer.service

import org.example.root_be.domain.volunteer.facade.VolunteerFacade
import org.example.root_be.domain.volunteer.presentation.dto.response.GetVolunteerPostResponse
import org.springframework.stereotype.Service

@Service
class GetVolunteerPostDetailsService(
    private val volunteerFacade: VolunteerFacade
) {
    fun execute(
        postId: Long
    ): GetVolunteerPostResponse {
        val volunteerPost = volunteerFacade.getVolunteerPostById(postId)
        return GetVolunteerPostResponse(volunteerPost)
    }
}