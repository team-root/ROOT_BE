package org.example.rootbe.domain.qrcode.service

import org.example.rootbe.domain.post.facade.VolunteerPostFacade
import org.example.rootbe.domain.qrcode.domain.QrCode
import org.example.rootbe.domain.qrcode.domain.repository.QrCodeRepository
import org.example.rootbe.domain.qrcode.presentation.dto.request.GenerateQRCodeRequest
import org.example.rootbe.domain.qrcode.presentation.dto.response.GenerateQRCodeResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.random.Random

@Service
class GenerateQRCodeService(
    private val qrCodeRepository: QrCodeRepository,
    private val volunteerPostFacade: VolunteerPostFacade,
) {
    @Transactional
    fun generate(request: GenerateQRCodeRequest): GenerateQRCodeResponse {
        val post = volunteerPostFacade.getVolunteerPostById(request.postId)

        var qrCode: Int
        do {
            qrCode = Random.nextInt(100000, 1000000)
        } while (qrCodeRepository.existsByCode(qrCode))

        qrCodeRepository.save(
            QrCode(
                code = qrCode,
                volunteerPost = post,
            ),
        )

        return GenerateQRCodeResponse(qrCode)
    }
}
