package org.example.root_be.domain.post.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.detail.domain.repository.VolunteerDetailRepository
import org.example.root_be.domain.detail.facade.DetailFacade
import org.example.root_be.domain.post.domain.VolunteerPost
import org.example.root_be.domain.post.domain.repository.VolunteerPostRepository
import org.example.root_be.domain.post.facade.VolunteerPostFacade
import org.example.root_be.domain.post.presentation.dto.request.ModifyVolunteerPostRequest
import org.example.root_be.domain.week_days.domain.WeekDays
import org.example.root_be.domain.week_days.domain.repository.WeekDaysRepository
import org.example.root_be.domain.week_days.exception.WeekDaysNotFoundException
import org.example.root_be.domain.role.domain.VolunteerRole
import org.example.root_be.domain.role.domain.repository.RoleRepository
import org.example.root_be.domain.role.exception.VolunteerRoleNotFoundException
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ModifyVolunteerPostService(
    private val volunteerPostRepository: VolunteerPostRepository,
    private val volunteerPostFacade: VolunteerPostFacade,
    private val roleRepository: RoleRepository,
    private val detailFacade: DetailFacade,
    private val volunteerDetailRepository: VolunteerDetailRepository,
    private val postDayRepository: WeekDaysRepository
) {
    @Transactional
    fun execute(
        postId: Long,
        request: ModifyVolunteerPostRequest
    ) {
        val post = volunteerPostFacade.getVolunteerPostById(postId)

        val applicationDate = request.applicationPeriod.first()
        val workDate = request.workDate?.firstOrNull()

        post.modifyPost(
            isRegular = request.isRegular,
            title = request.title,
            applicationStartDate = applicationDate.startDate,
            applicationEndDate = applicationDate.endDate,
            workStartDate = workDate?.startDate,
            workEndDate = workDate?.endDate,
            personnel = request.personnel,
            updatedAt = LocalDateTime.now()
        )

        saveDetail(request, post)
        saveRoles(request, post)
        saveDayOfWeek(request, post)
        volunteerPostRepository.save(post)
    }

    @Transactional
    fun saveDetail(
        request: ModifyVolunteerPostRequest,
        post: VolunteerPost
    ) {
        val detail = detailFacade.getVolunteerDetailsByPostId(post.id)
        request.run {
            detail.modifyDetail(
                activityDetails = activityDetails,
                place = place,
                time = time
            )
        }
        volunteerDetailRepository.save(detail)
    }

    @Transactional
    fun saveRoles(
        request: ModifyVolunteerPostRequest,
        post: VolunteerPost
    ) {
        val requestedRoleIds = request.role
            .mapNotNull { it.roleId }
            .toSet()

        val existingRoles = roleRepository.findAllByVolunteerPost(post)

        val rolesToDelete = existingRoles.filter { it.id !in requestedRoleIds }
        roleRepository.deleteAll(rolesToDelete)

        val newRoles = mutableListOf<VolunteerRole>()

        request.role.forEach { roleRequest ->
            when (val id = roleRequest.roleId) {
                null -> newRoles.add(
                    VolunteerRole(
                        id = 0,
                        title = roleRequest.title,
                        volunteerPost = post
                    )
                )
                else -> existingRoles.find { it.id == id }
                    ?.apply { title = roleRequest.title }
                    ?: throw VolunteerRoleNotFoundException
            }
        }

        if (newRoles.isNotEmpty()) {
            roleRepository.saveAll(newRoles)
        }
    }

    @Transactional
    fun saveDayOfWeek(
        request: ModifyVolunteerPostRequest,
        post: VolunteerPost
    ) {
        val modifyDayOfWeekIds = request.dayOfWeek
            ?.map { it.dayId }?.toSet()
            ?: setOf()

        val existingPostDays = postDayRepository.findAllByVolunteerPost(post)

        val deleteDayOfWeeks = existingPostDays.filter { (it.id !in modifyDayOfWeekIds) }
        postDayRepository.deleteAll(deleteDayOfWeeks)

        val addWeekDays = mutableListOf<WeekDays>()

        request.dayOfWeek?.forEach { dayOfWeekRequest ->
            existingPostDays.find {it.id == dayOfWeekRequest.dayId}
                ?.apply { dayOfWeek = dayOfWeekRequest.dayOfWeek }
                ?: throw WeekDaysNotFoundException
        }

        if (addWeekDays.isNotEmpty()) {
            postDayRepository.saveAll(addWeekDays)
        }
    }
}