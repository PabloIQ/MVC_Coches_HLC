package com.hlc.coche_mvc.servicio;

import java.util.List;

import com.hlc.coche_mvc.entidad.Coche;
import com.hlc.coche_mvc.repositorio.CocheRepositorio;

public class CocheServicioImpl implements CocheServicio {

	private CocheRepositorio cocheRepositorio;
	
	public CocheServicioImpl(CocheRepositorio cocheRepositorio) {
		this.cocheRepositorio = cocheRepositorio;
	}
	
	@Override
	public List<Coche> obtenerTodosLosCoches() {
		return cocheRepositorio.findAll();
	}

	@Override
	public Coche obtenerCochePorId(Long id) {
		return cocheRepositorio.findById(id).orElseThrow();
	}

	@Override
	public Coche guardarCoche(Coche coche) {
		return cocheRepositorio.save(coche);
	}

	@Override
	public void eliminarCoche(Long id) {
		cocheRepositorio.deleteById(id);
	}
}
