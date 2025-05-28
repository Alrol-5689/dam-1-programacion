package box;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionPrincipal {
	
	Scanner sc = new Scanner(System.in);
	protected int opcionMenu;
	
	ArrayList<Electrodomestico> arrayElectrodomesticos = new ArrayList<>();
	
	protected LecturaEscrituraPrincipal le = new LecturaEscrituraPrincipal();
	protected GestionElectrodomestico gesEle = new GestionElectrodomestico();
	protected LecturaLavadora lecLav = new LecturaLavadora();
	protected LecturaTelevisor lecTel = new LecturaTelevisor();	
	protected GestionLavadora gesLav = new GestionLavadora();
	protected GestionTelevisor gesTel = new GestionTelevisor();
	
	protected void gestionPrincipal() {
		
		do {
			opcionMenu = le.menuPrincipal();
			switch(opcionMenu) {
				case 1: opcionMenu = le.menuAlta();
						switch(opcionMenu) {
							case 1: gesLav.altaLavadora(arrayElectrodomesticos, sc);
								break;
							case 2: gesTel.altaTelevisor(arrayElectrodomesticos, sc);
								break;
							case 3: // volver
								break;
							case 4: System.out.println("\nHasta la próxima.");
								break;
							default: 
						}		
					break;
				case 2: opcionMenu = le.menuEliminar();
						switch(opcionMenu) {
							case 1: gesLav.eliminarLavadora(arrayElectrodomesticos, sc);
								break;
							case 2: gesTel.eliminarTelevisor(arrayElectrodomesticos, sc);
								break;
							case 3: // volver
								break;
							case 4: System.out.println("\nHasta la próxima.");
								break;
							default: 
						}
					break;
				case 3: opcionMenu = le.menuMostrarPrecio();
						switch(opcionMenu) {
							case 1: gesLav.mostrarLavadoras(arrayElectrodomesticos);
								break;
							case 2: gesTel.mostrarTelevisores(arrayElectrodomesticos);
								break;
							case 3: // volver
								break;
							case 4: System.out.println("\nHasta la próxima.");
								break;
							default: 
						}
					break;
				case 4: System.out.println("\nHasta la próxima.");
					break;
				// default: no hace falta porque menuPrincipal ya controla que se ingrese bien por consola
			}
			
		}while(opcionMenu != 4);
	}
	

	

	
	
	
	
	

}
