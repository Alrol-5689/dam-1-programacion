package mes11_21;

import java.util.Scanner;

public class Ej_2_SumarMultiplicar {
	
	// SUMA Y MULTIPLICA NÚMEROS HASTA QUE EL USUARIO INTRODUZCA UN 0 POR TECLADO
	
	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABLES
		
		int sumaNumeros=0, num, productoNumeros=1;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("Introduce el número: ");
			num=sc.nextInt();
		}while(num!=0);

	}

}
