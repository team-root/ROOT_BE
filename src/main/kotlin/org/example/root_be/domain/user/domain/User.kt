package org.example.root_be.domain.user.domain

import jakarta.persistence.*
import org.example.root_be.domain.user.domain.type.Role

@Entity
@Table(name = "USER")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false)
    var name: String,

    @Column(unique = true, nullable = false)
    val num: Int,

    @Column(nullable = false)
    var grade: Int,

    @Column(name = "class_num", nullable = false)
    var classNum: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    var userRole: Role,

    @Column(name = "total_volunteer_time", nullable = false)
    var totalVolunteerTime: Int
)