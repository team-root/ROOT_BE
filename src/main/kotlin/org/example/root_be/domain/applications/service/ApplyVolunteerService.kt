package org.example.root_be.domain.applications.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.applications.domain.VolunteerApplication
import org.example.root_be.domain.applications.domain.repository.VolunteerApplicationRepository
import org.example.root_be.domain.applications.presentation.dto.response.ApplyVolunteerResponse
import org.example.root_be.domain.user.facade.UserFacade
import org.example.root_be.domain.volunteer.domain.repository.VolunteerPostRepository
import org.example.root_be.domain.volunteer.exception.VolunteerPostNotFoundException
import org.springframework.stereotype.Service

@Service
class ApplyVolunteerService(
    private val volunteerApplicationRepository: VolunteerApplicationRepository,
    private val userFacade: UserFacade,
    private val volunteerPostRepository: VolunteerPostRepository
) {
    @Transactional
    fun execute(postId: Long): ApplyVolunteerResponse {
        val user = userFacade.getCurrentUser()
        val post = volunteerPostRepository.findById(postId)
            .orElseThrow() { VolunteerPostNotFoundException }

        val application = VolunteerApplication(
            user = user,
            volunteerPost = post
        )

        val savedApplication = volunteerApplicationRepository.save(application)

        return ApplyVolunteerResponse(
            applicationId = savedApplication.id,
            userId = user.id,
            postId = post.id
        )
    }
}
