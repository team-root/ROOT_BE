package org.example.rootbe.domain.applications.service

import jakarta.transaction.Transactional
import org.example.rootbe.domain.applications.domain.VolunteerApplication
import org.example.rootbe.domain.applications.domain.repository.VolunteerApplicationRepository
import org.example.rootbe.domain.applications.presentation.dto.response.ApplyVolunteerResponse
import org.example.rootbe.domain.post.facade.VolunteerPostFacade
import org.example.rootbe.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class ApplyVolunteerService(
    private val volunteerApplicationRepository: VolunteerApplicationRepository,
    private val userFacade: UserFacade,
    private val volunteerPostFacade: VolunteerPostFacade,
) {
    @Transactional
    fun execute(postId: Long): ApplyVolunteerResponse {
        val user = userFacade.getCurrentUser()
        val post = volunteerPostFacade.getVolunteerPostById(postId)

        val savedApplication =
            volunteerApplicationRepository.save(
                VolunteerApplication(
                    user = user,
                    volunteerPost = post,
                ),
            )

        return ApplyVolunteerResponse(
            applicationId = savedApplication.id,
            userId = user.id,
            postId = post.id,
        )
    }
}
