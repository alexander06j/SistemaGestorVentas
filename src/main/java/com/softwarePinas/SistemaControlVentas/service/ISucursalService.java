package com.softwarePinas.SistemaControlVentas.service;

import com.softwarePinas.SistemaControlVentas.dto.SucursalDTO;

import java.util.List;

public interface ISucursalService {

    public SucursalDTO save(SucursalDTO sucursalDTO);

    public List<SucursalDTO> findAll();

    public void deleteById(Long id);

    public SucursalDTO update(Long id, SucursalDTO sucursalDTO);


}
