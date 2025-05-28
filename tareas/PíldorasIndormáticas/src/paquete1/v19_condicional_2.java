package paquete1;

import java.util.*;

public class v19_condicional_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int numero=0, intentos=0, aleatorio=(int)(Math.random()*100);
		
		while(numero!=aleatorio) {
			
			intentos++;
			System.out.println("Introsuce un número por favor:");
			numero=sc.nextInt();
			if(aleatorio<numero) System.out.println("Más bajo");
			else if(aleatorio>numero) System.out.println("Más alto");
		}
		System.out.println("Correcto. Lo has conseguido en "+intentos+" intentos.");
		
		
		
		
		
		
		
		
		
		
		

	}

}
