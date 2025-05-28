package box1;

import java.util.HashMap;
import java.util.Scanner;

public class LecturaEscrituraPrincipal {

	protected int mostrarMenu(Scanner sc) {
		
		String entrada;
		int opcion = 0;
		boolean esNumero = true;
		System.out.println("\nSelecciona una de las opciones:\n");
		System.out.println("1.- Agregar un producto al inventario.");
		System.out.println("2.- Buscar un producto.");
		System.out.println("3.- Actualizar el stock de un producto.");
		System.out.println("4.- Eliminar un producto del inventario.");
		System.out.println("5.- Mostrar todos los productos.");
		System.out.println("6.- Salir.\n");
		do {			
			entrada = sc.next();
			try {
				opcion = Integer.parseInt(entrada);
				esNumero = true;
				if(opcion <= 0 || opcion > 6) {
					System.out.print("Por favor, introduce un número del 1 al 6: ");
				}
			}catch(NumberFormatException e) {
				esNumero = false;
				System.out.print("Por favor, introduce un número del 1 al 6: ");
			}	
		}while(opcion <= 0 || opcion > 6 || !esNumero);
		return opcion;
		
	}
	
	// necesito este método igual que el que está en la clase Gestión pero que devuelva una lista. Para las demás tareas (eliminar, modificar stock...)
	
	protected Producto buscarUnProducto(HashMap<String, Producto> inventario, Scanner sc) {
		
	    System.out.print("\nIngrese un término de búsqueda (código, nombre o precio): ");
	    sc.nextLine(); // Consumir buffer si es necesario
	    String entrada = sc.nextLine().trim(); 
	    // Lista temporal para almacenar coincidencias
	    HashMap<String, Producto> resultados = filtrarProductos(entrada, inventario);
	    if (resultados.isEmpty()) { // si falla la primera tentativa no hemos perdido tiempo porque es la primera. Volvemos al menú principal
	        System.out.println("No se encontraron productos que coincidan con la búsqueda.");
	        return null;
	    }
	    while (resultados.size() > 1) { // Mientras haya más de un resultado
	        System.out.println("\nSe encontraron múltiples coincidencias:");
	        mostrarResultados(resultados);        
	        String nuevoFiltro;
	        HashMap<String, Producto> nuevosResultados = new HashMap<>();        	        
	        do { // lo suyo es que si no se consigue refinar con el nuevo filtro, demos un paso atrás sin perder la anterior lista
		        System.out.print("\nIngrese un nuevo término para refinar la búsqueda (o escriba 'S' para abortar): ");
		        nuevoFiltro = sc.nextLine().toUpperCase().trim();
		        
		        if (nuevoFiltro.equalsIgnoreCase("S")) {
		        	System.out.println("\nMostrando los productos sin más filtros:");
		        	return null;
		        }
	            // Aplicamos el nuevo filtro sobre los resultados actuales
	            nuevosResultados = filtrarProductos(nuevoFiltro, resultados);
	            if (nuevosResultados.isEmpty()) {
	                System.out.print("No se encontraron coincidencias con el nuevo filtro. Inténtalo de nuevo: ");
	            }
	        }while(nuevosResultados.isEmpty());	        
	        // Si el usuario decide no filtrar más, salimos también de este bucle
	        if (nuevoFiltro.equalsIgnoreCase("S")) {
	        	return null;
	        }
	        resultados = nuevosResultados;
	    }
	    
	    String codigoProducto = resultados.keySet().iterator().next(); // obtiene la primera clave (y única en este caso)
		Producto producto = resultados.get(codigoProducto);
	    if(producto != null) System.out.println("\nProducto encontrado:");
	    producto.toString();
	    return producto;
	    // este método devuelve solo una posición de la lista
	}
	
