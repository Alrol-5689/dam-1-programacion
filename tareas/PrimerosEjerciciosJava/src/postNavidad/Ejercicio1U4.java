package postNavidad;

import java.util.Scanner;

public class Ejercicio1U4 {
	
	/*
	* Crea un array de 10 posiciones de números con valores pedidos por teclado.
	* Muestra por consola el indice y el valor al que corresponde.
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int LONGITUD = 10;
		int[] arrayNum = new int[LONGITUD];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<LONGITUD; i++) {
			System.out.println("Escribe el número de la posición "+(i+1)+": ");
			arrayNum[i] = sc.nextInt();
		}
		
		sc.close();
		
		for(int i=0; i<arrayNum.length; i++) {
			System.out.println("En el indice "+i+" esta el valor "+arrayNum[i]);
		}

	}

}
