package org.example.root_be.domain.post.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.detail.facade.DetailFacade
import org.example.root_be.domain.post.facade.VolunteerFacade
import org.example.root_be.domain.post.presentation.dto.response.GetVolunteerPostResponse
import org.springframework.stereotype.Service

@Service
class GetVolunteerPostDetailsService(
    private val volunteerFacade: VolunteerFacade,
    private val detailsFacade: DetailFacade
) {
    @Transactional
    fun execute(
        postId: Long
    ): GetVolunteerPostResponse {
        val volunteerPost = volunteerFacade.getVolunteerPostById(postId)
        val volunteerDetail = detailsFacade.getVolunteerDetailsByPostId(postId)
        return GetVolunteerPostResponse(volunteerPost, volunteerDetail)
    }
}