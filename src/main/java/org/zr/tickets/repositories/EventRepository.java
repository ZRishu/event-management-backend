package org.zr.tickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zr.tickets.entities.Event;

import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
}
