package org.zr.tickets.domain.dtos

import org.zr.tickets.domain.enums.TicketStatusEnum
import java.util.UUID

data class GetTicketResponseDto(
    val id: UUID,
    val status: TicketStatusEnum,
    val price: Double,
    val description: String?,
    val eventName: String,
    val eventVenue: String,
    val eventStart: String?,
    val eventEnd: String?
)
