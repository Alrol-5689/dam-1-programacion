package ejemplo_junit;

public class Operaciones {
	
	public int multiplica(int num1, int num2) {
		
		return num1 * num2;
		
	}
	
	public int factorial(int num) {
		
		for(int i = (num - 1); i > 1; i--) {
			num = num * i;
		}
		return num;
		
	}

}


