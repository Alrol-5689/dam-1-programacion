package ejemplo_junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMultiplica {

	@Test public void testMultiplicacion() {
		
		System.out.println("multiplicación");
		int a = 2, b = 2;
		Operaciones f = new Operaciones();
		int exp = 4;
		int resultado = f.multiplica(a, b);
		assertEquals(exp, resultado);
		
	}

}
