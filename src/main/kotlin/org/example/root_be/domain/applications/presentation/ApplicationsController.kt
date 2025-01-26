package org.example.root_be.domain.applications.presentation

import org.example.root_be.domain.applications.presentation.dto.response.ApplyVolunteerResponse
import org.example.root_be.domain.applications.presentation.dto.response.GetVolunteerApplicationResponse
import org.example.root_be.domain.applications.service.ApplyVolunteerService
import org.example.root_be.domain.applications.service.GetVolunteerApplicationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/volunteer/applications")
class ApplicationsController(
    private val applyVolunteerService: ApplyVolunteerService,
    private val getVolunteerApplicationService: GetVolunteerApplicationService,
){
    @PostMapping("/{postId}")
    fun applyVolunteer(
        @PathVariable postId: Long
    ): ApplyVolunteerResponse = applyVolunteerService.execute(postId)

    @GetMapping("/{postId}")
    fun getVolunteerApplication(
        @PathVariable postId: Long
    ): GetVolunteerApplicationResponse = getVolunteerApplicationService.execute(postId)
}