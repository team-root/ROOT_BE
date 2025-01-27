package org.example.root_be.domain.role.exception

import org.example.root_be.global.err.exception.CustomException
import org.example.root_be.global.err.exception.ErrorCode

object VolunteerRoleNotFoundException: CustomException(ErrorCode.VOLUNTEER_ROLE_NOT_FOUND)