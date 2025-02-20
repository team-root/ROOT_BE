package org.example.root_be.domain.day_of_week.exception

import org.example.root_be.global.err.exception.CustomException
import org.example.root_be.global.err.exception.ErrorCode

object DayOfWeekNotFoundException: CustomException(ErrorCode.DAY_OF_WEEK_NOT_FOUND)