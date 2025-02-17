package org.example.root_be.domain.post_day.exception

import org.example.root_be.global.err.exception.CustomException
import org.example.root_be.global.err.exception.ErrorCode

object PostDayNotFoundException: CustomException(ErrorCode.POST_DAY_NOT_FOUND)