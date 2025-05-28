package box;

import java.util.Scanner;

public class Pruebas {
	
	protected int pedirOpcion(Scanner sc, int min, int max, String mensaje) {

		System.out.print(mensaje);
		while (true) {
			try {
				int opcion = Integer.parseInt(sc.nextLine());
				if (opcion >= min && opcion <= max)
					return opcion;
				System.out.println("\nPor favor, introduce un número entre " + min + " y " + max + " : ");
			} catch (NumberFormatException e) {
				System.err.print("\nError: Ingresa solo número: ");
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		


		


		

		



		


		


		

	}

}
