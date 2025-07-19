package org.zr.tickets.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.zr.tickets.domain.CreateEventRequest;
import org.zr.tickets.domain.CreateTicketTypeRequest;
import org.zr.tickets.domain.dtos.*;
import org.zr.tickets.entities.Event;
import org.zr.tickets.entities.TicketType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);

    ListEventTicketTypeResponseDto toDto(TicketType ticketType);

    ListEventResponseDto toListEventDto(Event event);
}
