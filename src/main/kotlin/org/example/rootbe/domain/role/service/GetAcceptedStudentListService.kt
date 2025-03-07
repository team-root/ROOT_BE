package org.example.rootbe.domain.role.service

import org.example.rootbe.domain.applications.domain.repository.VolunteerApplicationRepository
import org.example.rootbe.domain.role.presentation.response.GetAcceptedStudentsResponse
import org.example.rootbe.domain.post.facade.VolunteerPostFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetAcceptedStudentListService(
    private val postFacade: VolunteerPostFacade,
    private val volunteerApplicationRepository: VolunteerApplicationRepository,
) {
    @Transactional(readOnly = true)
    fun execute(postId: Long): GetAcceptedStudentsResponse {
        val post = postFacade.getVolunteerPostById(postId)
        val roles = post.roles
        val applications = volunteerApplicationRepository.findAllByVolunteerPost(post)
        val acceptedStudents = applications.filter { it.isAccepted }.map { it.user }

        return GetAcceptedStudentsResponse(
            acceptedStudents.map {
                GetAcceptedStudentsResponse.AcceptedStudentsResponse(
                    userId = it.id,
                    name = it.name,
                    grade = it.grade
                )
            },
            roles.map { it.title }
        )
    }
}