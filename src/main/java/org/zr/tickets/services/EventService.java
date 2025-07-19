package org.zr.tickets.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zr.tickets.domain.CreateEventRequest;
import org.zr.tickets.entities.Event;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);
    Page<Event> listEventsForOrganizer(UUID organizerId, Pageable pageable);
}
