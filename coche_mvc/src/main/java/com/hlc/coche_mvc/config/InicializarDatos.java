package com.hlc.coche_mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hlc.coche_mvc.entidad.Producto;
import com.hlc.coche_mvc.servicio.ProductoServicio;

import jakarta.annotation.PostConstruct;

@Component
public class InicializarDatos {
	@Autowired
	private ProductoServicio productoServicio;
	
	@PostConstruct
	public void init() {
		if (productoServicio.listarTodosLosProductos().iterator().hasNext()) {
			return;
		}
		
		Producto coche1 = new Producto();
		coche1.setMarca("Ford");
		coche1.setMatrícula(new String("FNA-5482"));
		coche1.setColor(new String("Rojo"));
		productoServicio.guardarProducto(coche1);
		
		Producto coche2 = new Producto();
		coche1.setMarca("Ford");
		coche1.setMatrícula(new String("FNA-5482"));
		coche1.setColor(new String("Rojo"));
		productoServicio.guardarProducto(coche1);
	}
}
