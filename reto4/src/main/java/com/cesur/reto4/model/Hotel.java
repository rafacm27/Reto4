package com.cesur.reto4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un Hotel en el sistema de turismo.
 */
@Entity
@Table(name = "hoteles")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La dirección no puede estar vacía")
    private String direccion;

    @Min(1) @Max(5)
    private Integer estrellas;

    @Positive(message = "El precio debe ser positivo")
    private Double precioPorNoche;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Reservation> reservas = new ArrayList<>();

    public Hotel() {}

    public Hotel(String nombre, String direccion, Integer estrellas, Double precioPorNoche) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estrellas = estrellas;
        this.precioPorNoche = precioPorNoche;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public Integer getEstrellas() { return estrellas; }
    public void setEstrellas(Integer estrellas) { this.estrellas = estrellas; }
    public Double getPrecioPorNoche() { return precioPorNoche; }
    public void setPrecioPorNoche(Double precioPorNoche) { this.precioPorNoche = precioPorNoche; }
    public List<Reservation> getReservas() { return reservas; }
    public void setReservas(List<Reservation> reservas) { this.reservas = reservas; }

    public static HotelBuilder builder() { return new HotelBuilder(); }

    public static class HotelBuilder {
        private String nombre;
        private String direccion;
        private Integer estrellas;
        private Double precioPorNoche;

        public HotelBuilder nombre(String nombre) { this.nombre = nombre; return this; }
        public HotelBuilder direccion(String direccion) { this.direccion = direccion; return this; }
        public HotelBuilder estrellas(Integer estrellas) { this.estrellas = estrellas; return this; }
        public HotelBuilder precioPorNoche(Double precioPorNoche) { this.precioPorNoche = precioPorNoche; return this; }
        public Hotel build() { return new Hotel(nombre, direccion, estrellas, precioPorNoche); }
    }
}
