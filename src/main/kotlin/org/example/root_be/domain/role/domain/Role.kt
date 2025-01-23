package org.example.root_be.domain.role.domain

import jakarta.persistence.*
import org.example.root_be.domain.volunteer.domain.VolunteerPost

@Entity
@Table(name = "ROLE")
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "post_id")
    val volunteerPost: VolunteerPost,

    @Column(name = "title")
    var title: String,
)