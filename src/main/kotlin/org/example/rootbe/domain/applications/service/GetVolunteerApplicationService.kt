package org.example.rootbe.domain.applications.service

import org.example.rootbe.domain.applications.domain.repository.VolunteerApplicationRepository
import org.example.rootbe.domain.applications.presentation.dto.response.ApplicationElement
import org.example.rootbe.domain.applications.presentation.dto.response.GetVolunteerApplicationResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetVolunteerApplicationService(
    private val volunteerApplicationRepository: VolunteerApplicationRepository,
) {
    @Transactional(readOnly = true)
    fun execute(postId: Long): GetVolunteerApplicationResponse {
        val applications =
            volunteerApplicationRepository.findAllByVolunteerPostId(postId)
                .map { application ->
                    ApplicationElement(
                        applicationId = application.id,
                        userId = application.user.id,
                        grade = application.user.grade,
                        number = application.user.num,
                        classNum = application.user.classNum,
                        name = application.user.name,
                    )
                }

        return GetVolunteerApplicationResponse(applications)
    }
}
