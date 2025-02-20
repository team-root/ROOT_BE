package org.example.root_be.domain.post.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.detail.domain.VolunteerDetail
import org.example.root_be.domain.detail.domain.repository.VolunteerDetailRepository
import org.example.root_be.domain.role.domain.VolunteerRole
import org.example.root_be.domain.role.domain.repository.RoleRepository
import org.example.root_be.domain.post.domain.VolunteerPost
import org.example.root_be.domain.post.domain.repository.VolunteerPostRepository
import org.example.root_be.domain.post.presentation.dto.request.GenerateVolunteerPostRequest
import org.example.root_be.domain.day_of_week.domain.DayOfWeek
import org.example.root_be.domain.day_of_week.domain.repository.DayOfWeekRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GenerateVolunteerPostService(
    private val volunteerPostRepository: VolunteerPostRepository,
    private val roleRepository: RoleRepository,
    private val volunteerDetailRepository: VolunteerDetailRepository,
    private val postDayRepository: DayOfWeekRepository
) {
    @Transactional
    fun execute(
        request: GenerateVolunteerPostRequest
    ) {
        val applicationDate = request.applicationPeriod.first()
        val workDate = request.workDate?.firstOrNull()

        val detail =
            request.run {
                VolunteerDetail(
                    activityDetails = activityDetails,
                    place = place,
                    time = time,
                )
            }


        val volunteerPost =
            request.run {
                VolunteerPost(
                    isRegular = isRegular,
                    title = title,
                    volunteerDetail = detail,
                    applicationStartDate = applicationDate.startDate,
                    applicationEndDate = applicationDate.endDate,
                    workStartDate = workDate?.startDate,
                    workEndDate = workDate?.endDate,
                    personnel = personnel,
                    createdAt = LocalDateTime.now(),
                )
            }

        val dayOfWeek =
            request.dayOfWeek.map {
                DayOfWeek(
                    dayOfWeek = it.dayOfWeek,
                    volunteerPost = volunteerPost
                )
            }

        saveRoles(request, volunteerPost)
        postDayRepository.saveAll(dayOfWeek)
        volunteerDetailRepository.save(detail)
        volunteerPostRepository.save(volunteerPost)
    }

    @Transactional
    fun saveRoles(
        request: GenerateVolunteerPostRequest,
        volunteerPost: VolunteerPost
    ) {
        val roleList = request.role.map { role ->
            VolunteerRole(
                id = role.id,
                title = role.title,
                volunteerPost = volunteerPost
            )
        }
        roleList.map { roleRepository.save(it) }
    }
}