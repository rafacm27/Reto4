package com.cesur.reto4.service;

import com.cesur.reto4.model.Hotel;
import com.cesur.reto4.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> findById(Long id) {
        return hotelRepository.findById(id);
    }

    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Optional<Hotel> update(Long id, Hotel hotelDetails) {
        return hotelRepository.findById(id).map(hotel -> {
            hotel.setNombre(hotelDetails.getNombre());
            hotel.setDireccion(hotelDetails.getDireccion());
            hotel.setEstrellas(hotelDetails.getEstrellas());
            hotel.setPrecioPorNoche(hotelDetails.getPrecioPorNoche());
            return hotelRepository.save(hotel);
        });
    }
}
