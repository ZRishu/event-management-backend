package org.zr.tickets.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.zr.tickets.domain.CreateEventRequest;
import org.zr.tickets.domain.CreateTicketTypeRequest;
import org.zr.tickets.domain.UpdateEventRequest;
import org.zr.tickets.domain.UpdateTicketTypeRequest;
import org.zr.tickets.domain.dtos.*;
import org.zr.tickets.entities.Event;
import org.zr.tickets.entities.TicketType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateTicketTypeResponseDto toDto(TicketType ticketType);

    CreateEventResponseDto toDto(Event event);

    ListEventTicketTypeResponseDto toListEventTicketType(TicketType ticketType);

    ListEventResponseDto toListEventDto(Event event);

    GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(TicketType ticketType);

    GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);

    UpdateTicketTypeRequest  fromDto(UpdateTicketTypeRequestDto dto);

    UpdateEventRequest fromDto(UpdateEventRequestDto dto);

    UpdateTicketTypeRequestDto toUpdateTicketTypeResponseDto(TicketType ticketType);

    UpdateEventResponseDto toUpdateEventResponseDto(Event event);
}
