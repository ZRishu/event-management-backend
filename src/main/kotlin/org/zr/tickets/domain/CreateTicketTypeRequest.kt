package org.zr.tickets.domain

data class CreateTicketTypeRequest(
    val name: String,
    val price: Double,
    val description: String,
    val totalAvailable: Int
)
