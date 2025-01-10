package com.hlc.coche_mvc.repositorio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hlc.coche_mvc.entidad.Coche;


@DataJpaTest
class CocheRepositorioTest {

	@Autowired
	private CocheRepositorio cocheRepositorio;
	
	@Test
	void testSaveAndFindAll() {
		//Crear y guaradr coches
		Coche coche1 = new Coche("Toyota", "1234ABC", "Rojo");
		Coche coche2 = new Coche("Ford", "9876FGT", "Verde");
		Coche coche3 = new Coche("Honda", "7645ERF", "Amarillo");
		
		cocheRepositorio.save(coche1);
		cocheRepositorio.save(coche2);
		
		List<Coche> coches = cocheRepositorio.findAll();
		
		Integer resultadoEsperado = 2;
		
		assertEquals(resultadoEsperado, coches.size());
		assertTrue(coches.stream().anyMatch(c -> c.getMarca().equals("Toyota")));
		assertTrue(coches.stream().anyMatch(c -> c.getMarca().equals("Ford")));
	}

}
