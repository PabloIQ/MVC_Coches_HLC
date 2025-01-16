package com.hlc.coche_mvc.controlador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

import org.assertj.core.error.ShouldHaveSameSizeAs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.hlc.coche_mvc.entidad.Coche;
import com.hlc.coche_mvc.servicio.CocheServicio;

@WebMvcTest(CocheController.class)
class CocheControllerTest {
	@Autowired
	private MockMvc mockmvc;
	
	@MockitoBean
	private CocheServicio servicio;
	
	@Test
	@DisplayName("Debe montrar todos los coches")
	void listarCoches() throws Exception {
		when(servicio.obtenerTodosLosCoches()).thenReturn(
				Arrays.asList(
						new Coche("Toyota", "1234ABC", "Rojo"),
						new Coche("Ford", "9876FGT", "Verde"),
						new Coche("Honda", "7645ERF", "Amarillo"))
						);
				
				mockmvc.perform(get("/coches")).andExpect(status().isOk())
				.andExpect(view().name("coches/listar"))
				.andExpect(model().attributeExists("coches")
				);
	}

}
