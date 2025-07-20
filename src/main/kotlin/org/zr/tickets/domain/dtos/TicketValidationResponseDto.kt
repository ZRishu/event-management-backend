package org.zr.tickets.domain.dtos

import org.zr.tickets.domain.enums.TicketValidationStatusEnum
import java.util.UUID

data class TicketValidationResponseDto(
    val ticketId: UUID,
    val status: TicketValidationStatusEnum
)
