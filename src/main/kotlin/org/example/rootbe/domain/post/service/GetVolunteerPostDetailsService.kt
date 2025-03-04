package org.example.rootbe.domain.post.service

import org.example.rootbe.domain.detail.facade.DetailFacade
import org.example.rootbe.domain.post.facade.VolunteerPostFacade
import org.example.rootbe.domain.post.presentation.dto.response.GetVolunteerPostResponse
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
