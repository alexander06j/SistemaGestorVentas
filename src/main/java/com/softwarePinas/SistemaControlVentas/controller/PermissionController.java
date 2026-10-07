package com.softwarePinas.SistemaControlVentas.controller;

import com.softwarePinas.SistemaControlVentas.model.Permission;
import com.softwarePinas.SistemaControlVentas.service.IPermissionService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<List> getAllPermissions() {
        List permissions = permissionService.findAll();
        return ResponseEntity.ok(permissions);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getPermissionById(@PathVariable Long id) {
        Optional permission = permissionService.findById(id);
        return (ResponseEntity) permission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity createPermission(@RequestBody Permission permission) {
        Permission newPermission = permissionService.save(permission);
        return ResponseEntity.ok(newPermission);
    }
}
