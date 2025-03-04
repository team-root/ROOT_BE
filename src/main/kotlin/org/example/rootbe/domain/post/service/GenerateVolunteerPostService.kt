package org.example.rootbe.domain.post.service

import jakarta.transaction.Transactional
import org.example.rootbe.domain.detail.domain.VolunteerDetail
import org.example.rootbe.domain.detail.domain.repository.VolunteerDetailRepository
import org.example.rootbe.domain.post.domain.VolunteerPost
import org.example.rootbe.domain.post.domain.repository.VolunteerPostRepository
import org.example.rootbe.domain.post.presentation.dto.request.GenerateVolunteerPostRequest
import org.example.rootbe.domain.role.domain.VolunteerRole
import org.example.rootbe.domain.role.domain.repository.RoleRepository
import org.example.rootbe.domain.weekDays.domain.WeekDays
import org.example.rootbe.domain.weekDays.domain.repository.WeekDaysRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GenerateVolunteerPostService(
    private val volunteerPostRepository: VolunteerPostRepository,
    private val roleRepository: RoleRepository,
    private val volunteerDetailRepository: VolunteerDetailRepository,
    private val postDayRepository: WeekDaysRepository,
) {
    @Transactional
    fun execute(request: GenerateVolunteerPostRequest) {
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

        val weekDays =
            request.dayOfWeek.map {
                WeekDays(
                    dayOfWeek = it.dayOfWeek,
                    volunteerPost = volunteerPost,
                )
            }

        saveRoles(request, volunteerPost)
        postDayRepository.saveAll(weekDays)
        volunteerDetailRepository.save(detail)
        volunteerPostRepository.save(volunteerPost)
    }

    @Transactional
    fun saveRoles(
        request: GenerateVolunteerPostRequest,
        volunteerPost: VolunteerPost,
    ) {
        val roleList =
            request.role.map { role ->
                VolunteerRole(
                    id = role.id,
                    title = role.title,
                    volunteerPost = volunteerPost,
                )
            }
        roleList.map { roleRepository.save(it) }
    }
}
