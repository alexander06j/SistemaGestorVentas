package com.softwarePinas.SistemaControlVentas.service;

import com.softwarePinas.SistemaControlVentas.dto.SucursalDTO;
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
    @Transactional
    public SucursalDTO save(SucursalDTO sucursalDTO) {
        return;
    }

    @Override
    public List<SucursalDTO> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public SucursalDTO update(Long id, SucursalDTO sucursalDTO) {
        return null;
    }
}
