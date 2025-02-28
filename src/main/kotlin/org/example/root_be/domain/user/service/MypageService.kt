package org.example.root_be.domain.user.service

import org.example.root_be.domain.user.domain.type.Role
import org.example.root_be.domain.user.facade.UserFacade
import org.example.root_be.domain.user.presentation.dto.response.MypageResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MypageService(
    private val userFacade: UserFacade
) {
    @Transactional(readOnly = true)
    fun execute(): MypageResponse {
        return userFacade.getCurrentUser().let { user ->
            when (user.userRole) {
                Role.STUDENT -> MypageResponse(
                    name = user.name,
                    number = user.num,
                    area = user.volunteerApplications
                        .mapNotNull { application -> application.volunteerRole?.title }
                        .distinct(),
                    volunteerTime = user.totalVolunteerTime
                )

                Role.ADMIN -> MypageResponse(
                    name = user.name,
                    number = null,
                    area = user.teacherRoles
                        .map { role -> role.title }
                        .distinct(),
                    volunteerTime = null
                )
            }
        }
    }
}