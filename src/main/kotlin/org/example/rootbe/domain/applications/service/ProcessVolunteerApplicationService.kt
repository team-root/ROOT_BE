package org.example.rootbe.domain.applications.service

import jakarta.transaction.Transactional
import org.example.rootbe.domain.applications.facade.VolunteerApplicationFacade
import org.example.rootbe.domain.applications.presentation.dto.request.ProcessVolunteerApplicationRequest
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
