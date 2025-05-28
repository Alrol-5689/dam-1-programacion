package box;

public class Circulo {

	private double radio;

	public Circulo(double radio) {
		this.radio = radio;
	}

	public double areaCirculo() {
		return Math.PI * Math.pow(radio, 2);
	}

	public double perimetroCirculo() {
		return 2 * Math.PI * radio;
	}

}
