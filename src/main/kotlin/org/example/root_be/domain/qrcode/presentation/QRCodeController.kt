package org.example.root_be.domain.qrcode.presentation

import org.example.root_be.domain.qrcode.presentation.dto.request.GenerateQRCodeRequest
import org.example.root_be.domain.qrcode.presentation.dto.response.GenerateQRCodeResponse
import org.example.root_be.domain.qrcode.service.GenerateQRCodeService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/qr")
class QRCodeController(
    private val generateQRCodeService: GenerateQRCodeService
) {
    @PostMapping
    fun generateQRCode(
        @RequestBody request: GenerateQRCodeRequest
    ): GenerateQRCodeResponse = generateQRCodeService.generate(request)
}