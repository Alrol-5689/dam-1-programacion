

import java.util.Scanner;

public class Ejercicio_4_2 {

	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABLES
		
		double num1, num2, num3;
		Scanner sc = new Scanner(System.in);
		
		// PETICIÓN DE DATOS
		
		System.out.print("Dime el primer número: ");
		num1 = sc.nextDouble();
		
		System.out.print("Dime el segundo número: ");
		num2 = sc.nextDouble();
		
		System.out.print("Dime el tercer número: ");
		num3 = sc.nextDouble();
		
		
		
		// IMPRIMIENDO EL NÚMERO MAYOR
		
		
		
		if (num1>num2) {
			if (num1>num3) {
				System.out.println("El número mayor es el "+num1+".");
			}
			else {
				System.out.println("El número mayor es el "+num3+".");
			}
		}
		else {
			if (num2>num3) {
				System.out.println("El número mayor es el "+num2+".");
			}
			else {
				System.out.println("El número mayor es el "+num3+".");
			}
		}
		
		
		
		// IMPRIMIENDO EL NÚMERO MEDIANO
		
		
		
		if (num2<num1) {
			if (num3>num1) {
				System.out.println("El número mediano es el: "+num1+".");
			}
			else {
				if (num2>num3) {
					System.out.println("El número mediano es el: "+num2+".");
				}
				else {
					System.out.println("El número mediano es el: "+num3+".");
				}
			}
		}
		else {
			if (num2<num3) {
				System.out.println("El número mediano es el: "+num2+".");
			}
			else {
				if (num1>num3) {
					System.out.println("El número mediano es el: "+num1+".");
				}
				else {
					System.out.println("El número mediano es el: "+num3+".");
				}
			}
		}
		
		
		
		// IMPRIMIENDO EL NÚMERO PEQUEÑO
		
		
		
		if (num1<num2) {
			if (num1<num3) {
				System.out.println("El número pequeño es el "+num1+".");
			}
			else {
				System.out.println("El número pequeño es el "+num3+".");
			}
		}
		else {
			if (num2<num3) {
				System.out.println("El número pequeño es el "+num2+".");
			}
			else {
				System.out.println("El número pequeño es el "+num3+".");
			}
		}
		
		
		
		// IMPRIMIENDO EXIGENCIA DE QUE LOS 3 NÚMEROS SEAN DIFERENTES
		
				if (num1==num3 || num1==num2 || num2==num3) {
					System.out.println("Los 3 números han de ser diferentes.");
				}
		
	}

}
