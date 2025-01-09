package com.hlc.coche_mvc.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hlc.coche_mvc.entidad.Coche;

public interface CocheRepositorio extends JpaRepository<Coche, Long>{

}
