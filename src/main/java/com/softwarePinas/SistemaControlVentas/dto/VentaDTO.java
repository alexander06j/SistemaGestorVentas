package com.softwarePinas.SistemaControlVentas.dto;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VentaDTO {

    //Datos de la clase Venta
    private Long id;
    private LocalDate fecha;
    private String estado;
    private Double total;

    //Dato de la sucursal
    private Long idSucursal;

    //Lista de detalle
    private List<DetalleVentaDTO> detalleVentaDTOList;



}
