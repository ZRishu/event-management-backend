package org.zr.tickets.controllers

import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.zr.tickets.services.TicketTypeService
import org.zr.tickets.util.JwtUtil.parseUserId
import java.util.UUID

@RestController
@RequestMapping("/api/v1/events/{eventId}/ticket-types")
class TicketTypeController(
    private val ticketTypeService: TicketTypeService
) {
    @PostMapping("/{ticketTypeId}/tickets")
    fun purchaseTicket(
        @AuthenticationPrincipal jwt: Jwt,
        @PathVariable ticketTypeId: UUID
    ): ResponseEntity<Void> {

        ticketTypeService.purchaseTicket(parseUserId(jwt), ticketTypeId)
        return ResponseEntity.noContent().build()
    }
}