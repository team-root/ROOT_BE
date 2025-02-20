package org.example.root_be.domain.post_day.exception

import org.example.root_be.global.err.exception.CustomException
import org.example.root_be.global.err.exception.ErrorCode

object DayOfWeekNotFoundException: CustomException(ErrorCode.DAY_OF_WEEK_NOT_FOUND)