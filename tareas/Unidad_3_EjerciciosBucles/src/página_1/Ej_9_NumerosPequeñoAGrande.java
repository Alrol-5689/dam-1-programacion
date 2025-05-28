package página_1;

import java.util.Scanner;

public class Ej_9_NumerosPequeñoAGrande {

	// DADO DOS NÚMERO, QUE LA CONSOLA IMPRIMA LOS NÚMEROS QUE HAY DEL PEQUEÑO AL GRANDE
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pequeño, grande;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce el primer número: ");
		int x1=sc.nextInt();
		System.out.print("Introduce el segundo número: ");
		int x2=sc.nextInt();
		
		if(x1>x2) {
			grande=x1;
			pequeño=x2;
		}
		else {
			grande=x2;
			pequeño=x1;
		}
		
		for(int i=pequeño+1;i<grande;i++) {
			System.out.println(i);
		}

	}

}
