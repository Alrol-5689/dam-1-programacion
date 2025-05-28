package box1;

import java.util.HashMap;
import java.util.Scanner;

public class GestionPrincipal {
	
	protected LecturaEscrituraPrincipal le = new LecturaEscrituraPrincipal();
	protected HashMap<String, Producto> inventario = new HashMap<>();
	protected Scanner sc = new Scanner(System.in);
	protected int opcion;
	protected static int contador = 1; // para generar automaticamente la clave de cada producto del HashMap
	
	
	protected void menuBucle() {
		do {
			opcion = le.mostrarMenu(sc);
			switch(opcion) {
				case 1: agregarProductoNuevo();
					break;
				case 2: buscarProducto();
					break;
				case 3: actualizarStock();
					break;
				case 4: eliminarProducto();
					break;
				case 5: mostrarTodosLosProductos();
					break;
				default:
			}
		}while(opcion != 6);
	}
	
	protected void mostrarTodosLosProductos() {
		
		if(inventario.isEmpty()) {
			System.out.println("\nEl inventario está vacío.");
			return;
		}
		System.out.println("\nInventario al completo: \n");
		for(String codigo : inventario.keySet()) {
			Producto p = inventario.get(codigo);
			System.out.println(p.toString());
		}
	}
	
	protected void eliminarProducto() {
		
		String key = le.buscarKeyProducto(inventario, sc);
		
		if(key == null) {
			System.out.println("\nOperación camncelada.");
			return;
		}
		
		System.out.print("\nIntroduce 'E' para eliminar definitivamente este producto del inventario o cualquier otra letra para abortar: ");
		
		if(sc.nextLine().equalsIgnoreCase("e")) {
			inventario.remove(key);
			System.out.println("\nProducto eliminado con éxito.");
		}else {
			System.out.println("\nOpercación cancelada.");
		}
		
	}
	
	protected void actualizarStock() {
		
		Producto producto = le.buscarUnProducto(inventario, sc);
		
		System.out.println("\nStock actual: "+producto.getStock()+"\n");
		
		System.out.print("\nIntroduce el nuevo stock: ");
		
		boolean introducido = false;
		
		do {
			try {
				producto.setStock(Integer.parseInt(sc.nextLine()));
				introducido = true;
			}catch(NumberFormatException e) {
				System.out.print("\nPor favor, introduce un número válido para stock: ");
			}
		}while(!introducido);		
		
		System.out.println("\nStock actualizado correctamente.");
		System.out.println(producto.toString());
		
	}
	
	protected void buscarProducto() {
		
	    System.out.print("\nIngrese un término de búsqueda (código, nombre o precio): ");
	    sc.nextLine(); // Consumir buffer si es necesario
	    String entrada = sc.nextLine().trim(); 
	    // Lista temporal para almacenar coincidencias
	    HashMap<String, Producto> resultados = le.filtrarProductos(entrada, inventario);
	    if (resultados.isEmpty()) { // si falla la primera tentativa no hemos perdido tiempo porque es la primera. Volvemos al menú principal
	        System.out.println("No se encontraron productos que coincidan con la búsqueda.");
	        return;
	    }
	    while (resultados.size() > 1) { // Mientras haya más de un resultado
	        System.out.println("\nSe encontraron múltiples coincidencias:");
	        le.mostrarResultados(resultados);        
	        String nuevoFiltro;
	        HashMap<String, Producto> nuevosResultados = new HashMap<>();        	        
	        do { // lo suyo es que si no se consigue refinar con el nuevo filtro, demos un paso atrás sin perder la anterior lista
		        System.out.print("\nIngrese un nuevo término para refinar la búsqueda (o escriba 'S' si no quieres refinarla más): ");
		        nuevoFiltro = sc.nextLine().toUpperCase().trim();
		        
		        if (nuevoFiltro.equalsIgnoreCase("S")) {
		        	System.out.println("\nMostrando los productos sin más filtros:");
		            break;
		        }
	            // Aplicamos el nuevo filtro sobre los resultados actuales
	            nuevosResultados = le.filtrarProductos(nuevoFiltro, resultados);
	            if (nuevosResultados.isEmpty()) {
	                System.out.print("No se encontraron coincidencias con el nuevo filtro. Inténtalo de nuevo: ");
	            }
	        }while(nuevosResultados.isEmpty());	        
	        // Si el usuario decide no filtrar más, salimos también de este bucle
	        if (nuevoFiltro.equalsIgnoreCase("S")) {
	            break;
	        }
	        resultados = nuevosResultados;
	    }
	    System.out.println(resultados.size() > 1 ? "\nProductos encontrados:" : "\nProducto encontrado:");
	    le.mostrarResultados(resultados);
	    // este método o un sucedáneo del mismo nos vendrá bien para filtrar antes de eliminar productos
	}

	
	protected void agregarProductoNuevo() {
		
		int entrada;
		
		do {
			sc.nextLine(); // limpiamos buffer
			// Pedimos los datos del producto
			System.out.print("\nIngrese el nombre del producto: ");
			String nombre = sc.nextLine();					
			double precio = le.leerDouble("Ingrese el precio del producto: ", sc); // comprueba que se ingrese correctamente			
			int stock = le.leerInt("Ingrese la cantidad de stock: ", sc); // comprueba que se ingrese correctamente
			// Confirmamos que estén ingresados correctamente
			System.out.println("\nNombre: "+nombre+". Precio: "+precio+". Stock: "+stock+"\n"
					+"1.- Los datos son correctos. Introducir los productos en el sistema.\n"
					+"2.- Introducir los campos de nuevo.\n"
					+"3.- Cancelar.");			
			entrada = le.leerInt("\nSeleccione una opción: ", sc, 1, 3); // comprueba que se ingrese correctamente
			// Añadimos los productos, los volvemos a introducir o salimos del método
			if(entrada == 1) {
				String codigo = String.format("p%03d", contador);
				contador++;
				inventario.put(codigo, new Producto(nombre, precio, stock));
				System.out.println("Producto añadido con éxito con código "+codigo);
			}else if(entrada == 2) {
				System.out.println("Ok. Introduzcamos los datos de nuevo: \n");
			}else {
				System.out.println("Ok. Abortamos.");
				return;
			}	
			
		}while(entrada == 2);
		
	}
	
}
