package com.softwarePinas.SistemaControlVentas.controller;

import com.softwarePinas.SistemaControlVentas.dto.ProductoDTO;
import com.softwarePinas.SistemaControlVentas.model.Producto;
import com.softwarePinas.SistemaControlVentas.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    //POST
    @PostMapping
    public ResponseEntity<ProductoDTO> save(@RequestBody ProductoDTO productoDTO){
        ProductoDTO productoDTOFinal = productoService.save(productoDTO);
        return new ResponseEntity<>(productoDTOFinal, HttpStatus.CREATED);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> finddAll(){
        return ResponseEntity.ok(productoService.findAll());
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> update(@PathVariable Long id,
                                              @RequestBody ProductoDTO productoDTO){
        return ResponseEntity.ok(productoService.update(id, productoDTO));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
