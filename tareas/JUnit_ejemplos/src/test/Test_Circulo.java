package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import box.Circulo;

class Test_Circulo {

	@Test
	void perimetroCirculo() {
		System.out.println("Perímetro del cuadrado.");
		double radio = 3, exp = 18.854;
		var circulo = new Circulo(radio);
		var resultado = Math.round(circulo.perimetroCirculo() * 100) / 100.0;
		assertEquals(exp, resultado, 0.009);
		
	}

	@Test
	void areaCirculo() {
		System.out.println("Área del cuadrado.");
		double radio = 3, exp = 28.27;
		var circulo = new Circulo(radio);
		var resultado = Math.round(circulo.areaCirculo() * 100) / 100.0;
		assertEquals(exp, resultado);
	}

}
