package org.zr.tickets.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.zr.tickets.domain.dtos.TicketValidationRequestDto
import org.zr.tickets.domain.dtos.TicketValidationResponseDto
import org.zr.tickets.domain.enums.TicketValidationMethod
import org.zr.tickets.mappers.TicketValidationMapper
import org.zr.tickets.services.TicketValidationService

@RestController
@RequestMapping("/api/v1/ticket-validations")
class TicketValidationController(
    private val ticketValidationService: TicketValidationService,
    private val ticketValidationMapper: TicketValidationMapper
) {
    @PostMapping
    fun validateTicket(
        @RequestBody ticketValidationRequestDto: TicketValidationRequestDto
    ): ResponseEntity<TicketValidationResponseDto> {

        val ticketValidation = when (ticketValidationRequestDto.method) {
            TicketValidationMethod.MANUAL -> ticketValidationService.validateTicketManually(
                ticketValidationRequestDto.id,
            )

            else -> ticketValidationService.validateTicketByQrCode(
                ticketValidationRequestDto.id,
            )
        }

        return ResponseEntity.ok((ticketValidationMapper.toDto(ticketValidation)))
    }
}