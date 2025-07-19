package org.zr.tickets.domain

import java.util.UUID

data class UpdateTicketTypeRequest(
    val id: UUID?,
    val name: String,
    val price: Double,
    val description: String?,
    val totalAvailable: Int?
)
