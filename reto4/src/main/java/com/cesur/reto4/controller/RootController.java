package com.cesur.reto4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Controlador para la raíz de la API.
 */
@RestController
public class RootController {

    @GetMapping("/")
    public Map<String, String> welcome() {
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Bienvenido a la API REST de Turismo");
        response.put("hoteles", "http://localhost:8080/hoteles");
        response.put("pois", "http://localhost:8080/pois");
        return response;
    }
}
