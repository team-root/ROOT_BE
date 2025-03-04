package org.example.rootbe.domain.post.presentation.dto.response

import org.example.rootbe.domain.post.domain.VolunteerPost

data class GetVolunteerPostsResponse(
    val content: List<VolunteerPostsElement>,
) {
    data class VolunteerPostsElement(
        val id: Long,
        val title: String,
    ) {
        constructor(volunteerPost: VolunteerPost) : this(
            id = volunteerPost.id,
            title = volunteerPost.title,
        )
    }
}
