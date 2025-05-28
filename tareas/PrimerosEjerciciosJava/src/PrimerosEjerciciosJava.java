
public class PrimerosEjerciciosJava {
	
	public static void main(String[] args) {
		// Comentario de una sola línea
		/* Comentario de varias líneas 1
		 * Cm 2
		 * Cm 3
		 */
		
		// DECLARACIÓN DE VARIABLES Y CONSTANTES
		
		int numero=9, num2=7; // ESTÁN YA INICIADAS
		/*int indica que es un número entero. 
		 * numero: nombre que le asigno a la variable
		 * es una declaración
		 */
		long numLargo; //variable de tipo entero largo. Sufijo L. EJ: 2000000000L
		float numDecimal; //variable de tipo decimal. Sufijo F. EJ: 2.20906F
		double numDecimalLargo; //variable de tipo decimal largo. No lleva sufijo
		String apellidos="Córdoba Rodríguez.";//variable de tipo cadena de texto
		char letraDNI='H';//variable de tipo letra. 
		boolean valorX = false;
		final double PI = 3.1416;
		int resultado;
		
		
		//INICIALIZACIÓN
		resultado = numero+num2;
		resultado++;
		
		System.out.println(resultado);
		
		
		System.out.println("El valor de número es "+num2+". ");
		
		num2=9;
		
		System.out.println("El nuevo valor de número es "+num2+".");
		
		System.out.print(apellidos+letraDNI);
		
	}

}
