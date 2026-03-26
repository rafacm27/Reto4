package com.cesur.reto4.config;

import com.cesur.reto4.model.Hotel;
import com.cesur.reto4.model.PointOfInterest;
import com.cesur.reto4.repository.HotelRepository;
import com.cesur.reto4.repository.POIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private POIRepository poiRepository;

    @Override
    public void run(String... args) throws Exception {
        // Seed Hotels
        Hotel h1 = Hotel.builder()
                .nombre("Hotel Alfonso XIII")
                .direccion("Calle San Fernando, 2, Sevilla")
                .estrellas(5)
                .precioPorNoche(350.0)
                .build();

        Hotel h2 = Hotel.builder()
                .nombre("Meliá Costa del Sol")
                .direccion("Paseo Marítimo Bajondillo, 11, Torremolinos")
                .estrellas(4)
                .precioPorNoche(120.0)
                .build();

        hotelRepository.saveAll(Arrays.asList(h1, h2));

        // Seed POIs
        PointOfInterest p1 = PointOfInterest.builder()
                .nombre("La Giralda")
                .categoria("Monumentos")
                .latitud(37.3861)
                .longitud(-5.9925)
                .descripcion("La torre campanario de la Catedral de Sevilla.")
                .build();

        PointOfInterest p2 = PointOfInterest.builder()
                .nombre("Museo de la Aduana")
                .categoria("Museos")
                .latitud(36.7201)
                .longitud(-4.4149)
                .descripcion("Museo de Bellas Artes y Arqueología de Málaga.")
                .build();

        poiRepository.saveAll(Arrays.asList(p1, p2));
        
        System.out.println("Datos de prueba cargados correctamente.");
    }
}
