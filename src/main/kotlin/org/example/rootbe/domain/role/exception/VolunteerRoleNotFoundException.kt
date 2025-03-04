package org.example.rootbe.domain.role.exception

import org.example.rootbe.global.err.exception.CustomException
import org.example.rootbe.global.err.exception.ErrorCode

object VolunteerRoleNotFoundException : CustomException(ErrorCode.VOLUNTEER_ROLE_NOT_FOUND)
