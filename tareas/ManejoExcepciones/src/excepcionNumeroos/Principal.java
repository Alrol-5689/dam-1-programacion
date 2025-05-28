package excepcionNumeroos;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numero = 0;
		
		System.out.print("Ingrese un número entero: ");
		
		while(true) {			
			
			String entrada = sc.next();
			
			try {
				
				numero = Integer.parseInt(entrada);
				System.out.println("Número válido: "+numero);
				break;
				
			}catch(NumberFormatException e) {
				
				System.err.print("Error: entrada inválida. Debe ingresar solo número enteros: ");
				
			}
			
		}
		
		System.out.println("Programa finalizado correctamente.");

	}

}
