package com.softwarePinas.SistemaControlVentas.service;

import com.softwarePinas.SistemaControlVentas.dto.ProductoDTO;
import com.softwarePinas.SistemaControlVentas.exception.NotFoundException;
import com.softwarePinas.SistemaControlVentas.mapper.Mapper;
import com.softwarePinas.SistemaControlVentas.model.Producto;
import com.softwarePinas.SistemaControlVentas.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) {
        Producto producto = Producto.builder()
                .nombre(productoDTO.getNombre())
                .categoria(productoDTO.getCategoria())
                .precio(productoDTO.getPrecio())
                .cantidad(productoDTO.getCantidad())
                .build();
        return Mapper.toDTO(productoRepository.save(producto));
    }

    @Override
    public List<ProductoDTO> findAll() {
        return productoRepository.findAll().stream()
                .map(Mapper::toDTO).toList();
    }

    @Override
    public void deleteById(Long id) {

        //verificar la existencia del producto
        if(!productoRepository.existsById(id)){
            throw new RuntimeException("No existe el producto para eliminar con el id: " + id);
        }
        productoRepository.deleteById(id);
    }

    @Override
    public ProductoDTO update(Long id, ProductoDTO productoDTO) {
        //buscar si el producto existe
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Producto no encontrado con el id: " + id));
        producto.setNombre(productoDTO.getNombre());
        producto.setCategoria(productoDTO.getCategoria());
        producto.setCantidad(productoDTO.getCantidad());
        producto.setPrecio(productoDTO.getPrecio());
        //guarda el producto
        return Mapper.toDTO(productoRepository.save(producto));
    }
}
