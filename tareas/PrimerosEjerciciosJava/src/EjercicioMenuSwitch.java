import java.util.Scanner;

public class EjercicioMenuSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		char seleccionTarea;
		System.out.println("\nElige qué tarea quieres realizar:"
				+ "\n\n  ( A ) ---> Quiero saber si un número es par o impar. "
				  + "\n  ( B ) ---> Quiero calcular mi sueldo. "
			 	  + "\n  ( C ) ---> Quiero saber el precio final de un producto.\n ");
		
		seleccionTarea = Character.toLowerCase(sc.next().charAt(0));
		
		switch(seleccionTarea) {
		
		case 'a': // PAR O IMPAR ---- PAR O IMPAR ---- PAR O IMPAR ---- PAR O IMPAR ---- PAR O IMPAR ---- PAR O IMPAR ---- PAR O IMPAR ---- PAR O IMPAR ---- PAR O IMPAR ---- PAR O IMPAR ---- 
			
			int ParImpar=0, resto=0;
			System.out.print("\nDime el número: ");
			ParImpar=sc.nextInt();
			resto=ParImpar%2;
			if(resto==0) System.out.print("\nSe trata de un número par. ");
			else System.out.print("\nSe trata de un número impar. ");
			
			break;
		
		case 'b': // SALARIO-----SALARIO-----SALARIO-----SALARIO-----SALARIO-----SALARIO-----SALARIO-----SALARIO-----SALARIO-----SALARIO-----SALARIO-----SALARIO-----SALARIO-----SALARIO-----
			
			char seleccionClase;
			int horas=0, sueldo=0;
			final int claseA=25, claseB=20, claseC=15, claseD=10;
			System.out.println("\nIndica la Clase a la que perteneces: "
											+ "\n\n  ( A ) ---> Clase A."
											  + "\n  ( B ) ---> Clase B."
											  + "\n  ( C ) ---> Clase C."
											  + "\n  ( D ) ---> Clase D.\n");
			seleccionClase = Character.toLowerCase(sc.next().charAt(0));
			if(seleccionClase=='a') {
				System.out.print("\nIndica cuántas horas trabajas: ");
				horas=sc.nextInt();
				sueldo=horas*claseA;
				System.out.println("\nOk, tu sueldo es de "+sueldo+"€");
			}
			else if(seleccionClase=='b') {
				System.out.print("\nIndica cuántas horas trabajas: ");
				horas=sc.nextInt();
				sueldo=horas*claseB;
				System.out.println("\nOk, tu sueldo es de "+sueldo+"€");
			}
			else if(seleccionClase=='c') {
				System.out.print("\nIndica cuántas horas trabajas: ");
				horas=sc.nextInt();
				sueldo=horas*claseC;
				System.out.println("\nOk, tu sueldo es de "+sueldo+"€");
			}
			else if(seleccionClase=='d') {
				System.out.print("\nIndica cuántas horas trabajas: ");
				horas=sc.nextInt();
				sueldo=horas*claseD;
				System.out.println("\nOk, tu sueldo es de "+sueldo+"€");
			}
			else System.out.println("\nError en la selección.");
			
			break;
		
		case 'c': // PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---PRECIO---
			
			// DECLARACIÓN DE VARIABLES
			
			char seleccionCupon, seleccionIva;
			final double IvaG=1.21, IvaR=1.1, IvaSR=1.04, nopro=1, descPorc_50=0.5, descPorc_5=0.95, desc5=5;
			double precioInicial=0, precioCupon=0, precioFinal=0;
			
			// PETICIÓN DE PRECIO 
			
			System.out.print("\nOk, dime cual es el precio inicial del producto  ");
			precioInicial = sc.nextDouble();
			
			// PETICIÓN DE INFORMACIÓN DE DESCUENTO 
			
			System.out.println("\n¿Tienes algún cupón de descuento? \n\n   ( A ) ---> No tengo ningún cupon."
																   + "\n   ( B ) ---> Tengo una rebaja de 5 euros."
																   + "\n   ( C ) ---> Tengo una rebaja del 50%"
																   + "\n   ( D ) ---> Tengo una rebaja del 5%  \n");
			
			seleccionCupon=Character.toLowerCase(sc.next().charAt(0));
						
						switch(seleccionCupon) { // CUPÓN
						
						case 'a':
							
							precioCupon = precioInicial*nopro;
							System.out.println("\nEl precio sin IVA sería de "+precioCupon+"€.\n");
							System.out.println("\n¿Qué tipo de IVA se aplica? \n\n   ( A ) ---> General."
									                                         + "\n   ( B ) ---> Reducido."
									                                         + "\n   ( C ) ---> Superreducido."
									                                         + "\n   ( D ) ---> Ninguno, pago en efectivo y este tío es un piratilla. \n");
							seleccionIva=Character.toLowerCase(sc.next().charAt(0));
							
										if(seleccionIva=='a') {
											precioFinal = precioCupon*IvaG;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
										}
										else if(seleccionIva=='b') {
											precioFinal = precioCupon*IvaR;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
											
										}
										else if(seleccionIva=='c') {
											precioFinal = precioCupon*IvaSR;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
																		
										}
										else if(seleccionIva=='d') {
											precioFinal = precioCupon;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
											
										}
										else System.out.println("\nError.");
							break;
							
						case 'b':
							
							precioCupon = precioInicial-desc5;
							System.out.println("\nEl precio sin IVA sería de "+precioCupon+"€.\n");
							System.out.println("\n¿Qué tipo de IVA se aplica? \n\n   ( A ) ---> General."
														                     + "\n   ( B ) ---> Reducido."
														                     + "\n   ( C ) ---> Superreducido."
														                     + "\n   ( D ) ---> Ninguno, pago en efectivo y este tío es un piratilla. \n");
							seleccionIva=Character.toLowerCase(sc.next().charAt(0));
							
										if(seleccionIva=='a') {
											precioFinal = precioCupon*IvaG;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
										}
										else if(seleccionIva=='b') {
											precioFinal = precioCupon*IvaR;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
											
										}
										else if(seleccionIva=='c') {
											precioFinal = precioCupon*IvaSR;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
																		
										}
										else if(seleccionIva=='d') {
											precioFinal = precioCupon;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
											
										}
										else System.out.println("\nError.");
							
							break;
							
						case 'c':
							
							precioCupon = precioInicial*descPorc_50;
							System.out.println("\nEl precio sin IVA sería de "+precioCupon+"€.\n");
							System.out.println("\n¿Qué tipo de IVA se aplica? \n\n   ( A ) ---> General."
														                     + "\n   ( B ) ---> Reducido."
														                     + "\n   ( C ) ---> Superreducido."
														                     + "\n   ( D ) ---> Ninguno, pago en efectivo y este tío es un piratilla. \n");
							seleccionIva=Character.toLowerCase(sc.next().charAt(0));
							
										if(seleccionIva=='a') {
											precioFinal = precioCupon*IvaG;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
										}
										else if(seleccionIva=='b') {
											precioFinal = precioCupon*IvaR;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
											
										}
										else if(seleccionIva=='c') {
											precioFinal = precioCupon*IvaSR;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
																		
										}
										else if(seleccionIva=='d') {
											precioFinal = precioCupon;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
											
										}
										else System.out.println("\nError.");
							
							break;	
							
						case 'd':
							
							precioCupon=precioInicial*descPorc_5;
							System.out.println("\nEl precio sin IVA sería de "+precioCupon+"€.\n");
							System.out.println("\n¿Qué tipo de IVA se aplica? \n\n   ( A ) ---> General."
														                     + "\n   ( B ) ---> Reducido."
														                     + "\n   ( C ) ---> Superreducido."
														                     + "\n   ( D ) ---> Ninguno, pago en efectivo y este tío es un piratilla. \n");
							seleccionIva=Character.toLowerCase(sc.next().charAt(0));
							
										if(seleccionIva=='a') {
											precioFinal = precioCupon*IvaG;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
										}
										else if(seleccionIva=='b') {
											precioFinal = precioCupon*IvaR;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
											
										}
										else if(seleccionIva=='c') {
											precioFinal = precioCupon*IvaSR;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
																		
										}
										else if(seleccionIva=='d') {
											precioFinal = precioCupon;
											System.out.println("\nEl precio final es de "+precioFinal+"€.");
											
										}
										else System.out.println("\nError.");
							break;
							
						default:System.out.println("Error.");
							break;

						}
			break;
		
		default:
			break;
		}

	}

}
