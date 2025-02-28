package org.example.root_be.domain.role.domain

import jakarta.persistence.*
import org.example.root_be.domain.post.domain.VolunteerPost

@Entity
@Table(name = "ROLE")
class VolunteerRole(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    val volunteerPost: VolunteerPost,

    @Column(name = "title")
    var title: String,
)