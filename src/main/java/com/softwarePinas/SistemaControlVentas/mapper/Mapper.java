package com.softwarePinas.SistemaControlVentas.mapper;

import com.softwarePinas.SistemaControlVentas.dto.DetalleVentaDTO;
import com.softwarePinas.SistemaControlVentas.dto.ProductoDTO;
import com.softwarePinas.SistemaControlVentas.dto.SucursalDTO;
import com.softwarePinas.SistemaControlVentas.dto.VentaDTO;
import com.softwarePinas.SistemaControlVentas.model.Producto;
import com.softwarePinas.SistemaControlVentas.model.Sucursal;
import com.softwarePinas.SistemaControlVentas.model.Venta;

import java.util.stream.Collectors;


public class Mapper {

    //Mapp Producto -> ProductoDTO
    public static ProductoDTO toDTO(Producto p) {
        if (p == null) return null;

        return ProductoDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .categoria(p.getCategoria())
                .precio(p.getPrecio())
                .cantidad(p.getCantidad())
                .build();
    }

    //Mapp Venta -> VentaDTO
    public static VentaDTO toDTO(Venta venta) {
        if (venta == null) return null;

        var detalle = venta.getDetalleVentaList().stream().map(det ->
                DetalleVentaDTO.builder()
                        .id(det.getProducto().getId())
                        .nombreProducto(det.getProducto().getNombre())
                        .cantidadProducto(det.getCantidadProducto())
                        .precio(det.getPrecio())
                        .subtotal(det.getPrecio() * det.getCantidadProducto())
                        .build()
        ).collect(Collectors.toList());

        var total = detalle.stream()
                .map(DetalleVentaDTO::getSubtotal)
                .reduce(0.0, Double::sum);

        return VentaDTO.builder()
                .id(venta.getId())
                .fecha(venta.getFecha())
                .idSucursal(venta.getSucursal().getId())
                .estado(venta.getEstado())
                .detalleVentaDTOList(detalle)
                .total(total)
                .build();
    }

    //Map Sucursal -> SucursalDTO
    public static SucursalDTO toDTO(Sucursal s) {
        if (s == null) return null;
        return SucursalDTO.builder()
                .id(s.getId())
                .nombre(s.getNombre())
                .direccion(s.getDireccion())
                .build();
    }
}
