package mes11_18;

import java.util.Scanner;

public class Ejercicio4U4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escriba una frase");
		
		// Usamos nextLine en lugar de next por los espacios
		// next cogería hasta el primer espacio mientras que nextLine coge hasta el primer enter
		
		String frase = teclado.nextLine();
		
		//Creamos un array de caracteres
		
		char caracteres[] = new char[frase.length()];
		
		//Recorremos la frase, cogemos cada caracter y lo metemos en el array
		
		for(int i=0;i<frase.length();i++){
			caracteres[i]=frase.charAt(i);
			System.out.println(caracteres[i]);
		}
		
		


	}

}
