package org.example.root_be.domain.volunteer.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.role.domain.Role
import org.example.root_be.domain.role.domain.repository.RoleRepository
import org.example.root_be.domain.volunteer.domain.VolunteerPost
import org.example.root_be.domain.volunteer.domain.repository.VolunteerPostRepository
import org.example.root_be.domain.volunteer.presentation.dto.request.GenerateVolunteerPostRequest
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GenerateVolunteerPostService(
    private val volunteerPostRepository: VolunteerPostRepository,
    private val roleRepository: RoleRepository
) {
    @Transactional
    fun execute(
        request: GenerateVolunteerPostRequest
    ) {
        val applicationDate = request.applicationPeriod.first()
        val workDate = request.workDate?.firstOrNull()

        val volunteerPost =
            request.run {
                VolunteerPost(
                    isRegular = isRegular,
                    title = title,
                    activityDetails = activityDetails,
                    applicationStartDate = applicationDate.startDate,
                    applicationEndDate = applicationDate.endDate,
                    workStartDate = workDate?.startDate,
                    workEndDate = workDate?.endDate,
                    dayOfWeek = dayOfWeek,
                    place = place,
                    time = time,
                    personnel = personnel,
                    createAt = LocalDateTime.now(),
                )
            }

        volunteerPostRepository.save(volunteerPost)
        saveRoles(request, volunteerPost)
    }

    @Transactional
    fun saveRoles(
        request: GenerateVolunteerPostRequest,
        volunteerPost: VolunteerPost
    ) {
        val roleList = request.role.map { role ->
            Role(
                id = role.id,
                title = role.title,
                volunteerPost = volunteerPost
            )
        }
        roleList.map { roleRepository.save(it) }
    }
}