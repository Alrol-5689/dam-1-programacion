package box;

import java.util.ArrayList;
import java.util.Scanner;

public class GeCliente {
	
	// ATRIBUTOS
	
	protected Scanner sc = new Scanner(System.in);
	
	// MÉTODOS
	
	protected void nuevoCliente(LecturaEscritura le, LeCliente leCli, ArrayList<Cliente> arrayClientes) {
		
		Cliente nuevo = new Cliente();
		boolean camposCorrectos = false;
		
		System.out.println("\nVamos a añadir un nuevo cliente en el sistema. Completa los campos: ");

		while(!camposCorrectos) {
			System.out.print("\nNombre: ");  
			nuevo.setNombre(sc.next());
			System.out.print("Premer apellido: ");  
			nuevo.setApellido_1(sc.next());
			System.out.print("Segundo apellido: ");  
			nuevo.setApellido_2(sc.next());  
			System.out.print("Teléfono: ");  
			nuevo.setTelefono(sc.nextInt());         
			sc.nextLine(); /* limpiar buffer*/
			String dni;
			do {
				System.out.print("DNI: ");
				dni = sc.next();
				if(le.dniValido(dni)) {
					if(le.dniUnico(arrayClientes, dni)) {
						nuevo.setDni(dni);
					}else System.out.print("Este dni ya pertenece a un cliente. Inténtalo de nuevo. ");				
				}else System.out.print("Formato incorrecto. Introduce 8 carácteres numéricos y una letra al final. ");			
			}while(!le.dniValido(dni) || !le.dniUnico(arrayClientes, dni));	
			System.out.println("\nResumen: Nombre y apellidos: "+nuevo.getNombre()+" "+nuevo.getApellido_1()+" "+nuevo.getApellido_2()
					+" | tlf: "+nuevo.getTelefono()+" | DNI: "+nuevo.getDni()
					+"\n\n¿Están todos los campos correctos?\n"
					+"\n  Sí --->  (Introduce: S)"
					+"\n  No, introducirlos campos de nuevo. --->  (N)"
					+"\n  Volever al menú anterior ---> (V)");
			sc.nextLine(); //limpiar buffer
			String entrada = sc.nextLine();
			if(entrada.equalsIgnoreCase("S")) {
				camposCorrectos = true;

			}else if(entrada.equalsIgnoreCase("N")) {
				System.out.println("\nOk, vamos a introducir los campos de nuevo:");
			}else if(entrada.equalsIgnoreCase("V")) {
				System.out.println("\nOperación cancelada. Cliente NO añadido.\n");
				return;			
			}
		}
		Cliente nuevoCliente = new Cliente(nuevo.getDni(), nuevo.getNombre(), nuevo.getApellido_1(), nuevo.getApellido_2(), nuevo.getTelefono());
		arrayClientes.add(nuevoCliente);
		System.out.println("\nCliente añadido en el sistema correctamente. \n\n"+nuevoCliente.toString()+"\n");
	
	}
	
	protected Cliente encontrarCliente_queReserva(LeCliente leCli, ArrayList<Cliente> arrayClientes) {
		
		Cliente clienteRes;
	    while(true) {
			System.out.print("\nIntroduce el dato con el que realizar la búsqueda del cliente que realizará la reserva: ");		
			clienteRes = encontrarCliente(leCli, arrayClientes, sc.nextLine());	
			if(clienteRes != null) break; // salimos del while cuanto tenemos al cliente
			System.out.print("\n¿Quieres intentarlo de nuevo? ( S / N ): ");
	        if (!sc.nextLine().equalsIgnoreCase("S")) { // abortamos cuando no se inserta "s"
	            System.out.println("\nReserva cancelada.");
	            return null; // Salimos del método
	        }	
	    }
		if(!clienteRes.isActivado()) {
			System.out.println(clienteRes.getNombre()+" "+clienteRes.getApellido_1()+" [ id: "+clienteRes.getIdCliente()+" ] "
					+"no está activado. ¿Quieres activarlo? \n\n   Sí ---> (S)\n   No, salir del proceso de reserva ---> (N)\n");
			String opcion = sc.next();
			if(opcion.equalsIgnoreCase("s")) {
				clienteRes.setActivado(true);
				System.out.println("Cuenta activada.");
			}else {
				System.out.println("La cuenta permanecerá desactivada. Abortamos el proceso de reserva.");
				return null;
			}
		}
		System.out.println("\nVa a realizar la reserva ---> "+clienteRes.toString());
		return clienteRes;
	}
	
