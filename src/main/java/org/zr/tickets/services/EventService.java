package org.zr.tickets.services;

import org.zr.tickets.domain.CreateEventRequest;
import org.zr.tickets.entities.Event;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);
}
