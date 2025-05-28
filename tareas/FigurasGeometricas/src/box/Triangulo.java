package box;

public class Triangulo extends Figura2D implements FiguraGeometrica {
	
	// Atributos
	
	protected double a, b, c;
	
	// Constructores
	
	protected Triangulo(String nombre, double a, double b, double c) {
		super(nombre);
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	// Métodos
	
	@Override
	public String toString() {
		return "Triangulo [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
	@Override
	public double calcularPerimetro() {
		double perimetro = a+b+c;
		return perimetro;
	}

}
