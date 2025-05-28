package box;

import java.util.ArrayList;
import java.util.Scanner;

public class LeTablet {
	
	// ATRIBUTOS
	
	protected Scanner sc = new Scanner(System.in);

	
	// MÉTODOS
	
	protected void mostrarTablets_reservadas(ArrayList<Reserva>arrayReservas) {
		
		if(arrayReservas.isEmpty()) {
			System.out.println("\nActualmente no hay ninguna tablet reservada.\n");
			return;
		}
		System.out.println("\nLista de tablets reservadas:\n");
		for(Reserva r : arrayReservas) {
			System.out.println(r.tablet.toString()+" Cliente: id "+r.cliente.getIdCliente()+" "+r.cliente.getNombre());
		}
	}
	
	protected void mostrarTablets_disponibles(ArrayList<Tablet> arrayTablets) {
		
		if(arrayTablets.isEmpty()) {
			System.out.println("\nActualmente no hay ninguna tablet disponible.\n");
			return;
		}
		System.out.println("\nLista de tablets disponibles:\n");
		for(Tablet t : arrayTablets) {
			if(t.isDisponible()) System.out.println(t.toString());
		}
	}
	protected void mostrarTablets_vendidas(ArrayList<Compra> arrayCompras) {
		
		if(arrayCompras.isEmpty()) {
			System.out.println("\nAún no se ha vendido ninguna tablet.\n");
			return;
		}
		System.out.println("\nLista de tablets vendidas:\n");
		for(Compra c : arrayCompras) {
			System.out.println(c.tablet.toString()+" Cliente id: "+c.cliente.getIdCliente()+" "+c.cliente.getNombre());
		}
	}
	
	protected void mostrarTablets_todas(ArrayList<Tablet> arrayTablets, ArrayList<Reserva> arrayReservas, ArrayList<Compra> arrayCompras) {
		
		System.out.println("\nTablets disponibles:\n");
		for(Tablet t : arrayTablets) {
			if(t.isDisponible()) System.out.println(t.toString());
		}
		System.out.println("\nTablets reservadas:\n");
		for(Reserva r : arrayReservas) {
			System.out.println(r.tablet.toString()+" Cliente: id "+r.cliente.getIdCliente()+" "+r.cliente.getNombre());
		}
		System.out.println("\nTablets vendidas:\n");
		for(Compra c : arrayCompras) {
			System.out.println(c.tablet.toString()+" Cliente id: "+c.cliente.getIdCliente()+" "+c.cliente.getNombre());
		}
	}
	
	protected ArrayList<Tablet> filtrarTablets(ArrayList<Tablet> array, String entrada) {
	    ArrayList<Tablet> tabletsEncontradas = new ArrayList<>();
	    // Primero intentamos convertir a int para buscar por ID o Año
	    try {
	        int idOAnyo = Integer.parseInt(entrada);
	        for (Tablet t : array) {
	            if (t.getIdTablet() == idOAnyo || t.getLanzamiento() == idOAnyo) {
	                tabletsEncontradas.add(t);
	            }
	        }
	        if (!tabletsEncontradas.isEmpty()) return tabletsEncontradas; // Si encontramos algo, salimos
	    } catch (NumberFormatException e) {} // No es un número entero, seguimos probando...
	    // Ahora intentamos convertir a double para buscar por precio o pulgadas
	    entrada = entrada.replace(",", "."); // para poder filtrar por pulgadas o precio
	    try {
	        double precioOPulgadas = Double.parseDouble(entrada);
	        for (Tablet t : array) {
	            if (t.getPrecio() == precioOPulgadas || t.getPulgadas() == precioOPulgadas) {
	                tabletsEncontradas.add(t);
	            }
	        }
	        if (!tabletsEncontradas.isEmpty()) return tabletsEncontradas; // Si encontramos algo, salimos
	    } catch (NumberFormatException e) {} // No es un número decimal, seguimos probando...
	    // Finalmente, buscamos por Marca, modelo o color
	    for (Tablet t : array) {
	        if (t.getMarca().equalsIgnoreCase(entrada) || t.getModelo().equalsIgnoreCase(entrada) || t.getColor().equalsIgnoreCase(entrada)) {
	            tabletsEncontradas.add(t);
	        }
	    }
	    return tabletsEncontradas; // Retornamos la lista con los resultados (vacía si no hay coincidencias)
	}
	
	protected ArrayList<Tablet> filtrarPorMarca(ArrayList<Tablet> array, String entrada){
		ArrayList<Tablet> tabletsEncontradas = new ArrayList<>();
		for(Tablet a : array) {
			if(a.getMarca().equalsIgnoreCase(entrada)) {
				tabletsEncontradas.add(a);
			}
		}
		return tabletsEncontradas;		
	}
	
	protected ArrayList<Tablet> filtrarPorModelo(ArrayList<Tablet> array, String entrada){
		ArrayList<Tablet> tabletsEncontradas = new ArrayList<>();
		for(Tablet a : array) {
			if(a.getModelo().equalsIgnoreCase(entrada)) {
				tabletsEncontradas.add(a);
			}
		}
		return tabletsEncontradas;		
	}
	
	protected ArrayList<Tablet> filtrarPorColor(ArrayList<Tablet> array, String entrada){
		ArrayList<Tablet> tabletsEncontradas = new ArrayList<>();
		for(Tablet a : array) {
			if(a.getColor().equalsIgnoreCase(entrada)) {
				tabletsEncontradas.add(a);
			}
		}
		return tabletsEncontradas;		
	}
	
	protected ArrayList<Tablet> filtrarPorPulgadas(ArrayList<Tablet> array, double entrada){
		ArrayList<Tablet> tabletsEncontradas = new ArrayList<>();
		for(Tablet a : array) {
			if(a.getPulgadas() == entrada) {
				tabletsEncontradas.add(a);
			}
		}
		return tabletsEncontradas;		
	}
	
	protected ArrayList<Tablet> filtrarPorPrecio(ArrayList<Tablet> array, double entrada){
		ArrayList<Tablet> tabletsEncontradas = new ArrayList<>();
		for(Tablet a : array) {
			if(a.getPrecio() == entrada) {
				tabletsEncontradas.add(a);
			}
		}
		return tabletsEncontradas;		
	}
	
	protected ArrayList<Tablet> filtrarPorAnyoLanzamiento(ArrayList<Tablet> array, int entrada){
		ArrayList<Tablet> tabletsEncontradas = new ArrayList<>();
		for(Tablet a : array) {
			if(a.getLanzamiento() == entrada) {
				tabletsEncontradas.add(a);
			}
		}
		return tabletsEncontradas;		
	}

}