	protected void desactivarCliente(LeCliente leCli, ArrayList<Cliente> arrayClientes) {
		
		Cliente clienteADesactivar;
		
		while(true) {
			System.out.print("\nIntroduce el dato con el que realizar la búsqueda del cliente que quieres desactivar: ");		
			clienteADesactivar = encontrarCliente(leCli, arrayClientes, sc.nextLine()); // devuelve un cliente
			if(clienteADesactivar != null) break;	   
			System.out.print("\n¿Quieres intentarlo de nuevo? ( S / N ): ");
	        if (!sc.nextLine().equalsIgnoreCase("S")) {
	            System.out.println("\nBusqueda cancelada.");
	            return;
	        }
		}
		System.out.println("\n ---> "+clienteADesactivar.toString());
		System.out.print("\n¿Es correcto el cliente a eliminar? ( S / N )");
		if(!sc.nextLine().equalsIgnoreCase("S")) {
			System.out.println("\nAbortamos\n");
			return;
		}
		clienteADesactivar.setActivado(false);
		System.out.println("\nCliente desactivado. No podrá hacer compras ni reservas hasta que se active la cuenta.\n");
	}
	
	protected void eliminarCliente(LeCliente leCli, ArrayList<Cliente> arrayClientes, ArrayList<Reserva> arrayReservas) {
		
		Cliente clienteAEliminar;

		while(true) {
			System.out.print("\nIntroduce el dato con el que realizar la búsqueda del cliente que quieres eliminar: ");		
			clienteAEliminar = encontrarCliente(leCli, arrayClientes, sc.nextLine()); // devuelve un cliente
			if(clienteAEliminar != null) break;	   
			System.out.print("\n¿Quieres intentarlo de nuevo? ( S / N ): ");
	        if (!sc.nextLine().equalsIgnoreCase("S")) {
	            System.out.println("\nBusqueda cancelada.");
	            return;
	        }
		}
		System.out.println("\n ---> "+clienteAEliminar.toString());
		System.out.print("\n¿Es correcto el cliente a eliminar? ( S / N )");
		if(!sc.nextLine().equalsIgnoreCase("S")) {
			System.out.println("\nAbortamos\n");
			return;
		}
		ArrayList<Reserva> reservasClienteAEiminar = new ArrayList<>();
		
		for(Reserva e : arrayReservas) {
			if(e.getCliente()==clienteAEliminar) {
				reservasClienteAEiminar.add(e);
			}
		}
		if(reservasClienteAEiminar.size() > 0) {
			System.out.println("\nSe cancelaron las siguientes reservas:\n");
			for(Reserva e : reservasClienteAEiminar) {
				e.tablet.setDisponible(true);
				System.out.println(e.toString());
				arrayReservas.remove(e);
			}
		}
		System.out.println("\nHa sido eliminado ---> "+clienteAEliminar.toString());
		arrayClientes.remove(clienteAEliminar);
		
	}
	
