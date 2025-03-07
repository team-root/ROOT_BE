package org.example.rootbe.domain.applications.presentation

import jakarta.validation.Valid
import org.example.rootbe.domain.applications.presentation.dto.request.ProcessVolunteerApplicationRequest
import org.example.rootbe.domain.applications.presentation.dto.response.ApplyVolunteerResponse
import org.example.rootbe.domain.applications.presentation.dto.response.GetVolunteerApplicationResponse
import org.example.rootbe.domain.applications.service.ApplyVolunteerService
import org.example.rootbe.domain.applications.service.GetVolunteerApplicationService
import org.example.rootbe.domain.applications.service.ProcessVolunteerApplicationService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/volunteer/applications")
@Validated
class ApplicationsController(
    private val applyVolunteerService: ApplyVolunteerService,
    private val getVolunteerApplicationService: GetVolunteerApplicationService,
    private val processVolunteerApplicationService: ProcessVolunteerApplicationService,
) {
    @PostMapping("/{postId}")
    fun applyVolunteer(
        @PathVariable postId: Long,
    ): ApplyVolunteerResponse = applyVolunteerService.execute(postId)

    @GetMapping("/{postId}")
    fun getVolunteerApplication(
        @PathVariable postId: Long,
    ): GetVolunteerApplicationResponse = getVolunteerApplicationService.execute(postId)

    @PostMapping("/status")
    fun processVolunteerApplication(
        @Valid
        @RequestBody processVolunteerApplicationRequest: ProcessVolunteerApplicationRequest,
    ) = processVolunteerApplicationService.execute(processVolunteerApplicationRequest)
}
