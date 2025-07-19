package org.zr.tickets.domain.dtos

import java.time.LocalDateTime
import java.util.UUID

data class ListPublishedEventResponseDto(
    val id: UUID,
    val name: String,
    val start: LocalDateTime?,
    val end: LocalDateTime?,
    val venue: String
)
