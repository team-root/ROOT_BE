package org.example.rootbe.domain.detail.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.example.rootbe.domain.activity.domain.VolunteerActivity
import org.example.rootbe.domain.post.domain.VolunteerPost

@Entity
@Table(name = "volunteer_detail")
class VolunteerDetail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(nullable = false)
    var activityDetails: String,
    @Column(nullable = false)
    var place: String,
    @Column(nullable = false)
    var time: String,
    @OneToOne(mappedBy = "volunteerDetail")
    val volunteerPost: VolunteerPost? = null,
    @OneToMany(mappedBy = "volunteerDetail")
    val volunteerActivities: List<VolunteerActivity> = mutableListOf(),
) {
    fun modifyDetail(
        activityDetails: String,
        place: String,
        time: String,
    ) {
        this.activityDetails = activityDetails
        this.place = place
        this.time = time
    }
}
