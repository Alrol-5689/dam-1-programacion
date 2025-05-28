package box;

public class Circulo extends Figura2D implements FiguraGeometrica{
	
	// Atributos
	
	protected double radio;
	
	// Constructores

	protected Circulo(String nombre, double radio) {
		super(nombre);
		this.radio = radio;
	}	
	
	// Métodos
	
	@Override
	public double calcularPerimetro() {
		double perimetro = 2*Math.PI*this.radio;
		return perimetro;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + "]";
	}

}