	protected String buscarKeyProducto(HashMap<String, Producto> inventario, Scanner sc) {
		
	    System.out.print("\nIngrese un término de búsqueda (código, nombre o precio): ");
	    sc.nextLine(); // Consumir buffer si es necesario
	    String entrada = sc.nextLine().trim(); 
	    // Lista temporal para almacenar coincidencias
	    HashMap<String, Producto> resultados = filtrarProductos(entrada, inventario);
	    if (resultados.isEmpty()) { // si falla la primera tentativa no hemos perdido tiempo porque es la primera. Volvemos al menú principal
	        System.out.println("No se encontraron productos que coincidan con la búsqueda.");
	        return null;
	    }
	    while (resultados.size() > 1) { // Mientras haya más de un resultado
	        System.out.println("\nSe encontraron múltiples coincidencias:");
	        mostrarResultados(resultados);        
	        String nuevoFiltro;
	        HashMap<String, Producto> nuevosResultados = new HashMap<>();        	        
	        do { // lo suyo es que si no se consigue refinar con el nuevo filtro, demos un paso atrás sin perder la anterior lista
		        System.out.print("\nIngrese un nuevo término para refinar la búsqueda (o escriba 'S' para abortar): ");
		        nuevoFiltro = sc.nextLine().toUpperCase().trim();
		        
		        if (nuevoFiltro.equalsIgnoreCase("S")) {
		        	System.out.println("\nMostrando los productos sin más filtros:");
		        	return null;
		        }
	            // Aplicamos el nuevo filtro sobre los resultados actuales
	            nuevosResultados = filtrarProductos(nuevoFiltro, resultados);
	            if (nuevosResultados.isEmpty()) {
	                System.out.print("No se encontraron coincidencias con el nuevo filtro. Inténtalo de nuevo: ");
	            }
	        }while(nuevosResultados.isEmpty());	        
	        // Si el usuario decide no filtrar más, salimos también de este bucle
	        if (nuevoFiltro.equalsIgnoreCase("S")) {
	        	return null;
	        }
	        resultados = nuevosResultados;
	    }
	    
	    String codigoProducto = resultados.keySet().iterator().next(); // obtiene la primera clave (y única en este caso)
		Producto producto = resultados.get(codigoProducto);
	    if(producto != null) {
	    	System.out.println("\nProducto encontrado:");
	    	System.out.println(producto);
	    }	    
	    return codigoProducto;
	    // este método devuelve solo una posición de la lista
	}
	
	protected HashMap<String, Producto> filtrarProductos(String entrada, HashMap<String, Producto> lista) {
		
	    HashMap<String, Producto> filtrados = new HashMap<>();
	    
	    double precioBuscado = -1;
	    try {
	        precioBuscado = Double.parseDouble(entrada.replace(",", "."));
	    } catch (NumberFormatException e) {}

	    for (String codigo : lista.keySet()) {
	    	
	        Producto producto = lista.get(codigo);

	        boolean coincideCodigo = codigo.equalsIgnoreCase(entrada);
	        boolean coincideNombre = producto.getNombre().toLowerCase().contains(entrada.toLowerCase());
	        boolean coincidePrecio = (precioBuscado != -1) && (producto.getPrecio() == precioBuscado);

	        if (coincideCodigo || coincideNombre || coincidePrecio) {
	            filtrados.put(codigo, producto);
	        }
	    }

	    return filtrados;
	}
	
	protected void mostrarResultados(HashMap<String, Producto> resultados) {
		
	    for (String codigo : resultados.keySet()) {
	        System.out.println("Código: " + codigo + " - " + resultados.get(codigo));
	    }
	}



	
	protected double leerDouble(String mensaje, Scanner sc) {
		
		double numero;
		boolean valido = false;
		System.out.print(mensaje);
		do {		
			try {
				numero = Double.parseDouble(sc.nextLine().replace(",", "."));
				valido = true;
				return numero;
			}catch(NumberFormatException e) {
				System.out.print("Error. Introduce un número válido: ");
			}
		}while(!valido);
		return 0; // nunca llegará aquí
		
	}
	
	protected int leerInt(String mensaje, Scanner sc) {
		
		int numero;
		boolean valido = false;
		System.out.print(mensaje);
		do {
			try {
				numero = Integer.parseInt(sc.nextLine());
				valido = true;
				return numero;
			}catch(NumberFormatException e) {
				System.out.print("Error. Introduce un número válido: ");
			}
		}while(!valido);
		return 0; // nunca llegará aquí
		
	}
	
	protected int leerInt(String mensaje, Scanner sc, int min, int max) {
		
	    int numero;
	    boolean valido = false;
	    System.out.print(mensaje);
	    do {        
	        try {
	            numero = Integer.parseInt(sc.nextLine());
	            if (numero >= min && numero <= max) {
	                valido = true;
	                return numero;
	            } else {
	                System.out.println("Error: El número debe estar entre " + min + " y " + max + ".");
	                System.out.print("Inténtalo de nuevo: ");
	            }
	        } catch (NumberFormatException e) {
	            System.out.print("Error: Introduce un número entero válido: ");
	        }
	    } while (!valido);
	    return 0; // Nunca llegará aquí
	}
	
	/*do {
		try {
			stock = Integer.parseInt(sc.nextLine());
			check = true;
		}catch(NumberFormatException e) {
			System.out.print("Por favor, introduce un número válido: ");
			check = false;
		}	
	}while(!check);	*/
	
	
	/*System.out.print("Ingrese el precio del producto: ");
	do {
		try {
			precio = Double.parseDouble(sc.nextLine().replace(",","."));
			check = true;
		}catch(NumberFormatException e) {
			System.out.print("Por favor, introduce un precio válido: ");
			check = false;
		}	
	}while(!check);*/

}
