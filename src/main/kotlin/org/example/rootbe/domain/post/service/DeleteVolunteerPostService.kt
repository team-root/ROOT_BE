package org.example.rootbe.domain.post.service

import jakarta.transaction.Transactional
import org.example.rootbe.domain.post.domain.repository.VolunteerPostRepository
import org.example.rootbe.domain.post.facade.VolunteerPostFacade
import org.springframework.stereotype.Service

@Service
class DeleteVolunteerPostService(
    private val volunteerPostFacade: VolunteerPostFacade,
    private val volunteerPostRepository: VolunteerPostRepository,
) {
    @Transactional
    fun execute(postId: Long) {
        val post = volunteerPostFacade.getVolunteerPostById(postId)
        volunteerPostRepository.delete(post)
    }
}
