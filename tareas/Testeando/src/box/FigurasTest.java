package box;

import static org.junit.Assert.*;

import org.junit.Test;

public class FigurasTest {

	@Test
	public void testArea() {
		Figuras r = new Figuras(3, 4);
		assertEquals(12, r.area());
	}

	@Test
	public void testPerimetro() {
		Figuras r = new Figuras(3, 4);
		assertEquals(14, r.perimetro());
	}

}
