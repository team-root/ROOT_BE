package org.example.root_be.domain.teacher_role.domain.repository

import org.example.root_be.domain.teacher_role.domain.TeacherRole
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeacherRoleRepository : JpaRepository<TeacherRole, Long> {
}