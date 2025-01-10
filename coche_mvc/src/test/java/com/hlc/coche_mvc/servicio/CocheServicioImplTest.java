package com.hlc.coche_mvc.servicio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hlc.coche_mvc.entidad.Coche;
import com.hlc.coche_mvc.repositorio.CocheRepositorio;

class CocheServicioImplTest {

	@Mock  // -> Simplamos el repositorio como dependencia
	private CocheRepositorio cocheRepositorio;

	@InjectMocks // Creamos una instancia real de cocheServicioImp y se inyecta automáticamenete
	private CocheServicioImpl cocheServicio;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void obtenerTodosLosCoches() {
		List<Coche> coches = Arrays.asList(
				new Coche("Toyota", "1234ABC", "Rojo"),
				new Coche("Ford", "9876FGT", "Verde"),
				new Coche("Honda", "7645ERF", "Amarillo")
		);
		
		when(cocheRepositorio.findAll()).thenReturn(coches);
		
		//Llamar al servicio
		List<Coche> coche_servicio = cocheServicio.obtenerTodosLosCoches();
		Integer resultadoEsperado = 2;
		Integer resultado = coche_servicio.size();
		
		assertEquals(resultadoEsperado, resultado);
		verify(cocheRepositorio, times(1)).findAll();
	}
	
	@Test
	void testGuardarCoche() {
		
	}

}
