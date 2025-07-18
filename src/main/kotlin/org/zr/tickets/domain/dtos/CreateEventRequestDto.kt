package org.zr.tickets.domain.dtos

import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.zr.tickets.domain.enums.EventStatusEnum
import java.time.LocalDateTime

data class CreateEventRequestDto(

    @field:NotBlank(message = "Event name is required")
    val name: String,

    val start: LocalDateTime? = null,
    val end: LocalDateTime? = null,

    @field:NotBlank(message = "Venue information is required")
    val venue: String,

    val salesStart: LocalDateTime? = null,
    val salesEnd: LocalDateTime? = null,

    @field:NotNull(message = "Event status must be provided")
    val status: EventStatusEnum,

    @field:NotEmpty(message = "At least one ticket type is required")
    @field:Valid
    val ticketTypes: List<CreateTicketTypeRequestDto>
)