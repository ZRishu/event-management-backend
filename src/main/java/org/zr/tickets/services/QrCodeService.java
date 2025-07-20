package org.zr.tickets.services;

import org.zr.tickets.entities.QrCode;
import org.zr.tickets.entities.Ticket;

public interface QrCodeService {
    QrCode generateQrCode(Ticket ticket);
}
