package box;

import java.util.ArrayList;
import java.util.Scanner;

public class LeCliente {
	
	// ATRIBUTOS
	
	protected Scanner sc = new Scanner(System.in);
	protected LecturaEscritura le = new LecturaEscritura();
	
	// MÉTODOS
	
	protected ArrayList<Cliente> filtrarClientes(ArrayList<Cliente> array, String entrada) {
	    ArrayList<Cliente> clientesEncontrados = new ArrayList<>();
	    try { // buscamos primero por los datos int, o sea tlf o id
	        int tlfOid = Integer.parseInt(entrada);
	        for (Cliente a : array) {
	            if (a.getIdCliente() == tlfOid || a.getTelefono() == tlfOid) {
	                clientesEncontrados.add(a);
	            }
	        }
	        if (!clientesEncontrados.isEmpty()) return clientesEncontrados; // Si hay coincidencias, devolver resultados
	    } catch (NumberFormatException e) {}
	    if (le.dniValido(entrada)) { // comprobamos si es un dni
	        for (Cliente a : array) {
	            if (a.getDni().equalsIgnoreCase(entrada)) {
	                clientesEncontrados.add(a);
	            }
	        }
	        if (!clientesEncontrados.isEmpty()) return clientesEncontrados; // Si hay coincidencias, devolver resultados
	    }
	    for (Cliente a : array) {
	        if (a.getNombre().equalsIgnoreCase(entrada) || a.getApellido_1().equalsIgnoreCase(entrada) ||
	            a.getApellido_2().equalsIgnoreCase(entrada)) {
	            clientesEncontrados.add(a);
	        }
	    }
	    return clientesEncontrados; 
	}

}
