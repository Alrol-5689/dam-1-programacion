package box;


public class Rectangulo {
	
	private int ancho;
	private int alto;
	
	public Rectangulo(int ancho, int alto) {
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
