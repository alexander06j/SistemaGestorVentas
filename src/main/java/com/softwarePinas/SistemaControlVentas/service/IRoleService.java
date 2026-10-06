package com.softwarePinas.SistemaControlVentas.service;

import com.softwarePinas.SistemaControlVentas.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {

    List findAll();
    Optional findById(Long id);
    Role save(Role role);
    void deleteById(Long id);
    Role update(Role role);
}
