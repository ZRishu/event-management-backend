package org.zr.tickets.controllers

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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
        @RequestParam(required = false) q: String?,
        pageable: Pageable
    ): ResponseEntity<Page<ListPublishedEventResponseDto>> {

        val events = if (!q.isNullOrBlank()) eventService.searchPublishedEvents(
            q,
            pageable
        ) else eventService.listPublishedEvents(pageable)

        return ResponseEntity.ok(
            events.map { eventMapper.toListPublishedEventResponseDto(it) }
        )
    }
}