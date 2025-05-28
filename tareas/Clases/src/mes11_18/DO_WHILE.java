package mes11_18;

import java.util.Scanner;

public class DO_WHILE {

	public static void main(String[] args) {
		
		
		int menu=1, num1, num2;
		boolean valor=true;
		Scanner sc= new Scanner(System.in);
		
		
				
		do {
			System.out.print("¿Cuás es el primer número?");
			num1=sc.nextInt();
			System.out.println("¿Qué operación deseas realizar?\n");
			System.out.println("1.- Sumar");
			System.out.println("2.- Restar");
			System.out.println("3.- Multiplicar");
			System.out.println("4.- Dividir");
			System.out.println("5.- Salir\n");
			menu=sc.nextInt();
			
			switch(menu) {
			case 1:
				System.out.print("Escribe el segundo número:");
				num2=sc.nextInt();
			}
			
			
		}while(menu!=5);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
