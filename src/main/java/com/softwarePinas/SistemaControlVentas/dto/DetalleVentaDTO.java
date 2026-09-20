package com.softwarePinas.SistemaControlVentas.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class DetalleVentaDTO {

    //Datos del Detalle
    private Long id;
    private String nombreProducto;
    private Integer cantidadProducto;
    private Double precio;

    //dato agregado (calculado)
    private Double subtotal;


}
