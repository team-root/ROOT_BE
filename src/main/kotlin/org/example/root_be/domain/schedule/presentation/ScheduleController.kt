package org.example.root_be.domain.schedule.presentation

import org.example.root_be.domain.schedule.presentation.dto.request.GenerateScheduleRequest
import org.example.root_be.domain.schedule.service.GenerateScheduleService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/schedules")
class ScheduleController(
    private val generateScheduleService: GenerateScheduleService
) {
    @PostMapping
    fun generateSchedule(
        @RequestBody request: GenerateScheduleRequest
    ) {
        generateScheduleService.execute(request)
    }
}