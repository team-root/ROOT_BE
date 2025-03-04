package org.example.rootbe.domain.user.service

import jakarta.transaction.Transactional
import org.example.rootbe.domain.activity.domain.repository.VolunteerActivityRepository
import org.example.rootbe.domain.user.presentation.dto.response.StudentVolunteerActivityResponse
import org.example.rootbe.domain.user.presentation.dto.response.VolunteerElement
import org.springframework.stereotype.Service

@Service
class StudentVolunteerActivityService(
    private val volunteerActivityRepository: VolunteerActivityRepository,
) {
    @Transactional
    fun execute(userId: Long): StudentVolunteerActivityResponse {
        val volunteerList =
            volunteerActivityRepository.findAllByUserId(userId)
                .map { activity ->
                    VolunteerElement(
                        volunteerTime = activity.volunteerDetail.time,
                        volunteerAct = activity.volunteerDetail.activityDetails,
                    )
                }

        return StudentVolunteerActivityResponse(
            volunteerList = volunteerList,
        )
    }
}
