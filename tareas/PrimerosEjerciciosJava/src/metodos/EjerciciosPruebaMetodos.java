package metodos;

import java.util.Scanner;

public class EjerciciosPruebaMetodos {

	public static void main(String[] args) {
		// Variables
		int edad=28;
		int[] notas = {1, 2, 3};
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Mi edad es "+edad);
		
		edad = imprimirPorPantalla(edad);
		
		System.out.println("Mi nueva edad es "+edad);
		
		imprimirtNotas(notas, sc);
		
		System.out.println("La nota de la posición 1 (main): "+notas[0]);
		

	}
	
	public static void imprimirtNotas(int[] notas, Scanner sc) {
		System.out.print("Dime la nota a guardar en la posición 1: ");
		notas[0]=sc.nextInt();
		System.out.println("La nota de la posición 1 (método): "+notas[0]);
		
	}
	
	public static int imprimirPorPantalla(int edad) {
		edad=38;
		return edad;
	}

}
