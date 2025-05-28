package EjerciciosResueltos;

import java.util.Scanner;

public class Ejercicio_3 {

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
		
		if (num1>num2) {
			System.out.println("El número "+num1+" es mayor que el número "+num2+".");
		}
		else {
			if(num1<num2) {
				System.out.println("El número "+num2+" es mayor que el número "+num1+".");
			}
			else {
				System.out.println("Ambos número son iguales.");
			}
			
		}
							
	}

}