package org.zr.tickets.domain.dtos

import java.time.LocalDateTime
import java.util.UUID

data class UpdateTicketTypeResponseDto(
    val id: UUID,
    val name: String,
    val price: Double,
    val description: String?,
    val totalAvailable: Int?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
