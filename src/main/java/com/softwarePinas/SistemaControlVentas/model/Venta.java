package com.softwarePinas.SistemaControlVentas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La fecha no puede estar vacía")
    private LocalDate fecha;

    @NotBlank(message = "El estado no puede estar vacío")
    private String estado;

    @ManyToOne
    private Sucursal sucursal;

}
