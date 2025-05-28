import java.util.Scanner;

public class Ejercicio_5_Par_Impar {

	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABVLES
		
		double num1, resto;
		Scanner sc = new Scanner (System.in);
		
		// PETICIÓN DE NÚMERO
		
		System.out.println("Escribe un número: ");
		num1=sc.nextInt();
		
		resto = num1 % 2 ;
		
		// IMPRIMIENDO RESULTADO
				
		if (resto==0) {
			System.out.println(num1+" es un número par.");
		}
		else {
			System.out.println(num1+" es un número impar.");
		}
	   
	}
	
}

