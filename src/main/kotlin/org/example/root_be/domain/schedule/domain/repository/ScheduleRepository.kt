package org.example.root_be.domain.schedule.domain.repository

import org.example.root_be.domain.schedule.domain.Schedule
import org.springframework.data.jpa.repository.JpaRepository

interface ScheduleRepository: JpaRepository<Schedule, Long>