package com.softwarePinas.SistemaControlVentas.service;

import com.softwarePinas.SistemaControlVentas.dto.VentaDTO;

import java.util.List;

public interface IVentaService {

    VentaDTO save(VentaDTO ventaDTO);

    List<VentaDTO> findAll();

    void deleteById(Long id);

    VentaDTO update(Long id, VentaDTO ventaDTO);

}
