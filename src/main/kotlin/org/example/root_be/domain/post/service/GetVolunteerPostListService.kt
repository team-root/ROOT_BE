package org.example.root_be.domain.post.service

import org.example.root_be.domain.post.domain.repository.VolunteerPostRepository
import org.example.root_be.domain.post.presentation.dto.response.GetVolunteerPostsResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetVolunteerPostListService(
    private val volunteerPostRepository: VolunteerPostRepository,
) {
    @Transactional(readOnly = true)
    fun execute(): GetVolunteerPostsResponse {
        return GetVolunteerPostsResponse(
            volunteerPostRepository.findBy()
                .map { GetVolunteerPostsResponse.VolunteerPostsElement(it) },
        )
    }
}
