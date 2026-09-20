package com.softwarePinas.SistemaControlVentas.service;

import com.softwarePinas.SistemaControlVentas.dto.ProductoDTO;
import com.softwarePinas.SistemaControlVentas.mapper.Mapper;
import com.softwarePinas.SistemaControlVentas.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) {
        return null;
    }

    @Override
    public List<ProductoDTO> findAll() {
        return productoRepository.findAll().stream()
                .map(Mapper::toDTO).toList();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public ProductoDTO update(Long id, ProductoDTO productoDTO) {
        return null;
    }
}
