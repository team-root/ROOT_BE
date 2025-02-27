package org.example.root_be.domain.post.presentation

import jakarta.validation.Valid
import org.example.root_be.domain.post.presentation.dto.request.GenerateVolunteerPostRequest
import org.example.root_be.domain.post.presentation.dto.request.ModifyVolunteerPostRequest
import org.example.root_be.domain.post.presentation.dto.response.GetVolunteerPostResponse
import org.example.root_be.domain.post.presentation.dto.response.GetVolunteerPostsResponse
import org.example.root_be.domain.post.service.*
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
@Validated
class VolunteerController(
    private val generateVolunteerPostService: GenerateVolunteerPostService,
    private val getVolunteerPostsService: GetVolunteerPostListService,
    private val getVolunteerPostService: GetVolunteerPostDetailsService,
    private val modifyVolunteerPostService: ModifyVolunteerPostService,
    private val deleteVolunteerPostService: DeleteVolunteerPostService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun generateVolunteerPost(
        @Valid
        @RequestBody request: GenerateVolunteerPostRequest
    ) {
        generateVolunteerPostService.execute(request)
    }

    @GetMapping
    fun getVolunteerPosts(): GetVolunteerPostsResponse {
        return getVolunteerPostsService.execute()
    }

    @GetMapping("/{postId}")
    fun getVolunteerPost(
        @PathVariable postId: Long
    ): GetVolunteerPostResponse {
        return getVolunteerPostService.execute(postId)
    }

    @PatchMapping("/{postId}")
    fun modifyVolunteerPost(
        @PathVariable postId: Long,
        @Valid
        @RequestBody request: ModifyVolunteerPostRequest
    ) {
        modifyVolunteerPostService.execute(postId, request)
    }

    @DeleteMapping("/{postId}")
    fun deleteVolunteerPost(
        @PathVariable postId: Long
    ) {
        deleteVolunteerPostService.execute(postId)
    }
}