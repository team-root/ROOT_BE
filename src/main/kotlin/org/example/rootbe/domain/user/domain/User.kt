package org.example.rootbe.domain.user.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.example.rootbe.domain.applications.domain.VolunteerApplication
import org.example.rootbe.domain.teacherRole.domain.TeacherRole
import org.example.rootbe.domain.user.domain.type.Role

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
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    val teacherRoles: List<TeacherRole> = listOf(),
    @Column(name = "device_token")
    var deviceToken: String?,
) {
    fun addVolunteerTime(time: Int) {
        this.totalVolunteerTime += time
    }
}
