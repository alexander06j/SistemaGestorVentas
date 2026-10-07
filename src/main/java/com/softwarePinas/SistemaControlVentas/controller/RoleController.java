package com.softwarePinas.SistemaControlVentas.controller;

import com.softwarePinas.SistemaControlVentas.model.Permission;
import com.softwarePinas.SistemaControlVentas.model.Role;
import com.softwarePinas.SistemaControlVentas.service.IPermissionService;
import com.softwarePinas.SistemaControlVentas.service.IRoleService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<List<Role>> getRoles(){
        List<Role> roles = roleService.findAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getRoleById(@PathVariable Long id) {
        Optional role = roleService.findById(id);
        return (ResponseEntity) role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity createRole(@RequestBody Role role) {
        Set<Permission> permissionList = new HashSet<>();
        Permission readPermission;


        for (Permission per : role.getPermissionsList()) {
            readPermission = (Permission) permissionService.findById(per.getId()).orElse(null);
            if (readPermission != null) {
                permissionList.add(readPermission);
            }
        }

        role.setPermissionsList(permissionList);
        Role newRole = roleService.save(role);
        return ResponseEntity.ok(newRole);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role){

        Role rol = (Role) roleService.findById(id).orElse(null);
        if(rol!=null){
            rol = role;
        }
        roleService.update(rol);
        return ResponseEntity.ok(rol);
    }
}
