package com.softwarePinas.SistemaControlVentas.service;

import com.softwarePinas.SistemaControlVentas.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {

    public ProductoDTO save(ProductoDTO productoDTO);

    public List<ProductoDTO> findAll();

    public void deleteById(Long id);

    public ProductoDTO update(Long id, ProductoDTO productoDTO);
}
