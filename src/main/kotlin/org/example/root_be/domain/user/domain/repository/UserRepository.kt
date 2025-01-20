package org.example.root_be.domain.user.domain.repository

import org.example.root_be.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>