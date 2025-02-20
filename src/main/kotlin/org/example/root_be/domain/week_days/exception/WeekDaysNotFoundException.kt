package org.example.root_be.domain.week_days.exception

import org.example.root_be.global.err.exception.CustomException
import org.example.root_be.global.err.exception.ErrorCode

object WeekDaysNotFoundException: CustomException(ErrorCode.WEEK_DAYS_NOT_FOUND)