package com.softwarePinas.SistemaControlVentas.repository;

import com.softwarePinas.SistemaControlVentas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Long, Producto> {

}
