package org.example.root_be.domain.applications.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.applications.domain.repository.VolunteerApplicationRepository
import org.example.root_be.domain.applications.presentation.dto.response.ApplicationElement
import org.example.root_be.domain.applications.presentation.dto.response.GetVolunteerApplicationResponse
import org.springframework.stereotype.Service

@Service
class GetVolunteerApplicationService(
    private val volunteerApplicationRepository: VolunteerApplicationRepository,
) {
    @Transactional
    fun execute(postId: Long): GetVolunteerApplicationResponse {
        val applications = volunteerApplicationRepository.findAllByVolunteerPostId(postId)
            .map { application ->
                ApplicationElement(
                    applicationId = application.id,
                    userId = application.user.id,
                    grade = application.user.grade,
                    number = application.user.num,
                    classNum = application.user.classNum,
                    name = application.user.name
                )
            }

        return GetVolunteerApplicationResponse(applications)
    }
}