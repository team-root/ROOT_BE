package org.example.root_be.domain.schedule.presentation

import org.example.root_be.domain.schedule.presentation.dto.request.GenerateScheduleRequest
import org.example.root_be.domain.schedule.presentation.dto.response.GetScheduleListResponse
import org.example.root_be.domain.schedule.presentation.dto.response.GetScheduleResponse
import org.example.root_be.domain.schedule.service.GenerateScheduleService
import org.example.root_be.domain.schedule.service.GetScheduleListService
import org.example.root_be.domain.schedule.service.GetScheduleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/schedules")
class ScheduleController(
    private val generateScheduleService: GenerateScheduleService,
    private val getScheduleListService: GetScheduleListService,
    private val getScheduleService: GetScheduleService
) {
    @PostMapping
    fun generateSchedule(
        @RequestBody request: GenerateScheduleRequest
    ) {
        generateScheduleService.execute(request)
    }

    @GetMapping
    fun getScheduleList(): GetScheduleListResponse {
        return getScheduleListService.execute()
    }

    @GetMapping("/{date}")
    fun getSchedule(
        @PathVariable date: LocalDate
    ): GetScheduleResponse {
        return getScheduleService.execute(date)
    }
}