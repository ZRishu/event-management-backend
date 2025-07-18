package org.zr.tickets.domain.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PositiveOrZero

data class CreateTicketTypeRequestDto(

    @field:NotBlank(message = "Ticket type name is required")
    val name: String,

    @field:NotNull(message = "Price is required")
    @field:PositiveOrZero(message = "Price must be zero or greater")
    val price: Double,

    val description: String? = null,
    val totalAvailable: Int? = null,
)
