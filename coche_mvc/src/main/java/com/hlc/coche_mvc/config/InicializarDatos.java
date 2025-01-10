
package com.hlc.coche_mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hlc.coche_mvc.entidad.Coche;
import com.hlc.coche_mvc.repositorio.CocheRepositorio;
import com.hlc.coche_mvc.servicio.CocheServicio;

import jakarta.annotation.PostConstruct;

@Component
public class InicializarDatos {
	 
	 private CocheRepositorio cocheRepositorio;
	 
	 /* @Autowired (en lugar de llamar al repositorio  */
	 public InicializarDatos(CocheRepositorio cocheRepositorio) {
		 this.cocheRepositorio = cocheRepositorio;
	 }
	 
	 @PostConstruct
	 public void init() {
		 Coche coche1 = new Coche("Toyota", "1234ABC", "Rojo");
		 Coche coche2 = new Coche("Ford", "9876FGT", "Verde");
		 Coche coche3 = new Coche("Honda", "7645ERF", "Amarillo");
		 
		 cocheRepositorio.save(coche1);
		 cocheRepositorio.save(coche2);
		 cocheRepositorio.save(coche3);
	 }
}
