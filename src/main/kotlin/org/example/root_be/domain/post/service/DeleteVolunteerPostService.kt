package org.example.root_be.domain.post.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.post.domain.repository.VolunteerPostRepository
import org.example.root_be.domain.post.facade.VolunteerFacade
import org.springframework.stereotype.Service

@Service
class DeleteVolunteerPostService(
    private val volunteerFacade: VolunteerFacade,
    private val volunteerPostRepository: VolunteerPostRepository
) {
    @Transactional
    fun execute(
        postId: Long
    ) {
        val post = volunteerFacade.getVolunteerPostById(postId)
        volunteerPostRepository.delete(post)
    }
}