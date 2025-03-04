package org.example.rootbe.domain.applications.facade

import org.example.rootbe.domain.applications.domain.VolunteerApplication
import org.example.rootbe.domain.applications.domain.repository.VolunteerApplicationRepository
import org.example.rootbe.domain.applications.exception.ApplicationNotFoundException
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
