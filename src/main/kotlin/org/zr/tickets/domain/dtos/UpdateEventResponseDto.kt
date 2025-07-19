package org.zr.tickets.domain.dtos

import org.zr.tickets.domain.enums.EventStatusEnum
import java.time.LocalDateTime
import java.util.UUID

data class UpdateEventResponseDto(
    val id: UUID,
    val name: String,
    val start: LocalDateTime?,
    val end: LocalDateTime?,
    val venue: String,
    val salesStart: LocalDateTime?,
    val salesEnd: LocalDateTime?,
    val status: EventStatusEnum,
    val ticketTypes: List<UpdateTicketTypeResponseDto>,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
