package org.example.root_be.domain.qrcode.service

import org.example.root_be.domain.post.facade.VolunteerFacade
import org.example.root_be.domain.qrcode.domain.QrCode
import org.example.root_be.domain.qrcode.domain.repository.QrCodeRepository
import org.example.root_be.domain.qrcode.presentation.dto.request.GenerateQRCodeRequest
import org.example.root_be.domain.qrcode.presentation.dto.response.GenerateQRCodeResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.random.Random

@Service
class GenerateQRCodeService(
    private val qrCodeRepository: QrCodeRepository,
    private val volunteerFacade: VolunteerFacade
) {
    @Transactional
    fun generate(request: GenerateQRCodeRequest): GenerateQRCodeResponse {
        val post = volunteerFacade.getVolunteerPostById(request.postId)

        var qrCode: Int
        do {
            qrCode = Random.nextInt(100000, 1000000)
        } while (qrCodeRepository.existsByCode(qrCode))

        qrCodeRepository.save(
            QrCode(
                code = qrCode,
                volunteerPost = post
            )
        )

        return GenerateQRCodeResponse(qrCode)
    }
}