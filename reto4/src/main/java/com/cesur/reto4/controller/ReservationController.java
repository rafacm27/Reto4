package com.cesur.reto4.controller;

import com.cesur.reto4.model.Reservation;
import com.cesur.reto4.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de Reservas.
 */
@RestController
@RequestMapping("/reservas")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public Reservation createReserva(@Valid @RequestBody Reservation reservation) {
        return reservationService.create(reservation);
    }
}
