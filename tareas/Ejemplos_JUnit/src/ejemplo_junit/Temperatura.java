package ejemplo_junit;

public class Temperatura {
	
	public double fahrenheit_to_celsius(double fahrenheit) {
		double celsius = ((fahrenheit - 32) / 1.8);
		return celsius;
	}
	
	public double celsius_to_fahrenheit(double celsius) {
		double fahrenheit = (celsius * 1.8 + 32);
		return fahrenheit;
	}

}
