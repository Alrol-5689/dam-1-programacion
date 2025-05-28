package box;

import java.util.*;

public class GeReserva {
	
	// ATRIBUTOS
	
	protected Scanner sc = new Scanner(System.in);
	
	// MÉTODOS
	
	protected void cancelarReserva(GeCliente geCli, LeCliente leCli, ArrayList<Cliente> arrayClientes, ArrayList<Reserva> arrayReservas){
		
		// pensar en introducir la opción de cancelar todas sus reservas de una
		
		Cliente queCancelaR;
		String confirmacion = "";
		
	    while(true) {
			System.out.print("\nIntroduce el dato con el que realizar la búsqueda del cliente que quiere cancelar la reserva: ");		
			queCancelaR = geCli.encontrarCliente(leCli, arrayClientes, sc.nextLine());	
			if(queCancelaR != null) break;	   
			System.out.print("\n¿Quieres intentarlo de nuevo? ( S / N ): ");
	        if (!sc.nextLine().equalsIgnoreCase("S")) {
	            System.out.println("\nProceso cancelado.");
	            return; // Salimos del método
	        }	
	    }
	    ArrayList<Reserva> reservasDelCliente = new ArrayList<>();
	    
	    for(Reserva r : arrayReservas) {
	    	if(r.cliente.equals(queCancelaR)) {
	    		reservasDelCliente.add(r);
	    	}
	    }
	    if(reservasDelCliente.isEmpty()) {
	    	System.out.println("\nEl cliente "+queCancelaR.getNombre()+" con id "+queCancelaR.getIdCliente()+", no tiene ninguna reserva.");
	    	return;
	    }
	    if(reservasDelCliente.size()==1) {
	    	System.out.println("\nEñ cliente "+queCancelaR.getNombre()+" con id "+queCancelaR.getIdCliente()+", tiene la siguiente tablet reservada:");
	    	System.out.println(reservasDelCliente.get(0).tablet.toString());
	    	System.out.print("\nIntroduce \"S\" para cancelar la reserva u otra letra para salir: ");
	    	confirmacion = sc.nextLine();
	    	if(confirmacion.equalsIgnoreCase("S")) {
	    		reservasDelCliente.get(0).tablet.setDisponible(true);
	    		arrayReservas.remove(reservasDelCliente.get(0));
	    		System.out.println("\nReserva cancelada correctamente.");
	    		return;
	    	}else {
	    		System.out.println("\nNo se canceló la reserva.");
	    		return;
	    	}
	    }else if(reservasDelCliente.size()>1) {
	    	System.out.println("\nEñ cliente "+queCancelaR.getNombre()+" con id "+queCancelaR.getIdCliente()+", tiene las siguientes tablets reservadas:");
	    	for(int i=0; i<reservasDelCliente.size(); i++) {
	    		System.out.println((i+1)+".- "+reservasDelCliente.get(i).tablet.toString());
	    	}
	    	System.out.print("\nSelecciona el número de la reserva que quieres cancelar: ");
	    	int seleccion = sc.nextInt();
	    	sc.nextLine(); // limpiar buffer
	    	System.out.println("\nReserva seleccionada: "+reservasDelCliente.get(seleccion-1).tablet.toString());
	    	System.out.print("\nIntroduce \"S\" para cancelar la reserva u otra letra para salir: ");
	    	confirmacion = sc.nextLine();
	    	if(confirmacion.equalsIgnoreCase("S")) {
	    		reservasDelCliente.get(seleccion-1).tablet.setDisponible(true);
	    		arrayReservas.remove(reservasDelCliente.get(seleccion-1));
	    		System.out.println("\nReserva cancelada correctamente.");
	    		return;
	    	}else {
	    		System.out.println("\nNo se canceló la reserva.");
	    		return;
	    	}
	    }	     
	    
	}
	
	protected void reservarTablet(GeCliente geCli, LeCliente leCli, GeTablet geTab, LeTablet leTab, LeReserva leRes,
			ArrayList<Cliente> arrayClientes, ArrayList<Tablet> arrayTablets, ArrayList<Reserva> arrayReservas) {
		
		// ENCONTRAMOS TANTO EL CLIENTE QUE VA A REALIZAR LA RESERVA COMO LA TABLET QUE VA A SER RESERVADA
		
		// no hace falta inicializarlos por que haremos referencia a un objeto que "ya existen".
		
		Cliente clienteRes = geCli.encontrarCliente_queReserva(leCli, arrayClientes);
		if(clienteRes == null) return;
		
	    Tablet aReservar = geTab.encontrarTablet_AReservar(leTab, arrayTablets);
	    if(aReservar == null) return;
		
	    // comprobamos que la tablet no esté ya reservada
	    
	    if(!aReservar.isDisponible()) { // no doy la opción de ponerla disponible y eliminarla de arrayReservas, que tome nota de la tablet y la busque...
	    	System.out.println("\nLa tablet ya está reservada. Lo siento.");
	    	return;
	    }
		// CONFIRMAMOS DATOS Y REALIZAMOS LA RESERVA
		
		System.out.println("\nResumen: \n");
		System.out.println("\n---> "+clienteRes.toString()+"\n---> "+aReservar.toString()
					+ "\n¿Son correctos los datos? \n"
					+ "\n  Sí, confirmar reserva ---> \"s\""
					+ "\n  No, abortar reserva ---> \"n\" \n");
		String opcion = sc.nextLine();
		if(opcion.equalsIgnoreCase("s")) {
			System.out.println("\nReserva realizada correctamente.");
			leRes.reservarTablet(clienteRes, aReservar, arrayReservas);
		}else {
			System.out.println("\nReserva NO realizada.");	
		}
		
	}
	

	

}
