package org.example.root_be.domain.qrcode.domain
import jakarta.persistence.*
import org.example.root_be.domain.post.domain.VolunteerPost
import java.time.LocalDateTime

@Entity
@Table(name = "qr_code")
class QrCode(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(unique = true, nullable = false)
    val code: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    var volunteerPost: VolunteerPost,

    @Column(nullable = false)
    val generatedAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var isUsed: Boolean = false,

    var usedAt: LocalDateTime? = null
) {
    fun markAsUsed() {
        isUsed = true
        usedAt = LocalDateTime.now()
    }
}