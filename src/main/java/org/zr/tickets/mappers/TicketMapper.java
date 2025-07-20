package org.zr.tickets.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.zr.tickets.domain.dtos.ListTicketResponseDto;
import org.zr.tickets.domain.dtos.ListTicketTicketTypeResponseDto;
import org.zr.tickets.entities.Ticket;
import org.zr.tickets.entities.TicketType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {
    ListTicketTicketTypeResponseDto toDto(TicketType ticketType);

    ListTicketResponseDto toDto(Ticket ticket);
}
