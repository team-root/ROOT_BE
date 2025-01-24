package org.example.root_be.domain.user.service

import org.example.root_be.domain.user.facade.UserFacade
import org.example.root_be.domain.user.presentation.dto.response.MypageResponse
import org.springframework.stereotype.Service

@Service
class MypageService (
    private val userFacade: UserFacade
){
    fun execute(): MypageResponse = userFacade.getCurrentUser().let { user ->
        MypageResponse(
            studentNumber = user.num,
            studentName = user.name,
            volunteerTime = user.totalVolunteerTime
        )
    }
}