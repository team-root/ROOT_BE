package org.example.root_be.domain.qrcode.service

import jakarta.transaction.Transactional
import org.example.root_be.domain.qrcode.domain.repository.QrCodeRepository
import org.example.root_be.domain.qrcode.presentation.dto.request.ScanQRCodeRequest
import org.example.root_be.domain.qrcode.presentation.dto.response.ScanQRCodeResponse
import org.springframework.stereotype.Service

@Service
class ScanQRCodeService(
    private val qrCodeRepository: QrCodeRepository
) {
    @Transactional
    fun execute(request: ScanQRCodeRequest): ScanQRCodeResponse {
        val qrCode = qrCodeRepository.findByCode(request.qrCode)
            ?: return ScanQRCodeResponse(false)

        if (qrCode.isUsed) {
            return ScanQRCodeResponse(false)
        }

        qrCode.markAsUsed()
        qrCodeRepository.save(qrCode)

        return ScanQRCodeResponse(true)
    }
}