	protected void modificarCliente(LecturaEscritura le, LeCliente leCli, ArrayList<Cliente> arrayClientes) {
		
		Cliente clienteAModificar;
		while(true) {
			System.out.print("\nIntroduce el dato con el que realizar la búsqueda del cliente que quieres modificar: ");		
			clienteAModificar = encontrarCliente(leCli, arrayClientes, sc.nextLine()); // devuelve un cliente
			if(clienteAModificar != null) break;	   
			System.out.print("\n¿Quieres intentarlo de nuevo? ( S / N ): ");
	        if (!sc.nextLine().equalsIgnoreCase("S")) {
	            System.out.println("\nBusqueda cancelada.");
	            return;
	        }
		}
		System.out.println("\n ---> "+clienteAModificar.toString());
		System.out.print("\n¿Es correcto el cliente a modificar? ( S / N )");
		if(!sc.nextLine().equalsIgnoreCase("S")) {
			System.out.println("\nAbortamos\n");
			return;
		}
		
		Integer telefono = null;
		String dni;
		String entradaCambio;
		boolean cambio = false;
		String activadoDesactivado = "";
		
		System.out.println("\nIntroduce los nuevos datos o deja en blanco para mantenerlos.\n");
		while(true) {
			System.out.print("Nuevo DNI: ");
			dni = sc.nextLine();
			if((le.dniValido(dni) && le.dniUnico(arrayClientes, dni) && !dni.isBlank()) || dni.isBlank()) {
				break;			 
			}
			System.out.println(dni.isBlank() ? "" : (!le.dniValido(dni) ? "\nDNI incorrecto.\n" : "\nEste DNI ya pertenece a un cliente.\n"));
		}	
		System.out.print("Nuevo nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Nuevo primer apellido: ");
		String apellido_1 = sc.nextLine();
		System.out.print("Nuevo segundo apellido: ");
		String apellido_2 = sc.nextLine();
		while(true) {
			System.out.print("Nuevo teléfono: ");
			String tlf = sc.nextLine();	
			if(tlf.isBlank()) break;
			try {
				telefono = Integer.parseInt(tlf);
				break;
			}catch(NumberFormatException e) {
				System.out.println("\nError. Debes introducir un teléfono válido.\n");
			}
		}
		do {
			System.out.print((clienteAModificar.isActivado() ? "¿Desactivamos la cuenta? ( S / N ): " : "¿Activamos la cuenta? ( S / N ): "));
			entradaCambio = sc.nextLine();
			if(entradaCambio.equalsIgnoreCase("S")) {
				cambio = true;
			}else if(!entradaCambio.equalsIgnoreCase("N")) System.out.println("\nIntroduce una opción correcta.\n");
		}while(!entradaCambio.equalsIgnoreCase("S") && !entradaCambio.equalsIgnoreCase("N"));
		
		if(clienteAModificar.isActivado() && cambio) activadoDesactivado = "Desactivada";
		if(!clienteAModificar.isActivado() && cambio) activadoDesactivado = "Activada";
		
		
		System.out.println("\nResumen de cambios:\n");
		System.out.println("DNI: "+(dni.isBlank() ? "[SIN CAMBIOS]" : dni));
		System.out.println("Nombre: "+(nombre.isBlank() ? "[SIN CAMBIOS]" : nombre));
		System.out.println("Primer apellido: "+(apellido_1.isBlank() ? "[SIN CAMBIOS]" : apellido_1));
		System.out.println("Segundo apellido: "+(apellido_2.isBlank() ? "[SIN CAMBIOS]" : apellido_2));
		System.out.println("Teléfono: "+(telefono == null ? "[SIN CAMBIOS]" : telefono));
		System.out.println("Estado de la cuenta: "+(!cambio ? "[SIN CAMBIOS]" : activadoDesactivado));
		String confirmacion = "";
		do {
			System.out.print("\n¿El resumen de cambios es correcto? ( S / N ) ");
			confirmacion = sc.nextLine();
			if(confirmacion.equalsIgnoreCase("N")) {
				System.out.println("\nAbortamos el proceso.");
				return;
			}else if(!confirmacion.equalsIgnoreCase("S")) System.out.println("\nIntroduce una opción correcta.");
		}while(!confirmacion.equalsIgnoreCase("S") && !confirmacion.equalsIgnoreCase("N"));
		
		if(!dni.isBlank()) clienteAModificar.setDni(dni);
		if(!nombre.isBlank()) clienteAModificar.setNombre(nombre);
		if(!apellido_1.isBlank()) clienteAModificar.setApellido_1(apellido_1);
		if(!apellido_2.isBlank()) clienteAModificar.setApellido_2(apellido_2);
		if(telefono != null) clienteAModificar.setTelefono(telefono);
		if(cambio && clienteAModificar.isActivado()) clienteAModificar.setActivado(false);
		if(cambio && !clienteAModificar.isActivado()) clienteAModificar.setActivado(true);

		System.out.println("\nCambios realizados correctamente.");
	
	}
	protected void consultarCliente(LeCliente leCli, ArrayList<Cliente> arrayClientes,
			ArrayList<Compra> arrayCompras, ArrayList<Reserva> arrayReservas) {
		
		Cliente clienAConsultar;
	    while(true) {
			System.out.print("\nIntroduce el dato con el que realizar la búsqueda del cliente que quieres consultar: ");		
			clienAConsultar = encontrarCliente(leCli, arrayClientes, sc.nextLine()); // devuelve un cliente
			if(clienAConsultar != null) break;	   
			System.out.print("\n¿Quieres intentarlo de nuevo? ( S / N ): ");
	        if (!sc.nextLine().equalsIgnoreCase("S")) {
	            System.out.println("\nBusqueda cancelada.");
	            return;
	        }	
	    } // si no se ha cancelado la búsqueda tneemos al cliente y lo mostramos
		System.out.println("\n ---> "+clienAConsultar.toString());
		// comprobando que tenga compras y si tiene las imprimimos
		boolean tieneCompras = false;
		for(Compra c : arrayCompras) {
			if(c.getCliente().equals(clienAConsultar)) {
				tieneCompras = true;
				break;
			}
		}
		System.out.println(tieneCompras ? "\nCompras realizadas:\n" : "\nEl cliente no ha realizado ninguna compra por el momento.\n");
		if(tieneCompras) {
			for(Compra c : arrayCompras) {
				if(c.getCliente().equals(clienAConsultar)) System.out.println(c.toString());			
			}
		}
		// comprobamos que tenga reservas y si las tiene las imprimimos
		boolean tieneReservas = false;
		for(Reserva v : arrayReservas) {
			if(v.getCliente().equals(clienAConsultar)) {
				tieneReservas = true;
				break;
			}
		}
		System.out.println(tieneReservas ? "\nReservas activas:\n" : "\nEl cliente no tiene ninguna tablet reservada:\n");
		if(tieneReservas) {
			for(Reserva r : arrayReservas) {
				if(r.getCliente()==clienAConsultar) System.out.println(r.toString());
			}
		}
	}
	
