package box;

public class ManejoExcepciones {

	public static void main(String[] args) {
		
		try {
			
			int[] numeros = {1, 2, 3};
			int numero = 10; 
			
			System.out.println("Resultado: "+(numero/0)); // ArithmeticException
			System.out.println(numeros[5]); // ArrayIndexOutOfBoundsException
			
		}catch(ArithmeticException e) {
			
			System.err.println("Error: División por cero -> " + e.getMessage());
			
		}catch(ArrayIndexOutOfBoundsException e) {
			
			System.err.println("Error: Índice fuera de los límites -> " + e.getMessage());
			
		}catch(Exception e) {
			
			System.err.println("Error general -> " + e.getMessage());
			
		}finally {
			
			System.out.println("Bloque finally ejecutado.");
			
		}


	}

}
