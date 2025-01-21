package org.example.root_be.domain.user.facade

import org.example.root_be.domain.user.domain.User
import org.example.root_be.domain.user.domain.repository.UserRepository
import org.example.root_be.domain.user.exception.UserNotFoundException
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {
    fun getUserById(id: Long): User =
        userRepository.findById(id)
            .orElseThrow { throw UserNotFoundException() }
}