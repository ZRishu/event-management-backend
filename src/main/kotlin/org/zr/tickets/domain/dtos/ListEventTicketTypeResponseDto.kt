package org.zr.tickets.domain.dtos

import java.util.UUID

data class ListEventTicketTypeResponseDto(
    val id: UUID,
    val name: String,
    val price: Double,
    val description: String?,
    val totalAvailable: Int?
)
