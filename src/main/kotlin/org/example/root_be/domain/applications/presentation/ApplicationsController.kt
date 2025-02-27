package org.example.root_be.domain.applications.presentation

import jakarta.validation.Valid
import org.example.root_be.domain.applications.presentation.dto.request.ProcessVolunteerApplicationRequest
import org.example.root_be.domain.applications.presentation.dto.response.ApplyVolunteerResponse
import org.example.root_be.domain.applications.presentation.dto.response.GetVolunteerApplicationResponse
import org.example.root_be.domain.applications.service.ApplyVolunteerService
import org.example.root_be.domain.applications.service.GetVolunteerApplicationService
import org.example.root_be.domain.applications.service.ProcessVolunteerApplicationService
import org.springframework.web.bind.annotation.*

@RestController("/volunteer/applications")
class ApplicationsController(
    private val applyVolunteerService: ApplyVolunteerService,
    private val getVolunteerApplicationService: GetVolunteerApplicationService,
    private val processVolunteerApplicationService: ProcessVolunteerApplicationService,
) {
    @PostMapping("/{postId}")
    fun applyVolunteer(
        @PathVariable postId: Long
    ): ApplyVolunteerResponse = applyVolunteerService.execute(postId)

    @GetMapping("/{postId}")
    fun getVolunteerApplication(
        @PathVariable postId: Long
    ): GetVolunteerApplicationResponse = getVolunteerApplicationService.execute(postId)

    @PostMapping("/status")
    fun processVolunteerApplication(
        @Valid
        @RequestBody processVolunteerApplicationRequest: ProcessVolunteerApplicationRequest
    ) = processVolunteerApplicationService.execute(processVolunteerApplicationRequest)
}