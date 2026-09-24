package com.softwarePinas.SistemaControlVentas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Builder
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La fecha no puede estar vacía")
    private LocalDate fecha;

    @NotBlank(message = "El estado no puede estar vacío")
    private String estado;

    @NotNull(message = "El total es obligatorio")
    @DecimalMin(value = "0,01", message = "el total debe ser mayor a 0")
    private Double total;

    @ManyToOne
    private Sucursal sucursal;

    @OneToMany(mappedBy = "venta")
    private List<DetalleVenta> detalleVentaList = new ArrayList<>();

}
