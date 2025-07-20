package org.zr.tickets.domain.dtos

import java.time.LocalDateTime
import java.util.*

data class GetPublishedEventDetailsResponseDto(
    val id: UUID,
    val name: String,
    val start: LocalDateTime?,
    val end: LocalDateTime?,
    val venue: String,
    val ticketTypes: List<GetPublishedEventDetailsTicketTypesResponseDto> = emptyList(),
)
