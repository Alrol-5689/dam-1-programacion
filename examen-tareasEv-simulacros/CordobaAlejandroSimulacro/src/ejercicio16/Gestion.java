package ejercicio16;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {
	
	int opcion;
	ArrayList<Barco> barcos = new ArrayList<>();
	Metodos m = new Metodos();
	Lectura l = new Lectura();
	Scanner sc = new Scanner(System.in);
	
	protected void start() {
		
		do {
			
			opcion = l.menu(sc);
			
			switch (opcion) {
			case 1:
				m.nuevoBarco(l, sc, barcos); // nos lleva a la clase Metodos para crear el nuevo barco
				break;
			case 2:
				m.mostrarInfo(l, sc, barcos);
				break;
			case 3:
				m.calcularCapacidadTotal(l, sc, barcos);
				break;
			case 4:
				System.out.println("Hasta la próxima.");
				break;
			default:
			}
			
		}while(opcion != 4);
	}

}
