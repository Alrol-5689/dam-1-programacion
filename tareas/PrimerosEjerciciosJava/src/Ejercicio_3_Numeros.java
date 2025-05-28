
/*3.- 
 * Dado nos números por teclado, que me muestre cuál es el mayor, menor y si son iguales.
 */


import java.util.Scanner;

public class Ejercicio_3_Numeros {

	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABLES
		
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		
		// PETICIÓN DE DATOS
		
		System.out.print("Dime el primer número: ");
		num1=sc.nextInt();
		
		System.out.print("Dime el segundo número: ");
		num2=sc.nextInt();
		
		// IMPRIMIENTO RESULTADO
		
		if (num1==num2) {
			System.out.println(num1+" y "+num2+" son iguales.");
		}
		else {
			if (num1<num2) {
				System.out.println(num1+" es menor que "+num2+".");
			}
			else {
				System.out.println(num1+" es mayor que "+num2+".");
			}
		}
						
	}

}
