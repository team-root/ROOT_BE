package org.example.root_be.domain.applications.presentation

import org.example.root_be.domain.applications.presentation.dto.response.ApplyVolunteerResponse
import org.example.root_be.domain.applications.service.ApplyVolunteerService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/volunteer/applications")
class ApplicationsController(
    private val applyVolunteerService: ApplyVolunteerService,
){
    @PostMapping("/{postId}")
    fun applyVolunteer(@PathVariable postId: Long): ApplyVolunteerResponse = applyVolunteerService.execute(postId)
}