package org.example.rootbe.domain.weekDays.exception

import org.example.rootbe.global.err.exception.CustomException
import org.example.rootbe.global.err.exception.ErrorCode

object WeekDaysNotFoundException : CustomException(ErrorCode.WEEK_DAYS_NOT_FOUND)
