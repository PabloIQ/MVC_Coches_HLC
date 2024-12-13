package com.hlc.coche_mvc.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlc.coche_mvc.entidad.Producto;
import com.hlc.coche_mvc.repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {

	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	public ProductoServicio(ProductoRepositorio productoRepositorio) {
		this.productoRepositorio = productoRepositorio;
	}
	
	public Iterable<Producto> listarTodosLosProductos() {
		return productoRepositorio.findAll();
	}
	
	public Producto guardarProducto(Producto producto) {
		return productoRepositorio.save(producto);
	}
	
	public Producto obtenerProductoPorId(Long id) {
		return productoRepositorio.findById(id).orElseThrow(() ->
			new IllegalArgumentException("Producto no encontrado con id: " + id));
	}
	
	public void eliminarProducto (Long id) {
		productoRepositorio.deleteById(id);
	}
}
