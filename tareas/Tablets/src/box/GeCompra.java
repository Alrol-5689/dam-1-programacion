package box;

import java.util.*;

public class GeCompra {
	
	// ATRIBUTOS
	
	protected Scanner sc = new Scanner(System.in);
	
	// MÉTODOS
	protected void devolverTablet(GeCliente geCli, LeCliente leCli, ArrayList<Cliente> arrayClientes, ArrayList<Compra> arrayCompras,
			ArrayList<Tablet> arrayTablets) {
		
		Cliente queDevuelveT;
		String confirmacion = "";
		
	    while(true) {
			System.out.print("\nIntroduce el dato con el que realizar la búsqueda del cliente que realizará la devolución: ");		
			queDevuelveT = geCli.encontrarCliente(leCli, arrayClientes, sc.nextLine());	
			if(queDevuelveT != null) break;	   
			System.out.print("\n¿Quieres intentarlo de nuevo? ( S / N ): ");
	        if (!sc.nextLine().equalsIgnoreCase("S")) {
	            System.out.println("\nVenta cancelada.");
	            return; // Salimos del método
	        }	
	    }
	    
	    ArrayList<Compra> comprasClienteQueDevuelveT = new ArrayList<>();
	    
	    for(Compra c : arrayCompras) {
	    	if(c.cliente.equals(queDevuelveT)) {
	    		comprasClienteQueDevuelveT.add(c);
	    	}
	    }
	    if(comprasClienteQueDevuelveT.isEmpty()) {
	    	System.out.println("\nEl Cliente "+queDevuelveT.getNombre()+" con id "+queDevuelveT.getIdCliente()+", aún no he realizado niguna compra.\n");
	    	return;
	    }
	    // creo que sería más eficiente no separar entre si es una tablet o varias las que se quieres devolver usando "addAll" y listo
	    if(comprasClienteQueDevuelveT.size()==1) {
	    	System.out.println("\nEl Cliente "+queDevuelveT.getNombre()+" id ("+queDevuelveT.getIdCliente()+") ha comprado:\n");
	    	System.out.println(comprasClienteQueDevuelveT.get(0).tablet.toString());
	    	System.out.print("\n¿Confirmamos la devolución? ( S / N ) ");
	    	do {
		    	confirmacion = sc.nextLine();
		    	if(confirmacion.equalsIgnoreCase("S")) {
		    		// no hay que poner la tablet disponible porque ya lo está, cuando se vende solo se elimina de arrayTablets y se agrega a arrayCompras
		    		comprasClienteQueDevuelveT.get(0).tablet.setDisponible(true); // ponemos la tablet disponible de nuevo
		    		arrayTablets.add(comprasClienteQueDevuelveT.get(0).tablet); // la volvemos a meter en arrayTablet
		    		arrayCompras.remove(comprasClienteQueDevuelveT.get(0)); // la eliminar de arrayCompras
		    		System.out.println("\nDevolución realizada con éxito.\n");
		    		return;
		    	}else if(confirmacion.equalsIgnoreCase("N")){
		    		System.out.println("\nDevolución cancelada.");
		    		return;
		    	}else System.out.print("\nPor favor, introduce una opción válida ( S / N ): ");
	    	}while(!confirmacion.equalsIgnoreCase("S") && !confirmacion.equalsIgnoreCase("N"));

	    }
	    if(comprasClienteQueDevuelveT.size() > 1) {
	    	System.out.println("\nEl Cliente "+queDevuelveT.getNombre()+" id ("+queDevuelveT.getIdCliente()+") ha comprado:\n");
	    	for(int i=0; i < comprasClienteQueDevuelveT.size(); i++) {
	    		System.out.println((i+1)+" "+comprasClienteQueDevuelveT.get(i));   	
	    	}
	    	System.out.print("\nIntroduce el número de la tablet que se va a devolver: ");
	    	int numeroT = sc.nextInt();
	    	sc.nextLine(); // limpiar buffer
	    	System.out.println("Tablet a devolver: "+numeroT+".- "+comprasClienteQueDevuelveT.get(numeroT - 1).tablet.toString());
	    	System.out.print("\n¿Confirmamos la devolución? ( S / N ) ");
	    	do {		    	    		    	
		    	confirmacion = sc.nextLine();
		    	if(confirmacion.equalsIgnoreCase("S")) {
		    		comprasClienteQueDevuelveT.get(numeroT - 1).tablet.setDisponible(true);
		    		arrayTablets.add(comprasClienteQueDevuelveT.get(numeroT - 1).tablet);
			    	arrayCompras.remove(comprasClienteQueDevuelveT.get(numeroT - 1));
			    	System.out.println("\nDevolución realizada con éxito.\n");
		    		return;
		    	}else if(confirmacion.equalsIgnoreCase("N")) {
		    		System.out.println("\nDevolución cancelada.");
		    		return;
		    	}else System.out.print("\nPor favor, introduce una opción válida ( S / N ): ");   		
	    	}while(!confirmacion.equalsIgnoreCase("S") && !confirmacion.equalsIgnoreCase("N"));
	    	
	    }        
		
	}
	
