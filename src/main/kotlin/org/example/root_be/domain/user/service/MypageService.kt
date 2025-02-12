package org.example.root_be.domain.user.service

import org.example.root_be.domain.user.domain.type.Role
import org.example.root_be.domain.user.facade.UserFacade
import org.example.root_be.domain.user.presentation.dto.response.MypageResponse
import org.springframework.stereotype.Service

@Service
class MypageService(
    private val userFacade: UserFacade
) {
    fun execute(): MypageResponse = userFacade.getCurrentUser().let { user ->
        when (user.userRole) {
            Role.STUDENT -> MypageResponse(
                name = user.name,
                number = user.num,
                area = user.area,
                volunteerTime = user.totalVolunteerTime
            )
            Role.ADMIN -> MypageResponse(
                name = user.name,
                number = null,
                area = user.area,
                volunteerTime = null
            )
        }
    }
}