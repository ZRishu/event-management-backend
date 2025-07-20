package org.zr.tickets.services;

import org.zr.tickets.entities.QrCode;
import org.zr.tickets.entities.Ticket;

import java.util.UUID;

public interface QrCodeService {
    QrCode generateQrCode(Ticket ticket);
    byte[] getQrCodeImageForUserAndTicket(UUID userId, UUID ticketId);
}
