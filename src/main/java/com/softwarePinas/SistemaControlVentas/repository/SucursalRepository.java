package com.softwarePinas.SistemaControlVentas.repository;

import com.softwarePinas.SistemaControlVentas.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

}
