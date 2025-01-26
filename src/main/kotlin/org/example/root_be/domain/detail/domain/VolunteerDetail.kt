package org.example.root_be.domain.detail.domain

import jakarta.persistence.*
import org.example.root_be.domain.activity.domain.VolunteerActivity
import org.example.root_be.domain.post.domain.VolunteerPost

@Entity
@Table(name = "volunteer_detail")
class VolunteerDetail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val activityDetails: String,

    @Column(nullable = false)
    val place: String,

    @Column(nullable = false)
    val time: String,

    @OneToOne(mappedBy = "volunteerDetail")
    val volunteerPost: VolunteerPost? = null,

    @OneToMany(mappedBy = "volunteerDetail")
    val volunteerActivities: List<VolunteerActivity> = mutableListOf()
)