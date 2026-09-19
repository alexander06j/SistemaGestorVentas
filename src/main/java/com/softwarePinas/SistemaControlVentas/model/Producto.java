package com.softwarePinas.SistemaControlVentas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "Debe pertenecer a una categoría")
    private String categoria;

    @NotNull(message = "el precio es obligatorio")
    @DecimalMin(value = "0,01", message = "el precio debe ser mayor a 0")
    private Double precio;

    @NotNull(message = "la cantidad es obligatoria")
    @Min(value = 0, message = "la cantidad no puede ser negativa")
    private int cantidad;

}
