package ejercicios_arrays_bidimensionales;

import java.util.Scanner;

public class Lista5N_aleatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);		
		System.out.print("Indica el cuántas columnas tendrá cada una de las 5 filas: ");
		final int COLUMNAS=sc.nextInt();
		int[][]lista=new int[5][COLUMNAS];
		
		for(int i=0;i<lista.length;i++) {
			for(int j=0;j<lista[i].length;j++) {
				
				double random1 = Math.random();
				double random2 = Math.random()*10; // GENERA NÚMERO ALEATORIOS DEL 0 AL 9 --> A NO SER QUE ANTES DE PASAR A INT HAGA REDONEO
				double random2_0= Math.round(Math.random()*10);
				double random3 = Math.random()*11; // GENERA NÚMERO ALEATORIOS DEL 0 AL 10 AMBOS INCLUSIVE, AL IGUA QUE RANDOM2_0
				
				lista[i][j]=(int)random2_0;
			}
		}
		for(int i=0;i<lista.length;i++) {	
			System.out.println();
			for(int j=0;j<lista[i].length;j++) {
				System.out.printf("%3d ",lista[i][j]);  // CADA VALOR OCUPA 3 ESPACIOS, POR LO QUE LA MATRIZ EN CONSOLA SALE CUADRADA
			}			
		}
		
		

	}

}
