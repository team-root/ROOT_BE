package org.example.root_be.domain.user.domain

import jakarta.persistence.*
import org.example.root_be.domain.applications.domain.VolunteerApplication
import org.example.root_be.domain.role.domain.VolunteerRole
import org.example.root_be.domain.teacher_role.domain.TeacherRole
import org.example.root_be.domain.user.domain.type.Role

@Entity
@Table(name = "USER")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "dsm_id", nullable = false)
    var dsmId: String,

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
    var totalVolunteerTime: Int,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val volunteerApplications: List<VolunteerApplication> = listOf(),

    @OneToMany(mappedBy = "teacher_role", cascade = [CascadeType.ALL], orphanRemoval = true)
    val teacherRoles: List<TeacherRole> = listOf(),

    @Column(name = "fcm_token")
    var fcmToken: String?
) {
    fun addVolunteerTime(time: Int) {
        this.totalVolunteerTime += time
    }
}