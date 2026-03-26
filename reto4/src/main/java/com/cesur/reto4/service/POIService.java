package com.cesur.reto4.service;

import com.cesur.reto4.model.PointOfInterest;
import com.cesur.reto4.repository.POIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class POIService {

    @Autowired
    private POIRepository poiRepository;

    public List<PointOfInterest> findAll() {
        return poiRepository.findAll();
    }

    public List<PointOfInterest> findByCategoria(String categoria) {
        return poiRepository.findByCategoria(categoria);
    }

    public List<String> findAllCategorias() {
        return poiRepository.findAll().stream()
                .map(PointOfInterest::getCategoria)
                .distinct()
                .collect(Collectors.toList());
    }

    public PointOfInterest save(PointOfInterest poi) {
        return poiRepository.save(poi);
    }
}
