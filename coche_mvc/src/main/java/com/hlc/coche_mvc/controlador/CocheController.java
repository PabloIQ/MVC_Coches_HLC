package com.hlc.coche_mvc.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hlc.coche_mvc.entidad.Coche;
import com.hlc.coche_mvc.servicio.CocheServicio;

@Controller
@RequestMapping("/coche")
public class CocheController {

	 private CocheServicio servicio;
	 
	 public CocheController(CocheServicio servicio) {
		 this.servicio = servicio;
	 }
	 
	 @GetMapping()
	    public String listarCoches(Model model) {
		 List<Coche> coches = servicio.obtenerTodosLosCoches();
	        model.addAttribute("coches", coches);
	        return "coches/listar";
	    }

	    @GetMapping("/nuevo")
	    public String mostrarFormularioDeNuevoCoche(Model model) {
	        Coche coche = new Coche();
	        model.addAttribute("coche", coche);
	        return "coche-form";
	    }

	    @GetMapping("/coche/editar/{id}")
	    public String mostrarFormularioDeEditarCoche(@PathVariable Long id, Model model) {
	        Coche coche = servicio.obtenerCochePorId(id);
	        model.addAttribute("coche", coche);
	        return "coche-form"; 
	    }

	    @PostMapping("/coche")
	    public String guardarCoche(@ModelAttribute Coche coche) {
	        servicio.guardarCoche(coche);
	        return "redirect:/";
	    }

	    @GetMapping("/coche/eliminar/{id}")
	    public String eliminarCoche(@PathVariable Long id) {
	        servicio.eliminarCoche(id);
	        return "redirect:/";
	    }
	}