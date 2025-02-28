package org.example.root_be.domain.post.service

import org.example.root_be.domain.detail.facade.DetailFacade
import org.example.root_be.domain.post.facade.VolunteerPostFacade
import org.example.root_be.domain.post.presentation.dto.response.GetVolunteerPostResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetVolunteerPostDetailsService(
    private val volunteerPostFacade: VolunteerPostFacade,
    private val detailsFacade: DetailFacade,
) {
    @Transactional(readOnly = true)
    fun execute(postId: Long): GetVolunteerPostResponse {
        val volunteerPost = volunteerPostFacade.getVolunteerPostById(postId)
        val volunteerDetail = detailsFacade.getVolunteerDetailsByPostId(postId)
        return GetVolunteerPostResponse(volunteerPost, volunteerDetail)
    }
}
