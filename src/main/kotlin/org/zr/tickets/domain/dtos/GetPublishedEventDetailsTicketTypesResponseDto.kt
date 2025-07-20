package org.zr.tickets.domain.dtos

import java.util.*

data class GetPublishedEventDetailsTicketTypesResponseDto(
    val id: UUID,
    val name: String,
    val price: Double,
    val description: String?,
)
