package org.zr.tickets.domain.dtos

import java.util.UUID

data class ListTicketTicketTypeResponseDto(
    val id: UUID,
    val name: String,
    val price: Double,
)
