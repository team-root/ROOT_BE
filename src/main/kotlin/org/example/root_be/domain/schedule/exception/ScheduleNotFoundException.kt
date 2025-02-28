package org.example.root_be.domain.schedule.exception

import org.example.root_be.global.err.exception.CustomException
import org.example.root_be.global.err.exception.ErrorCode

object ScheduleNotFoundException : CustomException(ErrorCode.SCHEDULE_NOT_FOUND)
