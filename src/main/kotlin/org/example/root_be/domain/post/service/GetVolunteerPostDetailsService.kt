package org.example.root_be.domain.post.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.post.facade.VolunteerFacade
import org.example.root_be.domain.post.presentation.dto.response.GetVolunteerPostResponse
import org.springframework.stereotype.Service

@Service
class GetVolunteerPostDetailsService(
    private val volunteerFacade: VolunteerFacade
) {
    @Transactional
    fun execute(
        postId: Long
    ): GetVolunteerPostResponse {
        val volunteerPost = volunteerFacade.getVolunteerPostById(postId)
        return GetVolunteerPostResponse(volunteerPost)
    }
}