package ejemplo_junit;

public class Moneda {
	
	public double dolar_to_Euro(double dolar) {
		double euro = dolar * 0.85;
		return euro;
	}
	public double euro_to_dolar(double euro) {
		double dolar = euro / 0.85;
		return dolar;
	}

}
