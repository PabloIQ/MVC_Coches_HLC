
package com.hlc.coche_mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hlc.coche_mvc.entidad.Coche;
import com.hlc.coche_mvc.servicio.CocheServicio;

import jakarta.annotation.PostConstruct;

@Component
public class InicializarDatos {
	 @Autowired
	    private CocheServicio cocheServicio;
	    
	    @PostConstruct
	    public void init() {
	        if (cocheServicio.listarTodosLosCoches().iterator().hasNext()) {
	            return;
	        }
	        
	        Coche coche1 = new Coche();
	        coche1.setMarca("Ford");
	        coche1.setMatrícula("AAA-1616");
	        coche1.setColor("Negro");
	        cocheServicio.guardarCoche(coche1);
	        
	        Coche coche2 = new Coche();
	        coche2.setMarca("Mazda");
	        coche2.setMatrícula("EEE-1212");
	        coche2.setColor("Azul");
	        cocheServicio.guardarCoche(coche2);
	    }
}
