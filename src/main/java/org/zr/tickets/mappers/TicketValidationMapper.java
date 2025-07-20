package org.zr.tickets.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.zr.tickets.domain.dtos.TicketValidationResponseDto;
import org.zr.tickets.entities.TicketValidation;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketValidationMapper {

    @Mapping(target = "ticketId", source = "ticket.id")
    TicketValidationResponseDto toDto(TicketValidation ticketValidation);
}
