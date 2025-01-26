package org.example.root_be.domain.detail.domain.repository

import org.example.root_be.domain.detail.domain.VolunteerDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VolunteerDetailRepository : JpaRepository<VolunteerDetail, Long>