package box;

public class Rectangulo extends Figura2D implements FiguraGeometrica {
	
	// Atributos 

	protected double base, altura;
	
	// Constructores
	
	protected Rectangulo(String nombre, double base, double altura) {
		super(nombre);
		this.altura = altura;
		this.base = base;	
	}
	
	// Métodos
	
	@Override
	public double calcularPerimetro() {
		double perimetro = (this.altura*2) + (this.base*2);
		return perimetro;
	}

	@Override
	public String toString() {
		return "Rectangulo [base=" + base + ", altura=" + altura + "]";
	}
	
	

}
