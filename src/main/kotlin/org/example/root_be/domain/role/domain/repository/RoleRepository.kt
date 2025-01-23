package org.example.root_be.domain.role.domain.repository

import org.example.root_be.domain.role.domain.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<Role, Long>