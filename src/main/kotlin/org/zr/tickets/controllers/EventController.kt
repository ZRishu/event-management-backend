package org.zr.tickets.controllers

import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.*
import org.zr.tickets.domain.dtos.CreateEventRequestDto
import org.zr.tickets.domain.dtos.CreateEventResponseDto
import org.zr.tickets.domain.dtos.GetEventDetailsResponseDto
import org.zr.tickets.domain.dtos.ListEventResponseDto
import org.zr.tickets.domain.dtos.UpdateEventRequestDto
import org.zr.tickets.domain.dtos.UpdateEventResponseDto
import org.zr.tickets.mappers.EventMapper
import org.zr.tickets.services.EventService
import org.zr.tickets.util.JwtUtil.parseUserId
import java.util.*

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

        val createdEvent = eventService.createEvent(parseUserId(jwt), createEventRequest)
        val eventDto = eventMapper.toDto(createdEvent)
        return ResponseEntity(eventDto, HttpStatus.CREATED)
    }

    @PutMapping("/{eventId}")
    fun updateEvent(
        @AuthenticationPrincipal jwt: Jwt,
        @PathVariable eventId: UUID,
        @Valid @RequestBody updateEventRequestDto: UpdateEventRequestDto
    ): ResponseEntity<UpdateEventResponseDto> {

        val updateEventRequest = eventMapper.fromDto(updateEventRequestDto)

        val updatedEvent = eventService.updateEventForOrganizer(parseUserId(jwt), eventId, updateEventRequest)
        val eventDto = eventMapper.toUpdateEventResponseDto(updatedEvent)
        return ResponseEntity.ok(eventDto)
    }

    @GetMapping
    fun listEvents(
        @AuthenticationPrincipal jwt: Jwt,
        pageable: Pageable
    ): ResponseEntity<Page<ListEventResponseDto>> {

        val events = eventService.listEventsForOrganizer(parseUserId(jwt), pageable)
        return ResponseEntity.ok(events.map {eventMapper.toListEventDto(it) })
    }

    @GetMapping("/{eventId}")
    fun getEvent(
        @AuthenticationPrincipal jwt: Jwt,
        @PathVariable eventId: UUID
    ): ResponseEntity<GetEventDetailsResponseDto> {

        return eventService.getEventForOrganizer(parseUserId(jwt), eventId)
            .map { eventMapper.toGetEventDetailsResponseDto(it) }
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{eventId}")
    fun deleteEvent(
        @AuthenticationPrincipal jwt: Jwt,
        @PathVariable eventId: UUID
    ): ResponseEntity<Void> {
        eventService.deleteEventForOrganizer(parseUserId(jwt), eventId)
        return ResponseEntity.noContent().build()
    }
}