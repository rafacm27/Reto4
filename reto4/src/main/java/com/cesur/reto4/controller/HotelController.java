package com.cesur.reto4.controller;

import com.cesur.reto4.model.Hotel;
import com.cesur.reto4.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de Hoteles.
 * Proporciona endpoints para lectura pública y escritura securizada.
 */
@RestController
@RequestMapping("/hoteles")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    /**
     * Obtiene la lista de todos los hoteles disponibles.
     * @return Lista de hoteles.
     */
    @GetMapping
    public List<Hotel> getAllHoteles() {
        return hotelService.findAll();
    }

    /**
     * Obtiene los detalles de un hotel por su ID.
     * @param id ID del hotel.
     * @return El hotel si existe, o 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        return hotelService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crea un nuevo hotel. Requiere autenticación.
     * @param hotel Datos del hotel.
     * @return El hotel creado.
     */
    @PostMapping
    public Hotel createHotel(@Valid @RequestBody Hotel hotel) {
        return hotelService.save(hotel);
    }

    /**
     * Actualiza un hotel existente. Requiere autenticación.
     * @param id ID del hotel.
     * @param hotelDetails Nuevos datos.
     * @return El hotel actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @Valid @RequestBody Hotel hotelDetails) {
        return hotelService.update(id, hotelDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
