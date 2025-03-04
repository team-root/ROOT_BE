package org.example.rootbe.domain.role.service

import org.example.rootbe.domain.applications.domain.repository.VolunteerApplicationRepository
import org.example.rootbe.domain.applications.exception.ApplicationNotFoundException
import org.example.rootbe.domain.post.facade.VolunteerPostFacade
import org.example.rootbe.domain.role.exception.VolunteerRoleNotFoundException
import org.example.rootbe.domain.role.presentation.dto.request.GranRoleRequest
import org.example.rootbe.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GrantRoleService(
    private val userFacade: UserFacade,
    private val volunteerPostFacade: VolunteerPostFacade,
    private val volunteerApplicationRepository: VolunteerApplicationRepository,
) {
    @Transactional
    fun execute(
        postId: Long,
        request: GranRoleRequest,
    ) {
        val post = volunteerPostFacade.getVolunteerPostById(postId)
        val volunteerRoles = post.roles
        val user = userFacade.getUserById(request.userId)

        val volunteerRole =
            volunteerRoles.find { it.title == request.role }
                ?: throw VolunteerRoleNotFoundException

        val application =
            volunteerApplicationRepository.findByUserAndVolunteerPost(user, post)
                ?: throw ApplicationNotFoundException

        application.volunteerRole = volunteerRole
    }
}
