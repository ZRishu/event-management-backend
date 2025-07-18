package org.zr.tickets.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.zr.tickets.domain.CreateEventRequest;
import org.zr.tickets.domain.CreateTicketTypeRequest;
import org.zr.tickets.domain.dtos.CreateEventRequestDto;
import org.zr.tickets.domain.dtos.CreateEventResponseDto;
import org.zr.tickets.domain.dtos.CreateTicketTypeRequestDto;
import org.zr.tickets.domain.dtos.CreateTicketTypeResponseDto;
import org.zr.tickets.entities.Event;
import org.zr.tickets.entities.TicketType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateTicketTypeResponseDto toDto(TicketType ticketType);

    CreateEventResponseDto toDto(Event event);
}
