package com.cesur.reto4.service;

import com.cesur.reto4.model.Reservation;
import com.cesur.reto4.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
