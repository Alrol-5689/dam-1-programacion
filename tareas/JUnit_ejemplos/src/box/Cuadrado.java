package box;

public class Cuadrado {

	private double lado;

	public Cuadrado(double lado) {
		this.lado = lado;
	}

	public double perimetroCuadrado() {
		return this.lado * 4;
	}

	public double areaCuadrado() {
		return Math.pow(lado, 2);
	}

}
