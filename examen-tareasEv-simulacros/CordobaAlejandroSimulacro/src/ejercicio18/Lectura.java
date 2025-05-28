package ejercicio18;

import java.util.Scanner;

public class Lectura {
	
	protected int pedirOpcion(Scanner sc, int min, int max, String mensaje) {
		System.out.print(mensaje);
		while (true) {
			try {
				int opcion = Integer.parseInt(sc.nextLine());
				if (opcion >= min && opcion <= max) {
					return opcion;
				}
				System.err.println("Por favor, introduce un número entre " + min + " y " + max + ".");
			} catch (NumberFormatException e) {
				System.err.println("Error: Ingresa solo números. ");
			}
			System.out.print(mensaje);
		}
	}

}
