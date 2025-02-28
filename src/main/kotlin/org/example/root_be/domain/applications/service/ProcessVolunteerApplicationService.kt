package org.example.root_be.domain.applications.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.applications.facade.VolunteerApplicationFacade
import org.example.root_be.domain.applications.presentation.dto.request.ProcessVolunteerApplicationRequest
import org.springframework.stereotype.Service

@Service
class ProcessVolunteerApplicationService(
    private val volunteerApplicationFacade: VolunteerApplicationFacade,
) {
    @Transactional
    fun execute(processVolunteerApplicationRequest: ProcessVolunteerApplicationRequest) {
        volunteerApplicationFacade.getVolunteerApplicationById(
            processVolunteerApplicationRequest.applicationId,
        ).isAccepted = processVolunteerApplicationRequest.isAccepted
    }
}
