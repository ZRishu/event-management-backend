package org.zr.tickets.controllers

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.zr.tickets.domain.dtos.CreateEventRequestDto
import org.zr.tickets.domain.dtos.CreateEventResponseDto
import org.zr.tickets.mappers.EventMapper
import org.zr.tickets.services.EventService
import java.util.UUID

@RestController
@RequestMapping("/api/v1/events")
class EventController(
    private val eventService: EventService,
    private val eventMapper: EventMapper
) {

    @PostMapping
    fun createEvent(
        @AuthenticationPrincipal jwt: Jwt,
        @Valid @RequestBody createEventRequestDto: CreateEventRequestDto
    ): ResponseEntity<CreateEventResponseDto> {

        val createEventRequest = eventMapper.fromDto(createEventRequestDto)
        val userId = UUID.fromString(jwt.subject)

        val createdEvent = eventService.createEvent(userId, createEventRequest)
        val eventDto = eventMapper.toDto(createdEvent)
        return ResponseEntity(eventDto, HttpStatus.CREATED)
    }
}