package org.zr.tickets.domain.dtos

import java.time.LocalDateTime
import java.util.UUID

data class GetPublishedEventDetailsTicketTypesResponseDto(
    val id: UUID,
    val name: String,
    val price: Double,
    val description: String?,
)
