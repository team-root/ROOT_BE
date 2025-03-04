package org.example.rootbe.domain.schedule.presentation

import jakarta.validation.Valid
import org.example.rootbe.domain.schedule.presentation.dto.request.GenerateScheduleRequest
import org.example.rootbe.domain.schedule.presentation.dto.request.ModifyScheduleRequest
import org.example.rootbe.domain.schedule.presentation.dto.response.GetScheduleListResponse
import org.example.rootbe.domain.schedule.presentation.dto.response.GetScheduleResponse
import org.example.rootbe.domain.schedule.service.DeleteScheduleService
import org.example.rootbe.domain.schedule.service.GenerateScheduleService
import org.example.rootbe.domain.schedule.service.GetScheduleListService
import org.example.rootbe.domain.schedule.service.GetScheduleService
import org.example.rootbe.domain.schedule.service.ModifyScheduleService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/schedules")
@Validated
class ScheduleController(
    private val generateScheduleService: GenerateScheduleService,
    private val getScheduleListService: GetScheduleListService,
    private val getScheduleService: GetScheduleService,
    private val modifyScheduleService: ModifyScheduleService,
    private val deleteScheduleService: DeleteScheduleService,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun generateSchedule(
        @Valid
        @RequestBody request: GenerateScheduleRequest,
    ) {
        generateScheduleService.execute(request)
    }

    @GetMapping
    fun getScheduleList(): GetScheduleListResponse {
        return getScheduleListService.execute()
    }

    @GetMapping("/{date}")
    fun getSchedule(
        @PathVariable date: LocalDate,
    ): GetScheduleResponse {
        return getScheduleService.execute(date)
    }

    @PatchMapping("/{date}")
    fun modifySchedule(
        @PathVariable date: LocalDate,
        @Valid
        @RequestBody request: ModifyScheduleRequest,
    ) {
        modifyScheduleService.execute(date, request)
    }

    @DeleteMapping("/{date}")
    fun deleteSchedule(
        @PathVariable date: LocalDate,
    ) {
        deleteScheduleService.execute(date)
    }
}
