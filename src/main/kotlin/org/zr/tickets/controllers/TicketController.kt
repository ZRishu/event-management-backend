package org.zr.tickets.controllers

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.zr.tickets.domain.dtos.ListTicketResponseDto
import org.zr.tickets.mappers.TicketMapper
import org.zr.tickets.services.TicketService
import org.zr.tickets.util.JwtUtil.parseUserId

@RestController
@RequestMapping("/api/v1/tickets")
class TicketController(
    private val ticketService: TicketService,
    private val ticketMapper: TicketMapper
) {
    @GetMapping
    fun listTickets(
        @AuthenticationPrincipal jwt: Jwt,
        pageable: Pageable,
    ): Page<ListTicketResponseDto> {

        return ticketService.listTicketForUser(parseUserId(jwt), pageable)
            .map { ticketMapper.toDto(it) }
    }
}