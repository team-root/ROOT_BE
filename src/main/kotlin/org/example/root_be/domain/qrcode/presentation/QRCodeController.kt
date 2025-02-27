package org.example.root_be.domain.qrcode.presentation

import jakarta.validation.Valid
import org.example.root_be.domain.qrcode.presentation.dto.request.GenerateQRCodeRequest
import org.example.root_be.domain.qrcode.presentation.dto.request.ScanQRCodeRequest
import org.example.root_be.domain.qrcode.presentation.dto.response.GenerateQRCodeResponse
import org.example.root_be.domain.qrcode.presentation.dto.response.ScanQRCodeResponse
import org.example.root_be.domain.qrcode.service.GenerateQRCodeService
import org.example.root_be.domain.qrcode.service.ScanQRCodeService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/qr")
@Validated
class QRCodeController(
    private val generateQRCodeService: GenerateQRCodeService,
    private val scanQRCodeService: ScanQRCodeService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
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