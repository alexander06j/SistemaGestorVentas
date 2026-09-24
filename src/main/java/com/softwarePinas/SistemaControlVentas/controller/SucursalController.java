package com.softwarePinas.SistemaControlVentas.controller;

import com.softwarePinas.SistemaControlVentas.dto.SucursalDTO;
import com.softwarePinas.SistemaControlVentas.service.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private ISucursalService sucursalService;

    //POST
    @PostMapping
    public ResponseEntity<SucursalDTO> save(@RequestBody SucursalDTO sucursalDTO){
        SucursalDTO sucursalDTOFinal = sucursalService.save(sucursalDTO);
        return new ResponseEntity<>(sucursalDTOFinal, HttpStatus.CREATED);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<SucursalDTO>> findAll(){
        return ResponseEntity.ok(sucursalService.findAll());
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<SucursalDTO> update(@PathVariable long id,
                                              @RequestBody SucursalDTO sucursalDTO){
        return ResponseEntity.ok(sucursalService.update(id, sucursalDTO));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        sucursalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
