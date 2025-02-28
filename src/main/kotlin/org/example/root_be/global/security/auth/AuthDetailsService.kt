package org.example.root_be.global.security.auth

import org.example.root_be.domain.user.facade.UserFacade
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userFacade: UserFacade,
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userFacade.getUserById(username.toLong())
        return AuthDetails(user)
    }
}
