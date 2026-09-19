package com.softwarePinas.SistemaControlVentas.repository;

import com.softwarePinas.SistemaControlVentas.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Long, Venta> {

}
