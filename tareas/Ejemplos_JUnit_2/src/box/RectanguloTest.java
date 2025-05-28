package box;


import static org.junit.Assert.*;

import org.junit.Test;

class RectanguloTest {

	@Test
	void test() {
		Rectangulo r = new Rectangulo(3, 4);
		assertEquals(14, r.perimetro());
		assertEquals(12, r.area());
		assertEquals(5, r.perimetro());
	}

}
