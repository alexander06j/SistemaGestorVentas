package com.softwarePinas.SistemaControlVentas.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DetalleVentaDTO {

    //Datos del Detalle
    private Long id;
    private String nombreProducto;
    private Integer cantidadProducto;
    private Double precio;

    //dato agregado (calculado)
    private Double subtotal;


}
