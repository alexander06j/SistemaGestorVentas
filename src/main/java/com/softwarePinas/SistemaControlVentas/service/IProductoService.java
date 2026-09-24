package com.softwarePinas.SistemaControlVentas.service;

import com.softwarePinas.SistemaControlVentas.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {

    ProductoDTO save(ProductoDTO productoDTO);

    List<ProductoDTO> findAll();

    void deleteById(Long id);

    ProductoDTO update(Long id, ProductoDTO productoDTO);
}
