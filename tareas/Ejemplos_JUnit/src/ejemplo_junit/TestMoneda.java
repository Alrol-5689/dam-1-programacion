/**
 * 
 */
package ejemplo_junit;

import static org.junit.Assert.*;

import org.junit.*;

public class TestMoneda {

	@Test public void testDolar_to_Euro() {
		
		System.out.println("DollarToEuro");
		double dollar = 10.5;
		Moneda instance = new Moneda();
		double expResultado = 8.92;
		double resultado = Math.round(instance.dolar_to_Euro(dollar)*100.0)/100.0;
		assertEquals(expResultado, resultado, 0.0);
		
	}

	@Test public void testEuro_to_dolar() {
		
		System.out.println("EuroToDollar");
		double euro = 20.30;
		Moneda instance = new Moneda();
		double expResultado = 23.88;
		double resultado = Math.round(instance.euro_to_dolar(euro)*100.0)/100.0;
		assertEquals(expResultado, resultado, 0.0);
		
	}


}
