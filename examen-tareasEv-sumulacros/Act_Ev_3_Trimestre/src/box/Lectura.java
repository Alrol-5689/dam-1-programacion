package box;

import java.time.LocalDate;
import java.util.Scanner;

public class Lectura {

	protected int menuPrincipal(Scanner sc) {
		while (true) {
			System.out.println("\n==============================================================================\n");
			System.out.println("1.- Crear una publicación.");
			System.out.println("2.- Eliminar publicación.");
			System.out.println("3.- Eliminar cuenta.");
			System.out.println("4.- Editar perfil.");
			System.out.println("5.- Cambiar pin.");
			System.out.println("6.- Cerrar sesión.");
			System.out.println("7.- Salir.");
			System.out.print("Introduce una opción: ");
			try {
				int opcion = Integer.parseInt(sc.next());
				sc.nextLine(); // buffer
				if (opcion > 0 && opcion < 8) {
					return opcion;
				} else
					System.err.println("Error: introduce un número dentro del rango. ");
			} catch (NumberFormatException e) {
				System.err.println("Error: introduce un valor numérico. ");
			}
		}
	}

	protected int menuSesion(Scanner sc) {
		while (true) {
			System.out.println("\n==============================================================================\n");
			System.out.println("1.- Iniciar sesión.");
			System.out.println("2.- Crear cuenta.");
			System.out.println("3.- Salir.");
			System.out.print("Introduce una opción: ");
			try {
				int opcion = Integer.parseInt(sc.next());
				sc.nextLine(); // buffer
				if (opcion > 0 && opcion < 4) {
					return opcion;
				} else
					System.err.println("Error: introduce un número dentro del rango. ");
			} catch (NumberFormatException e) {
				System.err.println("Error: introduce un valor numérico. ");
			}
		}
	}

	protected LocalDate pedirFecha(Scanner sc, String mensaje) {
		System.out.println(mensaje);
		while (true) {
			try {
				int anio = pedirInt(sc, "Año: ");
				int mes = pedirInt(sc, "Mes: ");
				int dia = pedirInt(sc, "Día: ");
				return LocalDate.of(anio, mes, dia);
			} catch (java.time.DateTimeException e) {
				System.err.println("Fecha no válida: " + e.getMessage());
				System.out.println("Por favor, introdúcela de nuevo.\n");
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

	protected boolean confirmacionSiNo(Scanner sc, String mensaje) {
		while (true) {
			System.out.print(mensaje);
			String entrada = sc.nextLine();
			if (entrada.equalsIgnoreCase("s")) {
				return true;
			}
			if (entrada.equalsIgnoreCase("N")) {
				return false;
			}
			System.err.println("\nError: Introduce 'S' o 'N'. ");
		}
	}


}
