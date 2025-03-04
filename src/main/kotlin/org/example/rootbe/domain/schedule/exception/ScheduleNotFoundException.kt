package org.example.rootbe.domain.schedule.exception

import org.example.rootbe.global.err.exception.CustomException
import org.example.rootbe.global.err.exception.ErrorCode

object ScheduleNotFoundException : CustomException(ErrorCode.SCHEDULE_NOT_FOUND)
