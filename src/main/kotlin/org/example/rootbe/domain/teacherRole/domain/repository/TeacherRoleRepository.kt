package org.example.rootbe.domain.teacherRole.domain.repository

import org.example.rootbe.domain.teacherRole.domain.TeacherRole
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeacherRoleRepository : JpaRepository<TeacherRole, Long>