	protected void venderTablet(GeCliente geCli, GeTablet geTab, LeCliente leCli, LeTablet leTab, LeReserva leRes,
			ArrayList<Tablet> arrayTablets, ArrayList<Cliente> arrayClientes, ArrayList<Compra> arrayCompras, ArrayList<Reserva> arrayReservas) {
		
		// si hay tiempo añadir opción de compra múltiple con un array
		
		Cliente comprador; // no hace falta inicializarlos por que haremos referencia a un objeto que "ya existen".
	    Tablet aVender; // igual
		
		// BUSCAMOS EL CLIENTE QUE VA A REALIZAR LA COMPRA
		
	    while(true) {
			System.out.print("\nIntroduce el dato con el que realizar la búsqueda del cliente que realizará la compra: ");		
			comprador = geCli.encontrarCliente(leCli, arrayClientes, sc.nextLine());	
			if(comprador != null) break;	   
			if(comprador == null) System.out.print("\n¿Quieres intentarlo de nuevo? ( S / N ): ");
	        if (!sc.nextLine().equalsIgnoreCase("S")) {
	            System.out.println("\nVenta cancelada.");
	            return; // Salimos del método
	        }	
	    }
		if(!comprador.isActivado()) {
			System.out.println(comprador.getNombre()+" "+comprador.getApellido_1()+" [ id: "+comprador.getIdCliente()+" ] "
					+"no está activado. ¿Quieres activarlo? \n\n   Sí ---> (S)\n   No, salir del proceso de compra ---> (N)\n");
			String opcion = sc.next();
			if(opcion.equalsIgnoreCase("s")) {
				comprador.setActivado(true);
				System.out.println("Cuenta activada.");
			}else {
				System.out.println("La cuenta permanecerá desactivada. Abortamos el proceso de compra.");
				return;
			}
		}
		System.out.println("\nVa a realizar la compra ---> "+comprador.toString());
		
		// BUSCAMOS LA TABLET A VENDER
		
		while(true) {
			System.out.print("\nIntroduce el dato con el que realizar la búsqueda de la tablet que va a ser comprada: ");
			aVender = geTab.encontrarTablet(leTab, arrayTablets, sc.nextLine());
			if(aVender != null) break;
			System.out.print("\n¿Quieres intentarlo de nuevo? ( S / N ): ");
			if (!sc.nextLine().equalsIgnoreCase("S")) {
	            System.out.println("\n Venta cancelada.");
	            return;
	        }			
		}	
		
		// CONFIRMAMOS QUE LA TABLET NO ESTÉ RESERVADA - DE ESTARLO CANCELAMOS LA VENTA A NO SER QUE ESTÉ RESERVADA POR EL QUE HACE LA COMPRA:
		// si está reservada por otro cliente también damos la opción de eliminar la reserva y venderla de todas maneras
		
		for(int i=0; i < arrayReservas.size(); i++) {	// tiene que ser for normal porque sino salta excepción
			Reserva r = arrayReservas.get(i);			
			if(r.tablet.equals(aVender)) {				
				if(r.cliente.equals(comprador)) {							
					System.out.println("\nEsta tablet está reservada a nombre de este cliente. Procedemos con la compra.");
					leRes.cancelarReserva(aVender, arrayReservas); // pone la tablet disponible y la quita de arrayReservas
				}else {
					System.out.println("\nEsta tablet está reservada por el titular: (id: "+r.cliente.getIdCliente()+") " + r.cliente.getNombre());
		            System.out.print("\nIntroduce \"S\" para realizar la venta de todas maneras, u otra letra para abortar la compra: ");
		            if (!sc.nextLine().equalsIgnoreCase("S")) {
		                System.out.println("\nVenta cancelada.");
		                return;
		            }
		            System.out.println("\nSe eliminó la reserva. Seguimos con el proceso de compra.");
		            leRes.cancelarReserva(aVender, arrayReservas);
				}
				break;
			}
			
		}
		// COMENTO ESTO PORQUE ASÍ ME SALTA UNA EXCEPCION: preguntar por qué :
		/*String cancelarR = "";
		for(Reserva r : arrayReservas) { // si el resto del código funciona como quiero con comprobar aVender.isDisponible valdría
			if(r.tablet.equals(aVender) && !r.cliente.equals(comprador)) {
				System.out.println("\nEsta tablet esta reservada por el titular: "+r.cliente.toString());
				System.out.print("\nIntroduce \"S\" para realizar la venta de todas manera, u otra letra para abortar la compra: ");
				cancelarR = sc.nextLine();
				if(cancelarR.equalsIgnoreCase("S")) {
					System.out.println("\nSe eliminó la reserva, seguimos con el proceso de compra.");
					leRes.cancelarReserva(aVender, arrayReservas); // este método pone la tablet disponible y la elimina de arrayReservas
				}else {
					System.out.println("\nVenta cancelada.");
					return;
				}
			}
		}*/
				
		// CONFIRMAMOS DATOS Y REALIZAMOS LA VENTA
		
		System.out.println("\nCliente: "+comprador.toString()+"\nTablet: "+aVender.toString()
					+ "\n¿Son correctos los datos? \n"
					+ "\n  Sí, confirmar compra ---> \"s\""
					+ "\n  No, abortar compra ---> \"n\" \n");
		String opcion = sc.nextLine();
		if(opcion.equalsIgnoreCase("s")) {
			System.out.println("\nVenta realizada correctamente.");
			for(Reserva r : arrayReservas) { // por descarte solo estamos eliminado la reserva si es del cliente que compra
				if(r.tablet.equals(aVender)) {
					leRes.cancelarReserva(aVender, arrayReservas); // elimina la tablet de arrayReservas y la pone disponible
				}
			}
			arrayTablets.remove(aVender);
			Compra nuevaCompra = new Compra(aVender, comprador, aVender.getPrecio()); // con este constructor aumenta id compra
			arrayCompras.add(nuevaCompra);
			aVender.setDisponible(false); // ponemos la tablet como no disponible
		}else {
			System.out.println("\nCompra NO realizada.");	
		}
	}

}
