
/*3.- 
 * Dado nos números por teclado, que me muestre cuál es el mayor, menor y si son iguales.
 */


import java.util.Scanner;

public class Ejercicio_4_OrdenarNumeros {

	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABLES
		
		int num1, num2, num3;
		Scanner sc = new Scanner(System.in);
		
		// PETICIÓN DE DATOS
		
		System.out.print("Dime el primer número: ");
		num1=sc.nextInt();
		
		System.out.print("Dime el segundo número: ");
		num2=sc.nextInt();
		
		System.out.print("Dime el tercer número: ");
		num3=sc.nextInt();
		
		// IMPRIMIENTO EL NÚMERO MAYOR
		
		if (num2<num1 && num1>num3 && num1!=num2 && num1!=num3 && num3!=num2) {
			System.out.println("El número mayor es: "+num1);
		}
		if (num1<num2 && num2>num3 && num1!=num2 && num1!=num3 && num3!=num2) {
			System.out.println("El número mayor es: "+num2);
		}
		if (num1<num3 && num3>num2 && num1!=num2 && num1!=num3 && num3!=num2) {
			System.out.println("El número mayor es: "+num3);
		}
		
		// IMPRIMIENDO EL NÚMERO MEDIANO - SUPONIENDO QUE ES EL PRIMERO
		
		if (num2>num1 && num1>num3 && num1!=num2 && num1!=num3 && num3!=num2) {
			System.out.println("El número mediano es: "+num1);
		}
		if (num3>num1 && num1>num2 && num1!=num2 && num1!=num3 && num3!=num2) {
			System.out.println("El número mediano es: "+num1);
		}
		
		// IMPRIMIENDO EL NÚMERO MEDIANO - SUPONIENDO QUE ES EL SEGUNDO
				
		if (num1>num2 && num2>num3 && num1!=num2 && num1!=num3 && num3!=num2) {
			System.out.println("El número mediano es: "+num2);
		}
		if (num1<num2 && num2<num3 && num1!=num2 && num1!=num3 && num3!=num2) {
			System.out.println("El número mediano es: "+num2);
		}
		
		// IMPRIMIENDO EL NÚMERO MEDIANO - SUPONIENDO QUE ES EL TERCERO
		
		if (num1>num3 && num3>num2 && num1!=num2 && num1!=num3 && num3!=num2) {
			System.out.println("El número mediano es: "+num3);
		}
		if (num1<num3 && num3<num2 && num1!=num2 && num1!=num3 && num3!=num2) {
			System.out.println("El número mediano es: "+num3);
		}
		
		// IMPRIMIENDO EL NÚMERO MENOR
		
		if (num2>num1 && num1<num3 && num1!=num2 && num1!=num3 && num3!=num2) {
			System.out.println("El número menor es: "+num1);
		}
		if (num1>num2 && num2<num3 && num1!=num2 && num1!=num3 && num3!=num2) {
			System.out.println("El número menor es: "+num2);
		}
		if (num1>num3 && num3<num2 && num1!=num2 && num1!=num3 && num3!=num2) {
			System.out.println("El número menor es: "+num3);
		}
		
		// IMPRIMIENDO EXIGENCIA DE QUE LOS 3 NÚMEROS SEAN DIFERENTES
		
		if (num1==num3 || num1==num2 || num2==num3) {
			System.out.println("Los 3 números han de ser diferentes.");
		}
				
	}

}
