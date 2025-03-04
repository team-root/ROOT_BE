package org.example.rootbe.domain.user.service

import jakarta.transaction.Transactional
import org.example.rootbe.domain.activity.domain.repository.VolunteerActivityRepository
import org.example.rootbe.domain.user.facade.UserFacade
import org.example.rootbe.domain.user.presentation.dto.response.MyVolunteerActivityResponse
import org.example.rootbe.domain.user.presentation.dto.response.VolunteerElement
import org.springframework.stereotype.Service

@Service
class MyVolunteerActivityService(
    private val volunteerActivityRepository: VolunteerActivityRepository,
    private val userFacade: UserFacade,
) {
    @Transactional
    fun execute(): MyVolunteerActivityResponse {
        val user = userFacade.getCurrentUser()
        val volunteerList =
            volunteerActivityRepository.findAllByUserId(user.id)
                .map { activity ->
                    VolunteerElement(
                        volunteerTime = activity.volunteerDetail.time,
                        volunteerAct = activity.volunteerDetail.activityDetails,
                    )
                }

        return MyVolunteerActivityResponse(
            totalVolunteerTime = user.totalVolunteerTime,
            volunteerList = volunteerList,
        )
    }
}
