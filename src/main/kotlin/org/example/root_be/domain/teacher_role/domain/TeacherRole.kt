package org.example.root_be.domain.teacher_role.domain

import jakarta.persistence.*
import org.example.root_be.domain.user.domain.User

@Entity
@Table(name = "TEACHER_ROLE")
class TeacherRole(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @Column(nullable = false)
    val title: String
)