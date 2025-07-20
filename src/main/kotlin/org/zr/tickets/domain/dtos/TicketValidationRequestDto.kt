package org.zr.tickets.domain.dtos

import org.zr.tickets.domain.enums.TicketValidationMethod
import java.util.UUID

data class TicketValidationRequestDto(
    val id: UUID,
    val method: TicketValidationMethod
)
