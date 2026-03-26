package com.cesur.reto4.controller;

import com.cesur.reto4.model.PointOfInterest;
import com.cesur.reto4.service.POIService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de Puntos de Interés (POIs).
 * Permite la consulta pública y la creación securizada de lugares turísticos.
 */
@RestController
@RequestMapping("/pois")
public class POIController {

    @Autowired
    private POIService poiService;

    @GetMapping
    public List<PointOfInterest> getAllPOIs(@RequestParam(required = false) String categoria) {
        if (categoria != null) {
            return poiService.findByCategoria(categoria);
        }
        return poiService.findAll();
    }

    @GetMapping("/categorias")
    public List<String> getCategorias() {
        return poiService.findAllCategorias();
    }

    @PostMapping
    public PointOfInterest createPOI(@Valid @RequestBody PointOfInterest poi) {
        return poiService.save(poi);
    }
}
