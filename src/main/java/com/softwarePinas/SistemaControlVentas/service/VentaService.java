package com.softwarePinas.SistemaControlVentas.service;

import com.softwarePinas.SistemaControlVentas.dto.DetalleVentaDTO;
import com.softwarePinas.SistemaControlVentas.dto.VentaDTO;
import com.softwarePinas.SistemaControlVentas.exception.NotFoundException;
import com.softwarePinas.SistemaControlVentas.mapper.Mapper;
import com.softwarePinas.SistemaControlVentas.model.DetalleVenta;
import com.softwarePinas.SistemaControlVentas.model.Producto;
import com.softwarePinas.SistemaControlVentas.model.Sucursal;
import com.softwarePinas.SistemaControlVentas.model.Venta;
import com.softwarePinas.SistemaControlVentas.repository.IProductoRepository;
import com.softwarePinas.SistemaControlVentas.repository.ISucursalRepository;
import com.softwarePinas.SistemaControlVentas.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private ISucursalRepository sucursalRepository;

    @Override
    public VentaDTO save(VentaDTO ventaDTO) {
        //Validar los datos
        if(ventaDTO == null) throw new RuntimeException("La ventaDTO es null");
        if(ventaDTO.getIdSucursal() == null) throw new RuntimeException("la sucursal es obligatoria");
        if(ventaDTO.getDetalleVentaDTOList() == null || ventaDTO.getDetalleVentaDTOList().isEmpty())
            throw new RuntimeException("Debe incluir al menos un producto");

        //Buscar la sucursal
        Sucursal sucursal = sucursalRepository.findById(ventaDTO.getIdSucursal()).orElse(null);
        if(sucursal == null){
            throw new NotFoundException("La Sucursal no fue encontrada");
        }


        //se crea la venta(atributos sin relaciones)
        Venta venta = new Venta();
        venta.setFecha(ventaDTO.getFecha());
        venta.setEstado(ventaDTO.getEstado());
        venta.setSucursal(sucursal);
        venta.setTotal(ventaDTO.getTotal());

        //Lista de detalles(con los productos)
        List<DetalleVenta> detalleVentaList = new ArrayList<>();
        Double totalCalculado = 0.0;

        for(DetalleVentaDTO detalleVentaDTO : ventaDTO.getDetalleVentaDTOList()){
            //buscar producto por id
            Producto producto = productoRepository
                    .findByNombre(detalleVentaDTO
                            .getNombreProducto())
                    .orElse(null);
            if( producto == null)
            {throw new RuntimeException("Producto no encontrado: " + detalleVentaDTO.getNombreProducto());}

            //Crear detalle
            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setProducto(producto);
            detalleVenta.setPrecio(detalleVentaDTO.getPrecio());
            detalleVenta.setCantidadProducto(detalleVentaDTO.getCantidadProducto());
            detalleVenta.setVenta(venta);

            detalleVentaList.add(detalleVenta);
            totalCalculado = totalCalculado
                    +(detalleVentaDTO.getPrecio()*detalleVentaDTO
                    .getCantidadProducto());
        }
        //Setear la lista de detalleVentaList
        venta.setDetalleVentaList(detalleVentaList);

        //Guardar en la BD
        venta = ventaRepository.save(venta);

        //Mapeo
        VentaDTO ventaFinal = Mapper.toDTO(venta);

        return ventaFinal;

    }

    @Override
    public List<VentaDTO> findAll() {
        return ventaRepository.findAll()
                .stream()
                .map(Mapper::toDTO).toList();
    }

    @Override
    public void deleteById(Long id) {
        if(!ventaRepository.existsById(id)){
            throw new RuntimeException("La venta con el id : " + id + " no existe");
        }
        ventaRepository.deleteById(id);
    }

    @Override
    public VentaDTO update(Long id, VentaDTO ventaDTO) {
        //verificar existencia de la Venta
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado con el id: " + id));
        venta.setFecha(ventaDTO.getFecha());
        venta.setEstado(ventaDTO.getEstado());
        venta.setTotal(ventaDTO.getTotal());

        if(ventaDTO.getIdSucursal()!=null){
            Sucursal sucursal = sucursalRepository.findById(id).orElse(null);
            if(sucursal == null) throw new RuntimeException("Sucursal no encontrada");
            venta.setSucursal(sucursal);
        }
        ventaRepository.save(venta);

        VentaDTO ventaFinal = Mapper.toDTO(venta);

        return ventaFinal;
    }
}
