package EjerciciosResueltos;

import java.util.Scanner;

public class Ejercicio_6 {

	public static void main(String[] args) {
				
		// DECLARACIÓN DE VARIABLES
		
		double nota;
		Scanner sc = new Scanner(System.in);
				
		// PETCICIÓN DE NOTA
				
		System.out.print("ESCRIBE TU NOTA: ");
		nota=sc.nextDouble();
				
		// IMPRIMIENDO RESULTADO
		
		if(nota>=0 && nota<=10) {
			if(nota>=0 && nota<5) {
				System.out.println("INSUFICIENTE");
			}
			else if(nota>=5 && nota<6){
				System.out.println("BIEN");
			}
		}
		else {
			System.out.println("Nota incorrecta.");
		}

	}

}
