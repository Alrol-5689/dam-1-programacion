package ejercicio16;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
	
	protected void nuevoBarco(Lectura l, Scanner sc, ArrayList<Barco> barcos) {
		String nombre = l.pedirString(sc, false, "Introduce el nombre del barco: ");
		double velocidad = l.pedirDouble(sc, "Introduce su velocidad máxima: ");
		int opcion = l.pedirOpcion(sc, 1, 3, "\nElije una opción:\n" + """
				1.- Es un barco de pasajeros.
				2.- Es un barco de carga.
				3.- Salir.
				\nSelecciona una opcion: """ + " ");
		switch (opcion) {
			case 1:
				int numCamarotes = l.pedirInt(sc, "Introduce el número de camarotes: ");
				int pasajerosPorCamarote = l.pedirInt(sc, "Intruce cuántos pasajeros soporte cada camarote: ");
				BarcoPasajeros nuevoBP = new BarcoPasajeros(nombre, velocidad, numCamarotes, pasajerosPorCamarote);
				barcos.add(nuevoBP);
				System.out.println("Barco añadido correctamente.");
				break;
			case 2:
				int numBodegas = l.pedirInt(sc, "Introduce el número de camarotes: ");
				double capacidadPorBodega_KG = l.pedirDouble(sc, "Intruce cuántos pasajeros soporte cada camarote: ");
				BarcoCarga nuevoBC = new BarcoCarga(nombre, velocidad, capacidadPorBodega_KG, numBodegas);
				barcos.add(nuevoBC);
				System.out.println("Barco añadido correctamente.");
				break;
			case 3: 
				System.out.println("Abortamos");
				return;
			default:
		}

	}
	
	protected void mostrarInfo(Lectura l, Scanner sc, ArrayList<Barco> barcos) {
		for(Barco b : barcos) {
			System.out.println(b.mostrarInformacion());
		}
	}
	
	protected void calcularCapacidadTotal(Lectura l, Scanner sc, ArrayList<Barco> barcos) {
		for(Barco b : barcos) {
			System.out.println(b.mostrarInformacion());
			System.out.println("Su capacidad total es: "+b.calcularCapacidad());
			System.out.println("--------------------------------------------------------------------------");
		}
	}

}
