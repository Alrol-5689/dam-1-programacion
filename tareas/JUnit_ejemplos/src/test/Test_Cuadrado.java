package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import box.Cuadrado;

class Test_Cuadrado {

	@Test
	void areaCuadrado() {
		System.out.println("Área del cuadrado.");
		double lado = 3, exp = 9;
		var cuadrado = new Cuadrado(lado);
		var resultado = cuadrado.areaCuadrado();
		assertEquals(exp, resultado);
	}
	@Test
	void perimetroCuadrado() {
		System.out.println("Perímetro del cuadrado.");
		double lado = 3, exp = 12;
		var cuadrado = new Cuadrado(lado);
		var resultado = cuadrado.perimetroCuadrado();
		assertEquals(exp, resultado);
	}


}
