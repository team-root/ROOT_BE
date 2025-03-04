package org.example.rootbe.domain.user.domain.repository

import org.example.rootbe.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByDsmId(dsmId: String): User?

    fun findAllByIdIn(ids: List<Long>): List<User>
}
