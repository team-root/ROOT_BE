package org.example.root_be.domain.post.presentation

import org.example.root_be.domain.post.presentation.dto.request.GenerateVolunteerPostRequest
import org.example.root_be.domain.post.presentation.dto.response.GetVolunteerPostResponse
import org.example.root_be.domain.post.presentation.dto.response.GetVolunteerPostsResponse
import org.example.root_be.domain.post.service.GenerateVolunteerPostService
import org.example.root_be.domain.post.service.GetVolunteerPostDetailsService
import org.example.root_be.domain.post.service.GetVolunteerPostListService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class VolunteerController(
    private val generateVolunteerPostService: GenerateVolunteerPostService,
    private val getVolunteerPostsService: GetVolunteerPostListService,
    private val getVolunteerPostService: GetVolunteerPostDetailsService
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

    @GetMapping("/{postId}")
    fun getVolunteerPost(@PathVariable postId: Long): GetVolunteerPostResponse {
        return getVolunteerPostService.execute(postId)
    }
}