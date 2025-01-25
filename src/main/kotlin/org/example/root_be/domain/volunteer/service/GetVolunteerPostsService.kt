package org.example.root_be.domain.volunteer.service

import org.example.root_be.domain.volunteer.domain.repository.VolunteerPostRepository
import org.example.root_be.domain.volunteer.presentation.dto.response.GetVolunteerPostsResponse
import org.springframework.stereotype.Service

@Service
class GetVolunteerPostsService(
    private val volunteerPostRepository: VolunteerPostRepository
) {
    fun execute(): GetVolunteerPostsResponse {
        return GetVolunteerPostsResponse(
            volunteerPostRepository.findBy()
                .map { GetVolunteerPostsResponse.VolunteerPostsElement(it) }
        )
    }
}