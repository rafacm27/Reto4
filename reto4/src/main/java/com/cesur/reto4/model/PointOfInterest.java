package com.cesur.reto4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "puntos_interes")
public class PointOfInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    private String categoria; // museos, parques, etc.

    private Double latitud;
    private Double longitud;

    @Column(length = 1000)
    private String descripcion;

    public PointOfInterest() {}

    public PointOfInterest(String nombre, String categoria, Double latitud, Double longitud, String descripcion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }
    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public static PointOfInterestBuilder builder() { return new PointOfInterestBuilder(); }

    public static class PointOfInterestBuilder {
        private String nombre;
        private String categoria;
        private Double latitud;
        private Double longitud;
        private String descripcion;

        public PointOfInterestBuilder nombre(String nombre) { this.nombre = nombre; return this; }
        public PointOfInterestBuilder categoria(String categoria) { this.categoria = categoria; return this; }
        public PointOfInterestBuilder latitud(Double latitud) { this.latitud = latitud; return this; }
        public PointOfInterestBuilder longitud(Double longitud) { this.longitud = longitud; return this; }
        public PointOfInterestBuilder descripcion(String descripcion) { this.descripcion = descripcion; return this; }
        public PointOfInterest build() { return new PointOfInterest(nombre, categoria, latitud, longitud, descripcion); }
    }
}
