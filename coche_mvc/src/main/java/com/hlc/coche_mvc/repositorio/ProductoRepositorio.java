package com.hlc.coche_mvc.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.hlc.coche_mvc.entidad.Producto;

public interface ProductoRepositorio extends CrudRepository<Producto, Long>{

}
