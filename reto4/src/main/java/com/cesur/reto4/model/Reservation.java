package com.cesur.reto4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservas")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String nombreCliente;

    @NotNull(message = "La fecha de entrada es obligatoria")
    private LocalDate fechaEntrada;

    @NotNull(message = "La fecha de salida es obligatoria")
    private LocalDate fechaSalida;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Reservation() {}

    public Reservation(String nombreCliente, LocalDate fechaEntrada, LocalDate fechaSalida, Hotel hotel) {
        this.nombreCliente = nombreCliente;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.hotel = hotel;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public LocalDate getFechaEntrada() { return fechaEntrada; }
    public void setFechaEntrada(LocalDate fechaEntrada) { this.fechaEntrada = fechaEntrada; }
    public LocalDate getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }
    public Hotel getHotel() { return hotel; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }

    public static ReservationBuilder builder() { return new ReservationBuilder(); }

    public static class ReservationBuilder {
        private String nombreCliente;
        private LocalDate fechaEntrada;
        private LocalDate fechaSalida;
        private Hotel hotel;

        public ReservationBuilder nombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; return this; }
        public ReservationBuilder fechaEntrada(LocalDate fechaEntrada) { this.fechaEntrada = fechaEntrada; return this; }
        public ReservationBuilder fechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; return this; }
        public ReservationBuilder hotel(Hotel hotel) { this.hotel = hotel; return this; }
        public Reservation build() { return new Reservation(nombreCliente, fechaEntrada, fechaSalida, hotel); }
    }
}
