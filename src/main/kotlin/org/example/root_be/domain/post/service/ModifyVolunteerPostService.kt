package org.example.root_be.domain.post.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.post.domain.VolunteerPost
import org.example.root_be.domain.post.domain.repository.VolunteerPostRepository
import org.example.root_be.domain.post.facade.VolunteerFacade
import org.example.root_be.domain.post.presentation.dto.request.ModifyVolunteerPostRequest
import org.example.root_be.domain.role.domain.VolunteerRole
import org.example.root_be.domain.role.domain.repository.RoleRepository
import org.example.root_be.domain.role.exception.VolunteerRoleNotFoundException
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ModifyVolunteerPostService(
    private val volunteerPostRepository: VolunteerPostRepository,
    private val volunteerFacade: VolunteerFacade,
    private val roleRepository: RoleRepository,
) {
    @Transactional
    fun execute(
        postId: Long,
        request: ModifyVolunteerPostRequest
    ) {
        val post = volunteerFacade.getVolunteerPostById(postId)

        val applicationDate = request.applicationPeriod.first()
        val workDate = request.workDate?.firstOrNull()

        post.modifyPost(
            isRegular = request.isRegular,
            title = request.title,
            activityDetails = request.activityDetails,
            applicationStartDate = applicationDate.startDate,
            applicationEndDate = applicationDate.endDate,
            workStartDate = workDate?.startDate,
            workEndDate = workDate?.endDate,
            dayOfWeek = request.dayOfWeek,
            place = request.place,
            time = request.time,
            personnel = request.personnel,
            updatedAt = LocalDateTime.now()
        )

        saveRoles(request, post)
        volunteerPostRepository.save(post)
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
}