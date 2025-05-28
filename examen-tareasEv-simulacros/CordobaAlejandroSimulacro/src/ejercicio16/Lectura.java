package ejercicio16;

import java.util.Scanner;

public class Lectura {
	
	protected int menu(Scanner sc) {
		while (true) {
			System.out.println("\n===========================================================================================================================================\n");
			System.out.println("1.- Registrar barco.");
			System.out.println("2.- Mostrar barcos.");
			System.out.println("3.- Calcular capacidad.");
			System.out.println("4.- Salir.");
			System.out.print("Introduce una opción: ");
			try {
				int opcion = Integer.parseInt(sc.next());
				sc.nextLine(); // buffer				
				if (opcion > 0 && opcion < 5) {
					return opcion;
				} else
					System.err.println("Error: introduce un número dentro del rango. ");
			} catch (NumberFormatException e) {
				System.err.println("Error: introduce un valor numérico. ");
			}
		}
	}
	
	protected String pedirString(Scanner sc, boolean permitirVacio, String mensaje) {
		System.out.print(mensaje);
		while (true) {
			String input = sc.nextLine();
			if (permitirVacio || !input.trim().isEmpty()) {
				return input;
			}
			System.err.println("Error: El campo no puede estar vacío.");
			System.out.print(mensaje);
		}
	}
	
	public double pedirDouble(Scanner sc, String mensaje) {
		System.out.print(mensaje);
		while (true) {
			try {
				double out = Double.parseDouble(sc.nextLine().replace(",", "."));
				return out;
			} catch (NumberFormatException e) {
				System.err.println("Error. Introduce solo números. ");
				System.out.print(mensaje);
			}
		}
	}
	
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
	
	protected int pedirInt(Scanner sc, String mensaje) {
		System.out.print(mensaje);
		while (true) {
			try {
				int out = Integer.parseInt(sc.nextLine());
				return out;
			} catch (NumberFormatException e) {
				System.err.println("Error. Introduce solo números. ");
				System.out.print(mensaje);
			}
		}
	}

}
