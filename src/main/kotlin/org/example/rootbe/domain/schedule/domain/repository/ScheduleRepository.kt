package org.example.rootbe.domain.schedule.domain.repository

import org.example.rootbe.domain.schedule.domain.Schedule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface ScheduleRepository : JpaRepository<Schedule, Long> {
    fun findByDate(date: LocalDate): Schedule?

    fun findByTitle(title: String): List<Schedule>
}
