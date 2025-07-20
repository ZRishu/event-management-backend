package org.zr.tickets.domain.dtos

import org.zr.tickets.domain.enums.TicketStatusEnum
import java.util.UUID

data class ListTicketResponseDto(
    val id: UUID,
    val status: TicketStatusEnum,
    val ticketType: ListTicketTicketTypeResponseDto,

    )
