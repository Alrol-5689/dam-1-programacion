package mes11_18;

import java.util.Scanner;
public class Ejercicio1U4 {
		
		/* Crea un array de 10 posiciones de números con valores pedidos por teclado.
		* Muestra por consola el indice y el valor al que corresponde.*/
		
	public static void main(String[] args){
		final int LONGITUD = 10;
		int arrayNum[]=new int[LONGITUD];
		Scanner teclado = new Scanner(System.in);
			
		// Rellenamos el array
			
		
		for(int i=0;i<arrayNum.length;i++){
			System.out.print("Introduce el número de la posición "+(i+1)+":  ");
			arrayNum[i]=teclado.nextInt();
		}
		System.out.println();
		teclado.close();
			
		// Mostramos el array
			
		for(int i=0;i<arrayNum.length;i++){
		System.out.println("En la posición "+(i+1)+" esta el valor "+arrayNum[i]);
		}
	}
}
