package org.zr.tickets.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zr.tickets.entities.Ticket;

import java.util.UUID;

public interface TicketService {
    Page<Ticket> listTicketForUser(UUID userId, Pageable pageable);
}
