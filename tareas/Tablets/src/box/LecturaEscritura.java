package box;

import java.util.ArrayList;
import java.util.Scanner;

public class LecturaEscritura {
	
	// ATRIBUTOS
	
	protected Scanner sc = new Scanner(System.in);
	
	// MÉTODOS
	
	protected int mPrincipal() { 
	    int opcion = -1; // Valor inicial para manejar errores
	    boolean entradaValida = false;
	    
	    while (!entradaValida) {
	        System.out.println("\nElige de entre las siguientes opciones:\n");
	        System.out.println("1.- Editar tock.");
	        System.out.println("2.- Editar BDD clientes.");
	        System.out.println("3.- Consultar stock y tablets vendidas.");
	        System.out.println("4.- Consultar cliente/s.");
	        System.out.println("5.- Compras y reservas.");
	        System.out.println("6.- Salir\n");		
	        System.out.print("Selecciona una opción: ");

	        String entrada = sc.nextLine(); // 🔹 Leer como String primero
	        
	        try {
	            opcion = Integer.parseInt(entrada); // 🔹 Intentar convertir a número
	            if (opcion >= 1 && opcion <= 6) { 
	                entradaValida = true; // 🔹 La entrada es válida si está en el rango 1-6
	            } else {
	                System.out.println("\n⚠ Opción fuera de rango. Inténtalo de nuevo.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("\n❌ Error: Debes introducir un número válido.");
	        }
	    }
	    return opcion; // 🔹 Retorna el número validado
	}
	
	protected int mEditarStock() { 
	    int opcion = -1; // Valor inicial para manejar errores
	    boolean entradaValida = false;
	    
	    while (!entradaValida) {
	        System.out.println("\nElige de entre las siguientes opciones:\n");
	        System.out.println("Editar tock ---> 1.- Añadir una o varias tablets.");
	        System.out.println("Editar tock ---> 2.- Modificar una tablet."); // si da tiempo añadir la opción de modificar un atributo de un grupo de tablets
	        System.out.println("Editar tock ---> 3.- Eliminar una tablet."); // si da tiempo añadir la opción de eliminar un grupo de tablets de una
	        System.out.println("Editar tock ---> 4.- Regresar al menú anterior.");	
	        System.out.println("Editar tock ---> 5.- Salir\n");
	        System.out.print("Selecciona una opción: ");

	        String entrada = sc.nextLine(); // Leer como String primero
	        
	        try {
	            opcion = Integer.parseInt(entrada); // 🔹 Intentar convertir a número
	            if (opcion >= 1 && opcion <= 5) { 
	                entradaValida = true; // La entrada es válida si está en el rango 1-6
	            } else {
	                System.out.println("\n⚠ Opción fuera de rango. Inténtalo de nuevo.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("\n❌ Error: Debes introducir un número válido.");
	        }
	    }
	    return opcion; // 🔹 Retorna el número validado
	}
	
	protected int mEditarBDDClientes() { 
	    int opcion = -1; // Valor inicial para manejar errores
	    boolean entradaValida = false;
	    
	    while (!entradaValida) {
	        System.out.println("\nElige de entre las siguientes opciones:\n");
	        System.out.println("Editar BDD clientes ---> 1.- Añadir un nuevo cliente.");
	        System.out.println("Editar BDD clientes ---> 2.- Modificar una cliente."); 
	        System.out.println("Editar BDD clientes ---> 3.- Eliminar una cliente."); 
	        System.out.println("Editar BDD clientes ---> 4.- Desacticar cuenta de un cliente.");
	        System.out.println("Editar BDD clientes ---> 5.- Regresar al menú anterior.");	
	        System.out.println("Editar BDD clientes ---> 6.- Salir\n");
	        System.out.print("Selecciona una opción: ");

	        String entrada = sc.nextLine(); // Leer como String primero
	        
	        try {
	            opcion = Integer.parseInt(entrada); // 🔹 Intentar convertir a número
	            if (opcion >= 1 && opcion <= 6) { 
	                entradaValida = true; // La entrada es válida si está en el rango 1-6
	            } else {
	                System.out.println("\n⚠ Opción fuera de rango. Inténtalo de nuevo.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("\n❌ Error: Debes introducir un número válido.");
	        }
	    }
	    return opcion; // 🔹 Retorna el número validado
	}
	
	protected int mConsultarStock() { 
	    int opcion = -1; // Valor inicial para manejar errores
	    boolean entradaValida = false;
	    
	    while (!entradaValida) {
	        System.out.println("\nElige de entre las siguientes opciones:\n");
	        System.out.println("Consultar stock y tablets vendidas ---> 1.- Ver tablts disponibles.");
	        System.out.println("Consultar stock y tablets vendidas ---> 2.- Ver tablets reservadas."); 
	        System.out.println("Consultar stock y tablets vendidas ---> 3.- Ver tablets vendidas."); 
	        System.out.println("Consultar stock y tablets vendidas ---> 4.- Ver todas las tablets.");
	        System.out.println("Consultar stock y tablets vendidas ---> 5.- Regresar al menú anterior.");	
	        System.out.println("Consultar stock y tablets vendidas ---> 6.- Salir\n");
	        System.out.print("Selecciona una opción: ");

	        String entrada = sc.nextLine(); // Leer como String primero
	        
	        try {
	            opcion = Integer.parseInt(entrada); // 🔹 Intentar convertir a número
	            if (opcion >= 1 && opcion <= 6) { 
	                entradaValida = true; // La entrada es válida si está en el rango 1-6
	            } else {
	                System.out.println("\n⚠ Opción fuera de rango. Inténtalo de nuevo.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("\n❌ Error: Debes introducir un número válido.");
	        }
	    }
	    return opcion; // 🔹 Retorna el número validado
	}
	
	/*protected int mConsultarClientes() { 
	    int opcion = -1; // Valor inicial para manejar errores
	    boolean entradaValida = false;
	    
	    while (!entradaValida) {
	        System.out.println("\nElige de entre las siguientes opciones:\n");
	        System.out.println("1.- Consultar cliente/s ---> .");
	        System.out.println("2.- Consultar cliente/s ---> ."); 
	        System.out.println("3.- Consultar cliente/s ---> ."); 
	        System.out.println("4.- Consultar cliente/s ---> .\n");
	        System.out.println("5.- Regresar al menú anterior.");	
	        System.out.println("6.- Salir\n");
	        System.out.print("Selecciona una opción: ");

	        String entrada = sc.nextLine(); // Leer como String primero
	        
	        try {
	            opcion = Integer.parseInt(entrada); // 🔹 Intentar convertir a número
	            if (opcion >= 1 && opcion <= 6) { 
	                entradaValida = true; // La entrada es válida si está en el rango 1-6
	            } else {
	                System.out.println("\n⚠ Opción fuera de rango. Inténtalo de nuevo.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("\n❌ Error: Debes introducir un número válido.");
	        }
	    }
	    return opcion; // 🔹 Retorna el número validado
	}*/
	
	protected int mComprasYReservas() { 
	    int opcion = -1; // Valor inicial para manejar errores
	    boolean entradaValida = false;
	    
	    while (!entradaValida) {
	        System.out.println("\nElige de entre las siguientes opciones:\n");
	        System.out.println("Compras y reservas ---> 1.- Vender tablet.");
	        System.out.println("Compras y reservas ---> 2.- Devolver tablet."); 
	        System.out.println("Compras y reservas ---> 3.- Reservar tablet."); 
	        System.out.println("Compras y reservas ---> 4.- Cancelar reserva.");
	        System.out.println("Compras y reservas ---> 5.- Regresar al menú anterior.");	
	        System.out.println("Compras y reservas ---> 6.- Salir\n");
	        System.out.print("Selecciona una opción: ");

	        String entrada = sc.nextLine(); // Leer como String primero
	        
	        try {
	            opcion = Integer.parseInt(entrada); // 🔹 Intentar convertir a número
	            if (opcion >= 1 && opcion <= 6) { 
	                entradaValida = true; // La entrada es válida si está en el rango 1-6
	            } else {
	                System.out.println("\n⚠ Opción fuera de rango. Inténtalo de nuevo.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("\n❌ Error: Debes introducir un número válido.");
	        }
	    }
	    return opcion; // 🔹 Retorna el número validado
	}
	
	protected boolean dniValido(String dni) {
		return dni.matches("\\d{8}[A-Za-z]");
	}
	
	protected boolean dniUnico(ArrayList<Cliente> lista, String dni) {
		for(Cliente a: lista) {
			if(a.getDni().equalsIgnoreCase(dni)) {
				return false;
			}
		}
		return true;
	}
	
	/*protected ArrayList<Cliente> filtrarPorNombre(ArrayList<Cliente> array, String nombre){
		ArrayList<Cliente> clientesEncontrados = new ArrayList<>();
		for(Cliente a : array) {
			if(a.getNombre().equalsIgnoreCase(nombre)) {
				clientesEncontrados.add(a);
			}			
		}
		return clientesEncontrados;
	}*/
	

	

	


	


	

	
	


}
