package edu.udelp.orientada_objetos.proceso;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.udelp.orientada_objetos.modelo.Cuadrado;

class CuadradoProcessTest {

	@Test
	void testPerimetroCuadrado() {
		CuadradoProcess instance=new CuadradoProcess();
		Cuadrado cuadrado=new Cuadrado();
		
		cuadrado.setLado(2D);
		
		Double result =instance.perimetro(cuadrado);
		assertEquals(8, result);
		
		
	}

	@Test
	void testAreaCuadrado() {
		
	}

}
