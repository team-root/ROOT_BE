package org.example.root_be.domain.applications.facade

import org.example.root_be.domain.applications.domain.VolunteerApplication
import org.example.root_be.domain.applications.domain.repository.VolunteerApplicationRepository
import org.example.root_be.domain.applications.exception.ApplicationNotFoundException
import org.springframework.stereotype.Component

@Component
class VolunteerApplicationFacade(
    private val volunteerApplicationRepository: VolunteerApplicationRepository,
) {
    fun getVolunteerApplicationById(applicationId: Long): VolunteerApplication {
        return volunteerApplicationRepository.findById(applicationId)
            .orElseThrow { ApplicationNotFoundException }
    }
}
