package org.example.root_be.domain.qrcode.presentation

import jakarta.validation.Valid
import org.example.root_be.domain.qrcode.presentation.dto.request.GenerateQRCodeRequest
import org.example.root_be.domain.qrcode.presentation.dto.request.ScanQRCodeRequest
import org.example.root_be.domain.qrcode.presentation.dto.response.GenerateQRCodeResponse
import org.example.root_be.domain.qrcode.presentation.dto.response.ScanQRCodeResponse
import org.example.root_be.domain.qrcode.service.GenerateQRCodeService
import org.example.root_be.domain.qrcode.service.ScanQRCodeService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/qr")
class QRCodeController(
    private val generateQRCodeService: GenerateQRCodeService,
    private val scanQRCodeService: ScanQRCodeService
) {
    @PostMapping
    fun generateQRCode(
        @Valid
        @RequestBody request: GenerateQRCodeRequest
    ): GenerateQRCodeResponse = generateQRCodeService.generate(request)

    @PostMapping("/scan")
    fun scanQRCode(
        @Valid
        @RequestBody request: ScanQRCodeRequest
    ): ScanQRCodeResponse = scanQRCodeService.execute(request)
}