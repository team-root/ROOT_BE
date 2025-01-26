package org.example.root_be.domain.post.service

import org.example.root_be.domain.post.domain.repository.VolunteerPostRepository
import org.example.root_be.domain.post.presentation.dto.response.GetVolunteerPostsResponse
import org.springframework.stereotype.Service

@Service
class GetVolunteerPostListService(
    private val volunteerPostRepository: VolunteerPostRepository
) {
    fun execute(): GetVolunteerPostsResponse {
        return GetVolunteerPostsResponse(
            volunteerPostRepository.findBy()
                .map { GetVolunteerPostsResponse.VolunteerPostsElement(it) }
        )
    }
}