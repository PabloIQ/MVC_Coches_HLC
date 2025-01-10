package com.hlc.coche_mvc.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CocheTest {

	private Coche coche;
	
	@BeforeEach
	void setup() {
		coche = new Coche();
	}
	
	@Test
	@DisplayName("Prueba de Getter and Setter de ID")
	void testSetAndGetId() {
		Long id = 1L;
		coche.setId(1L);
		
		assertEquals(id, coche.getId());
	}

	@Test
	@DisplayName("Prueba de Getter and Setter de MArca")
	void testSetAndGetMarca() {
		String marca = "Toyota";
		coche.setMarca(marca);
		
		assertEquals(marca, coche.getMarca(), "La marca no es correcta");
	}
	
	@Test
	@DisplayName("Prueba de constructor con parámetros")
	void testConstructorConParametros() {
		String marca = "Toyota";
		String matrícula = "1245ABC";
		String color = "Rojo";
		
		Coche coche = new Coche(marca, matrícula, color);
		
		assertEquals(marca, coche.getMarca());
		assertEquals(matrícula, coche.getMatrícula());
		assertEquals(color, coche.getColor());
	}
}
