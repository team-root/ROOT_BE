package org.example.root_be.domain.user.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.activity.domain.VolunteerActivity
import org.example.root_be.domain.activity.domain.repository.VolunteerActivityRepository
import org.example.root_be.domain.detail.domain.VolunteerDetail
import org.example.root_be.domain.detail.domain.repository.VolunteerDetailRepository
import org.example.root_be.domain.user.facade.UserFacade
import org.example.root_be.domain.user.presentation.dto.request.AddStudentVolunteerRecordRequest
import org.springframework.stereotype.Service

@Service
class AddStudentVolunteerRecordService(
    private val volunteerActivityRepository: VolunteerActivityRepository,
    private val userFacade: UserFacade,
    private val volunteerDetailRepository: VolunteerDetailRepository
) {
    @Transactional
    fun execute(request: AddStudentVolunteerRecordRequest) {
        val students = userFacade.getUsersByIds(request.userIds)

        val volunteerDetail = VolunteerDetail(
            activityDetails = request.detail,
            place = request.place,
            time = request.time.toString()
        )
        val savedDetail = volunteerDetailRepository.save(volunteerDetail)

        val activities = students.map { student ->
            VolunteerActivity(
                user = student,
                volunteerDetail = savedDetail,
            )
        }

        volunteerActivityRepository.saveAll(activities)
        students.forEach { it.addVolunteerTime(request.time) }
    }
}