	protected Cliente encontrarCliente(LeCliente leCli, ArrayList<Cliente> array, String entrada) {
		// Realizamos el primer filtrado con leCli aprovechando la entrada que nos han pasado.
		ArrayList<Cliente> clientesFiltrados = leCli.filtrarClientes(array, entrada); 
	    // seguimos filtrando entrando en un bucle hasta que el refinado deje solo a un cliente
	    while (clientesFiltrados.size() > 1) {
	    	
	    	System.out.println("\nSe encontraron varios clientes:\n");
	    	for (Cliente c : clientesFiltrados) {
	    		System.out.println(c.toString());
	    	}    
	                
	        System.out.print("\nIntroduce otro dato para filtrar la búsqueda (o escribe \"S\" para salir): ");
	        String nuevoFiltro = sc.nextLine();
	        
	        if(nuevoFiltro.equalsIgnoreCase("s")) return null;
	        
	        clientesFiltrados = leCli.filtrarClientes(clientesFiltrados, nuevoFiltro);

	        if (clientesFiltrados.isEmpty()) {
	            System.out.println("\nNo hay coincidencias con este filtro..");
	            return null; // No volvemos a mostrar la lista de clientes
	        }
	    }	    
	    if(clientesFiltrados.isEmpty()) {
	    	System.out.println("\nAún no hay clientes o no hay ninguno con estos filtro.");
	    	return null;
	    }
	    return clientesFiltrados.get(0); // Devuelve el cliente único encontrado
	}

}
