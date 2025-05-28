package ejemplo_junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestOperaciones {

	@Test public void testMultiplicacion() {
		
		System.out.println("multiplicación");
		int a = 2, b = 2;
		Operaciones f = new Operaciones();
		int exp = 5;
		int resultado = f.multiplica(a, b);
		assertEquals(exp, resultado);
		
	}
	
	@Test public void testFactorial() {
		
		System.out.println("factorial");
		int a = 3;
		Operaciones f = new Operaciones();
		int exp = 6;
		int resultado = f.factorial(a);
		assertEquals(exp, resultado);
		
	}
	

}
