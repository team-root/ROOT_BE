package org.example.root_be.domain.role.domain.repository

import org.example.root_be.domain.role.domain.VolunteerRole
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<VolunteerRole, Long>