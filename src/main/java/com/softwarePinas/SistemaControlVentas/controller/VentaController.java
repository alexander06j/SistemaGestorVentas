package com.softwarePinas.SistemaControlVentas.controller;

import com.softwarePinas.SistemaControlVentas.dto.VentaDTO;
import com.softwarePinas.SistemaControlVentas.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    //POST
    @PostMapping
    public ResponseEntity<VentaDTO> save(@RequestBody VentaDTO ventaDTO){
        VentaDTO ventaDTOFinal = ventaService.save(ventaDTO);
        return new ResponseEntity<>(ventaDTOFinal, HttpStatus.CREATED);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<VentaDTO>> findAll(){
        return ResponseEntity.ok(ventaService.findAll());
    }

    //PUT
    public ResponseEntity<VentaDTO> update(@PathVariable Long id,
                                           @RequestBody VentaDTO ventaDTO){
        return ResponseEntity.ok(ventaService.update(id, ventaDTO));
    }

    //DELETE
    public ResponseEntity<Void> delete(@PathVariable Long id){
        ventaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
