package org.example.root_be.domain.user.service

import org.example.root_be.domain.user.domain.repository.UserRepository
import org.example.root_be.domain.user.presentation.dto.response.StudentElement
import org.example.root_be.domain.user.presentation.dto.response.StudentQueryResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StudentQueryService (
    val userRepository: UserRepository
){
    @Transactional(readOnly = true)
    fun execute(): StudentQueryResponse {
        val students = userRepository.findAll()
            .map { user ->
                StudentElement(
                    id = user.id,
                    name = user.name,
                    grade = user.grade,
                    classNum = user.classNum,
                    number = user.num,
                    volunteerTime = user.totalVolunteerTime
                )
            }
        return StudentQueryResponse(students)
    }
}