package org.zr.tickets.controllers

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.zr.tickets.domain.dtos.ListPublishedEventResponseDto
import org.zr.tickets.mappers.EventMapper
import org.zr.tickets.services.EventService

@RestController
@RequestMapping("/api/v1/published-events")
class PublishedEventController(
    private val eventService: EventService,
    private val eventMapper: EventMapper
) {

    @GetMapping
    fun listPublishedEvents(
        pageable: Pageable
    ): ResponseEntity<Page<ListPublishedEventResponseDto>> {

        return ResponseEntity.ok(
            eventService.listPublishedEvents(pageable)
                .map { eventMapper.toListPublishedEventResponseDto(it) }
        )
    }
}