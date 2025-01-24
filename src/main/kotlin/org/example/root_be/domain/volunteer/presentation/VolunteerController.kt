package org.example.root_be.domain.volunteer.presentation

import org.example.root_be.domain.volunteer.presentation.dto.request.GenerateVolunteerPostRequest
import org.example.root_be.domain.volunteer.presentation.dto.response.GetVolunteerPostsResponse
import org.example.root_be.domain.volunteer.service.GenerateVolunteerPostService
import org.example.root_be.domain.volunteer.service.GetVolunteerPostsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class VolunteerController(
    private val generateVolunteerPostService: GenerateVolunteerPostService,
    private val getVolunteerPostsService: GetVolunteerPostsService
) {
    @PostMapping
    fun generateVolunteerPost(
        @RequestBody request: GenerateVolunteerPostRequest
    ) {
        generateVolunteerPostService.execute(request)
    }

    @GetMapping
    fun getVolunteerPosts(): GetVolunteerPostsResponse {
        return getVolunteerPostsService.execute()
    }
}