package com.softwarePinas.SistemaControlVentas.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
