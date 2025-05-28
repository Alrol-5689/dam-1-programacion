package ejemplo_junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFactorial {

	@Test public void testFactorial() {
		
		System.out.println("factorial");
		int a = 3;
		Operaciones f = new Operaciones();
		int exp = 6;
		int resultado = f.factorial(a);
		assertEquals(exp, resultado);
		
	}

}
