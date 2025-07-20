package org.zr.tickets.services.Impl;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zr.tickets.domain.enums.QrCodeStatusEnum;
import org.zr.tickets.domain.enums.TicketValidationMethod;
import org.zr.tickets.domain.enums.TicketValidationStatusEnum;
import org.zr.tickets.entities.QrCode;
import org.zr.tickets.entities.Ticket;
import org.zr.tickets.entities.TicketValidation;
import org.zr.tickets.exceptions.QrCodeNotFoundException;
import org.zr.tickets.exceptions.TicketNotFoundException;
import org.zr.tickets.repositories.QrCodeRepository;
import org.zr.tickets.repositories.TicketRepository;
import org.zr.tickets.repositories.TicketValidationRepository;
import org.zr.tickets.services.TicketValidationService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketValidationServiceImpl implements TicketValidationService {

    private final TicketValidationRepository ticketValidationRepository;
    private final QrCodeRepository qrCodeRepository;
    private final TicketRepository ticketRepository;

    @Override
    public TicketValidation validateTicketByQrCode(UUID qrCodeId) {
        QrCode qrCode = qrCodeRepository.findByIdAndStatus(qrCodeId, QrCodeStatusEnum.ACTIVE)
                .orElseThrow(() -> new QrCodeNotFoundException(
                        String.format("QrCode with ID %s was not found", qrCodeId)
                ));

        Ticket ticket = qrCode.getTicket();

        return validateTicket(ticket, TicketValidationMethod.QR_SCAN);
    }

    @Override
    public TicketValidation validateTicketManually(UUID ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(TicketNotFoundException::new);

        return validateTicket(ticket, TicketValidationMethod.MANUAL);
    }

    @NotNull
    private TicketValidation validateTicket(Ticket ticket, @NotNull TicketValidationMethod ticketValidationMethod) {
        TicketValidation ticketValidation = new TicketValidation();
        ticketValidation.setTicket(ticket);
        ticketValidation.setValidationMethod(ticketValidationMethod);

        TicketValidationStatusEnum ticketValidationStatus = ticket.getValidations().stream()
                .filter(validation -> TicketValidationStatusEnum.VALID.equals(validation.getStatus()))
                .findFirst()
                .map(validation -> TicketValidationStatusEnum.INVALID)
                .orElse(TicketValidationStatusEnum.VALID);

        ticketValidation.setStatus(ticketValidationStatus);

        return ticketValidationRepository.save(ticketValidation);
    }
}
