package com.cesur.reto4.repository;

import com.cesur.reto4.model.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface POIRepository extends JpaRepository<PointOfInterest, Long> {
    List<PointOfInterest> findByCategoria(String categoria);
}
