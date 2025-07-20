package org.zr.tickets.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zr.tickets.domain.CreateEventRequest;
import org.zr.tickets.domain.UpdateEventRequest;
import org.zr.tickets.entities.Event;

import java.util.Optional;
import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);
    Page<Event> listEventsForOrganizer(UUID organizerId, Pageable pageable);
    Optional<Event> getEventForOrganizer(UUID organizerId, UUID eventId);
    Event updateEventForOrganizer(UUID organizerId, UUID eventId, UpdateEventRequest event);
    void deleteEventForOrganizer(UUID organizerId, UUID eventId);
    Page<Event> listPublishedEvents(Pageable pageable);
    Page<Event> searchPublishedEvents(String query, Pageable pageable);
}
