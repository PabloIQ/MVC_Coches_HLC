package com.hlc.coche_mvc.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hlc.coche_mvc.servicio.ProductoServicio;

import ch.qos.logback.core.model.Model;

@Controller
public class ProductoController {
	@Autowired
	ProductoServicio productoServicio;
	
	@GetMapping("/")
	public String listarProductos (Model model) {
		model.
	}
}
