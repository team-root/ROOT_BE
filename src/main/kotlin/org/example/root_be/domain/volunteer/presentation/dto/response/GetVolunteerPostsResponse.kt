package org.example.root_be.domain.volunteer.presentation.dto.response

import org.example.root_be.domain.volunteer.domain.VolunteerPost

data class GetVolunteerPostsResponse(
    val content: List<VolunteerPostsElement>
) {
    data class VolunteerPostsElement(
        val id: Long,
        val title: String
    ) {
        constructor(volunteerPost: VolunteerPost): this(
            id = volunteerPost.id,
            title = volunteerPost.title
        )
    }
}
