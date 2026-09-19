package com.softwarePinas.SistemaControlVentas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Venta venta;

    @ManyToOne
    private Producto producto;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad de Productos debe ser mayor a 0")
    private Integer cantidadProducto;

    @NotNull(message = "el precio es obligatorio")
    @DecimalMin(value = "0,01", message = "el precio debe ser mayor a 0")
    private Double precio;


}
