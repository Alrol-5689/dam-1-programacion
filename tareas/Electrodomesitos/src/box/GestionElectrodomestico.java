package box;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionElectrodomestico {
	
	protected ArrayList<Electrodomestico> filtrarElectrodomesticos(ArrayList<Electrodomestico> arrayElectrodomesticos, String entrada) {		
	    ArrayList<Electrodomestico> electrodomesticosFiltrados = new ArrayList<>(); 
	    try { // Primero intentamos convertir a int para buscar por ID 
	        int id = Integer.parseInt(entrada);
	        for (Electrodomestico t : arrayElectrodomesticos) {
	            if (t.getId() == id) electrodomesticosFiltrados.add(t);            
	        }
	    } catch (NumberFormatException e) {} // No es un número entero, seguimos probando...
	    entrada = entrada.replace(",", "."); // para poder filtrar por peso o precio
	    try { // Ahora intentamos convertir a double para buscar por precio o peso
	        double precioOPeso = Double.parseDouble(entrada);
	        for (Electrodomestico t : arrayElectrodomesticos) {
	            if (t.getPrecio() == precioOPeso || t.getPeso() == precioOPeso) electrodomesticosFiltrados.add(t);	            
	        }
	    } catch (NumberFormatException e) {} // No es un número decimal, seguimos probando...
	    if(entrada.length() == 1 && "ABCDEFabcdef".contains(entrada)) { // buscamos por consumo:
	    	char consumo = Character.toUpperCase(entrada.charAt(0));
	    	for(Electrodomestico e : arrayElectrodomesticos) {
	    		if(e.getConsumo() == consumo) electrodomesticosFiltrados.add(e);
	    	}
	    }
	    for (Electrodomestico t : arrayElectrodomesticos) { // Finalmente, buscamos por Marca, modelo o color
	        if (t.getMarca().equalsIgnoreCase(entrada) || t.getModelo().equalsIgnoreCase(entrada) || t.getColor().equalsIgnoreCase(entrada)) electrodomesticosFiltrados.add(t);
	    }
	    return electrodomesticosFiltrados; // Retornamos la lista con los resultados (vacía si no hay coincidencias)
	}
	
	protected Electrodomestico encontrarElectrodomestico(ArrayList<Electrodomestico> array, String entrada, Scanner sc) {	
	    ArrayList<Electrodomestico> electrodomesticosFiltrados = filtrarElectrodomesticos(array, entrada);	    
	    while (electrodomesticosFiltrados.size() > 1) { // si hay más de uno hay que encontrarlo
	    	System.out.println("\nSe encontraron varios electrodomésticos:\n");
	    	for (Electrodomestico c : electrodomesticosFiltrados) {
	    		System.out.println(c.toString());
	    	}  // pedimos el siguiente dato para refinal la lista
	        System.out.print("\nIntroduce otro dato para filtrar la búsqueda (o escribe \"S\" para salir): ");
	        String nuevoFiltro = sc.nextLine();
	        if(nuevoFiltro.equalsIgnoreCase("s")) return null; // se cancela la operación si introduce "s", sino volvemos a refinar hasta que quede 1 electrodoméstico
	        electrodomesticosFiltrados = filtrarElectrodomesticos(electrodomesticosFiltrados, nuevoFiltro);
	        if (electrodomesticosFiltrados.isEmpty()) {
	            System.out.println("\nEl filtro no ha refinado la lista..");
	            return null;
	        } 
	    }	    
	    if(electrodomesticosFiltrados.isEmpty()) {
	    	System.out.println("\nAún no hay electrodomésticos o no hay ninguno con estos filtros.");
	    	return null;
	    }
	    return electrodomesticosFiltrados.get(0); // Devuelve el cliente único encontrado
	}
}
