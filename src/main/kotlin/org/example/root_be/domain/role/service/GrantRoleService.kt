package org.example.root_be.domain.role.service

import org.example.root_be.domain.post.facade.VolunteerFacade
import org.example.root_be.domain.role.exception.VolunteerRoleNotFoundException
import org.example.root_be.domain.role.presentation.dto.request.GranRoleRequest
import org.example.root_be.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GrantRoleService(
    private val userFacade: UserFacade,
    private val volunteerFacade: VolunteerFacade
) {
    @Transactional
    fun execute(
        postId: Long,
        request: GranRoleRequest
    ) {
        val post = volunteerFacade.getVolunteerPostById(postId)
        val volunteerRoles = post.roles
        val user = userFacade.getUserById(request.userId)

        val volunteerRole = volunteerRoles.find { it.title == request.role }
            ?: throw VolunteerRoleNotFoundException

        user.grantVolunteerRole(volunteerRole)
    }
}