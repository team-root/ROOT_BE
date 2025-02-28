package org.example.root_be.domain.qrcode.domain.repository

import org.example.root_be.domain.qrcode.domain.QrCode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QrCodeRepository : JpaRepository<QrCode, Long> {
    fun existsByCode(code: Int): Boolean

    fun findByCode(code: Int): QrCode?
}
