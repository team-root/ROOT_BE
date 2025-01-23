package org.example.root_be.domain.volunteer.presentation

import org.example.root_be.domain.volunteer.presentation.dto.request.GenerateVolunteerPostRequest
import org.example.root_be.domain.volunteer.service.GenerateVolunteerPostService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class VolunteerController(
    private val generateVolunteerPostService: GenerateVolunteerPostService
) {
    @PostMapping
    fun generateVolunteerPost(
        request: GenerateVolunteerPostRequest
    ) {
        generateVolunteerPostService.execute(request)
    }
}