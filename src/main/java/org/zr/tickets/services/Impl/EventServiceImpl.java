package org.zr.tickets.services.Impl;

import org.springframework.stereotype.Service;
import org.zr.tickets.domain.CreateEventRequest;
import org.zr.tickets.domain.entities.Event;
import org.zr.tickets.services.EventService;

import java.util.UUID;

@Service
public class EventServiceImpl implements EventService {

    @Override
    public Event createEvent(UUID organizerId, CreateEventRequest event) {
        return null;
    }
}
