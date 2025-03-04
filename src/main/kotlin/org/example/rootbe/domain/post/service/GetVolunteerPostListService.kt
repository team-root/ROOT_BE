package org.example.rootbe.domain.post.service

import org.example.rootbe.domain.post.domain.repository.VolunteerPostRepository
import org.example.rootbe.domain.post.presentation.dto.response.GetVolunteerPostsResponse
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
