package com.softwarePinas.SistemaControlVentas.service;

import com.softwarePinas.SistemaControlVentas.dto.SucursalDTO;
import com.softwarePinas.SistemaControlVentas.mapper.Mapper;
import com.softwarePinas.SistemaControlVentas.model.Sucursal;
import com.softwarePinas.SistemaControlVentas.repository.ISucursalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService implements ISucursalService {

    @Autowired
    private ISucursalRepository sucursalRepository;

    @Override
    public SucursalDTO save(SucursalDTO sucursalDTO) {
        Sucursal sucursal = Sucursal.builder()
                .nombre(sucursalDTO.getNombre())
                .direccion(sucursalDTO.getDireccion())
                .build();
        return Mapper.toDTO(sucursalRepository.save(sucursal));
    }

    @Override
    public List<SucursalDTO> findAll() {
        return sucursalRepository.findAll()
                .stream()
                .map(Mapper::toDTO).toList();
    }

    @Override
    public void deleteById(Long id) {
        //verificar id
        if(!sucursalRepository.existsById(id)){
            throw new RuntimeException("No existe la sucursal con el id: " + id);
        }
        sucursalRepository.deleteById(id);
    }

    @Override
    public SucursalDTO update(Long id, SucursalDTO sucursalDTO) {
        //verificar si existe la sucursal
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No existe ninguna sucursal con el id: " + id));
        sucursal.setNombre(sucursalDTO.getNombre());
        sucursal.setDireccion(sucursalDTO.getDireccion());
        //guardar el producto
        return Mapper.toDTO(sucursalRepository.save(sucursal));

    }
}
