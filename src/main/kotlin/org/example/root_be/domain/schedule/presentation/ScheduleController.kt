package org.example.root_be.domain.schedule.presentation

import org.example.root_be.domain.schedule.presentation.dto.request.GenerateScheduleRequest
import org.example.root_be.domain.schedule.presentation.dto.request.ModifyScheduleRequest
import org.example.root_be.domain.schedule.presentation.dto.response.GetScheduleListResponse
import org.example.root_be.domain.schedule.presentation.dto.response.GetScheduleResponse
import org.example.root_be.domain.schedule.service.GenerateScheduleService
import org.example.root_be.domain.schedule.service.GetScheduleListService
import org.example.root_be.domain.schedule.service.GetScheduleService
import org.example.root_be.domain.schedule.service.ModifyScheduleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
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
    private val getScheduleService: GetScheduleService,
    private val modifyScheduleService: ModifyScheduleService
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

    @PatchMapping("/{date}")
    fun modifySchedule(
        @PathVariable date: LocalDate,
        @RequestBody request: ModifyScheduleRequest
    ) {
        modifyScheduleService.execute(date, request)
    }
}