package org.example.rootbe.domain.post.presentation

import jakarta.validation.Valid
import org.example.rootbe.domain.post.presentation.dto.request.GenerateVolunteerPostRequest
import org.example.rootbe.domain.post.presentation.dto.request.ModifyVolunteerPostRequest
import org.example.rootbe.domain.post.presentation.dto.response.GetVolunteerPostResponse
import org.example.rootbe.domain.post.presentation.dto.response.GetVolunteerPostsResponse
import org.example.rootbe.domain.post.service.DeleteVolunteerPostService
import org.example.rootbe.domain.post.service.GenerateVolunteerPostService
import org.example.rootbe.domain.post.service.GetVolunteerPostDetailsService
import org.example.rootbe.domain.post.service.GetVolunteerPostListService
import org.example.rootbe.domain.post.service.ModifyVolunteerPostService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
@Validated
class VolunteerPostController(
    private val generateVolunteerPostService: GenerateVolunteerPostService,
    private val getVolunteerPostsService: GetVolunteerPostListService,
    private val getVolunteerPostService: GetVolunteerPostDetailsService,
    private val modifyVolunteerPostService: ModifyVolunteerPostService,
    private val deleteVolunteerPostService: DeleteVolunteerPostService,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun generateVolunteerPost(
        @Valid
        @RequestBody request: GenerateVolunteerPostRequest,
    ) {
        generateVolunteerPostService.execute(request)
    }

    @GetMapping
    fun getVolunteerPosts(): GetVolunteerPostsResponse {
        return getVolunteerPostsService.execute()
    }

    @GetMapping("/{postId}")
    fun getVolunteerPost(
        @PathVariable postId: Long,
    ): GetVolunteerPostResponse {
        return getVolunteerPostService.execute(postId)
    }

    @PatchMapping("/{postId}")
    fun modifyVolunteerPost(
        @PathVariable postId: Long,
        @Valid
        @RequestBody request: ModifyVolunteerPostRequest,
    ) {
        modifyVolunteerPostService.execute(postId, request)
    }

    @DeleteMapping("/{postId}")
    fun deleteVolunteerPost(
        @PathVariable postId: Long,
    ) {
        deleteVolunteerPostService.execute(postId)
    }
}
