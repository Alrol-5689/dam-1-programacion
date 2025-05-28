package ejemplo_junit;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operaciones o = new Operaciones();
		Moneda m = new Moneda();
		Temperatura t = new Temperatura();
		
		
		int num_1, num_2;
		
		num_1 = -5;
		num_2 = -40;
		
		System.out.println(t.fahrenheit_to_celsius(num_2));
		System.out.println(t.celsius_to_fahrenheit(num_1));
		
		
		

	}
	
	

}
