package org.example.root_be.domain.user.facade

import org.example.root_be.domain.user.domain.User
import org.example.root_be.domain.user.domain.repository.UserRepository
import org.example.root_be.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {
    fun getUserById(id: Long): User =
        userRepository.findById(id)
            .orElseThrow { throw UserNotFoundException }

    fun getUsersByIds(userIds: List<Long>): List<User> =
        userRepository.findAllByIdIn(userIds)
            .ifEmpty { throw UserNotFoundException }

    fun getCurrentUser(): User {
        val id = SecurityContextHolder.getContext().authentication.name
        return getUserById(id.toLong())
    }
}