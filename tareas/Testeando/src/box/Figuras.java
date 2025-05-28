package box;

public class Figuras {
	
	private int ancho;
	private int alto;
	
	public Figuras(int ancho, int alto) {
		this.alto = alto;
		this.ancho = ancho;
	}
	
	public int area() {
		return ancho * alto;
	}
	
	public int perimetro() {
		return (ancho*2)+(alto*2);
	}

}
