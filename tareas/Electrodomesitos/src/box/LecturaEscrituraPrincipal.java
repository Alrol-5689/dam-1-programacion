package box;

import java.util.Scanner;

public class LecturaEscrituraPrincipal {
	
	Scanner sc = new Scanner(System.in);

	protected int menuPrincipal() { 
	    int opcion = -1; // Valor inicial para manejar errores
	    boolean entradaValida = false;
	    
	    while (!entradaValida) {
	    	System.out.println("\nMenú principal:\n");
			System.out.println("1.- Dar de alta un electrodoméstico.");
			System.out.println("2.- Eliminar un electrodoméstico.");
			System.out.println("3.- Mostrar precio de un electrodoméstico.");
			System.out.println("4.- Salir.");	
	        System.out.print("\nSelecciona una opción: ");

	        String entrada = sc.nextLine(); //  Leer como String primero
	        
	        try {
	            opcion = Integer.parseInt(entrada); //  Intentar convertir a número
	            if (opcion >= 1 && opcion <= 4) { 
	                entradaValida = true; //  La entrada es válida si está en el rango 1-4
	            } else {
	                System.out.println("\n⚠ Opción fuera de rango. Inténtalo de nuevo.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("\n❌ Error: Debes introducir un número válido.");
	        }
	    }
	    return opcion; // 🔹 Retorna el número validado
	}
	
	protected int menuAlta() { 
	    int opcion = -1; // Valor inicial para manejar errores
	    boolean entradaValida = false;
	    
	    while (!entradaValida) {
	    	System.out.println("\nDar de alta un electrodoméstico:\n");
			System.out.println("1.- Una lavadora.");
			System.out.println("2.- Un televisor.");
			System.out.println("3.- Volver.");
			System.out.println("4.- Salir.");	
	        System.out.print("\nSelecciona una opción: ");

	        String entrada = sc.nextLine(); //  Leer como String primero
	        try {
	            opcion = Integer.parseInt(entrada); //  Intentar convertir a número
	            if (opcion >= 1 && opcion <= 4) { 
	                entradaValida = true; //  La entrada es válida si está en el rango 1-4
	            } else {
	                System.out.println("\n⚠ Opción fuera de rango. Inténtalo de nuevo.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("\n❌ Error: Debes introducir un número válido.");
	        }
	    }
	    return opcion; // 🔹 Retorna el número validado
	}
	
	protected int menuEliminar() { 
	    int opcion = -1; // Valor inicial para manejar errores
	    boolean entradaValida = false;
	    
	    while (!entradaValida) {
	    	System.out.println("\nEliminar un electrodoméstico:\n");
			System.out.println("1.- Una lavadora.");
			System.out.println("2.- Un televisor.");
			System.out.println("3.- Volver.");
			System.out.println("4.- Salir.");	
	        System.out.print("\nSelecciona una opción: ");

	        String entrada = sc.nextLine(); //  Leer como String primero
	        
	        try {
	            opcion = Integer.parseInt(entrada); //  Intentar convertir a número
	            if (opcion >= 1 && opcion <= 4) { 
	                entradaValida = true; //  La entrada es válida si está en el rango 1-4
	            } else {
	                System.out.println("\n⚠ Opción fuera de rango. Inténtalo de nuevo.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("\n❌ Error: Debes introducir un número válido.");
	        }
	    }
	    return opcion; // 🔹 Retorna el número validado
	}
	
	protected int menuMostrarPrecio() { 
	    int opcion = -1; // Valor inicial para manejar errores
	    boolean entradaValida = false;
	    
	    while (!entradaValida) {
	    	System.out.println("\nMostrar precio de un electrodoméstico:\n");
			System.out.println("1.- De una lavadora.");
			System.out.println("2.- De un televisor.");
			System.out.println("3.- Volver.");
			System.out.println("4.- Salir.");	
	        System.out.print("\nSelecciona una opción: ");

	        String entrada = sc.nextLine(); //  Leer como String primero
	        
	        try {
	            opcion = Integer.parseInt(entrada); //  Intentar convertir a número
	            if (opcion >= 1 && opcion <= 4) { 
	                entradaValida = true; //  La entrada es válida si está en el rango 1-4
	            } else {
	                System.out.println("\n⚠ Opción fuera de rango. Inténtalo de nuevo.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("\n❌ Error: Debes introducir un número válido.");
	        }
	    }
	    return opcion; // 🔹 Retorna el número validado
	}

}
