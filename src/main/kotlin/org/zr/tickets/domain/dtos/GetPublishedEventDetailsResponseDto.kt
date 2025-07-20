package org.zr.tickets.domain.dtos

import org.zr.tickets.domain.enums.EventStatusEnum
import java.time.LocalDateTime
import java.util.UUID

data class GetPublishedEventDetailsResponseDto(
    val id: UUID,
    val name: String,
    val start: LocalDateTime?,
    val end: LocalDateTime?,
    val venue: String,
    val ticketTypes: List<GetPublishedEventDetailsTicketTypesResponseDto> = emptyList(),
)
