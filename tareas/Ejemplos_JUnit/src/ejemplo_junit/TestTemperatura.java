/**
 * 
 */
package ejemplo_junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTemperatura {

	@Test public void testFahrenheit_to_celsius() {
		
		System.out.println("fahrenheit_to_celsius");
		double fahrenheit = 32;
		Temperatura t = new Temperatura();
		double exp = 0;
		double resultado = Math.round(t.fahrenheit_to_celsius(fahrenheit)*100.0)/100.0;
		assertEquals(exp, resultado, 0.0);
		
	}

	@Test public void testCelsius_to_fahrenheit() {
		
		System.out.println("celsius_to_fahrenheit");
		double celsius = 15;
		Temperatura t = new Temperatura();
		double exp = 59;
		double resultado = Math.round(t.celsius_to_fahrenheit(celsius)*100.0)/100.0;
		assertEquals(exp, resultado, 0.0);
		
	}

}
