

/*
 * 1.- Pedir el nombre y tres notas por teclado al usuario para poder mostrar la media. 
 * Tenéis que hacer el ejercicio con números enteros y con decimales. Me entregáis la versión que queráis.
 * El mensaje que debe mostrar tiene que ser: Bienvenido .......: tu nota es......
 */



import java.util.Scanner;

public class Ejercicio_1_Notas {

	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABLES
		
		String nombre;
		
		double nota1, nota2, nota3, media;
		
		Scanner sc = new Scanner(System.in);
		
		// PETICIÓN DE DATOS
		
		System.out.print("Dime tu nombre: ");
		nombre = sc.next();
		
		System.out.println("Dime la primera nota: ");
		nota1 = sc.nextDouble();
		
        System.out.println("Dime la segunda nota: ");
		nota2 = sc.nextDouble();
		
        System.out.println("Dime la tercera nota: ");
		nota3 = sc.nextDouble();
		
		media = (nota1+nota2+nota3)/3;
		
		// MOSTRAR SOLUCIÓN
		
		System.out.println("Bienvenido "+nombre+", tu nota media es "+media+".");
		
	}

}
