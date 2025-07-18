package org.zr.tickets.domain

import org.zr.tickets.domain.entities.User
import org.zr.tickets.domain.enums.EventStatusEnum
import java.time.LocalDateTime

data class CreateEventRequest(
    val name: String,
    val start: LocalDateTime,
    val end: LocalDateTime,
    val venue: String,
    val salesStart: LocalDateTime,
    val salesEnd: LocalDateTime,
    val status: EventStatusEnum,
    val organizer: User,
    val ticketTypes: List<CreateTicketTypeRequest> = emptyList()
)