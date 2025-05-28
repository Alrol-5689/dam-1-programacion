package concesionario;

import java.util.*;

public class Concesionario {
	
	final static int FILAS=100, COLUMNAS=6;
	static String[][] vehiculos = new String[FILAS][COLUMNAS];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcionMenu;
		Scanner sc = new Scanner(System.in);
		
		
		do {
			
			mostrarMenu();
			opcionMenu = sc.nextInt();
			menuOpciones(sc, opcionMenu);
			
		}while(opcionMenu!=8);
		

	}
	
	public static void mostrarMenu() {
		
		System.out.println("\nElije una de las opciones:\n"
				+"\n  1.- Ingresar vehículo."
				+"\n  2.- Modificar vehículo."
				+"\n  3.- Eliminar vehículo."
				+"\n  4.- Mostrar vehículos disponibles."
				+"\n  5.- Vender vehículo."
				+"\n  6.- Mostrar vehículos vendidos."
				+"\n  7.- Mostrar vehículos de un cliente."
				+"\n  8.- Salir.\n");
	}
	
	public static void menuOpciones (Scanner sc, int opcionMenu) {
		
		
		
		switch(opcionMenu) {
			case 1: ingresarVehiculo(vehiculos, sc);
				break;
			case 2: modificarVehiculo(vehiculos, sc);
				break;
			case 3: eliminarVehiculo(vehiculos, sc);
				break;
			case 4: mostrarVehiculosDisponibles(vehiculos);
				break;
			case 5: venderVehiculo(vehiculos, sc);
				break;
			case 6: mostrarVehiculosVendidos(vehiculos);
				break;
			case 7: mostrarVehiculosCliente(vehiculos, sc);
				break;
			case 8: System.out.println("\nHasta la próxima.");
				break;
			default: System.out.println("\nOpcion incorrecta.");
				break;
		}
	}
	
	public static void ingresarVehiculo(String[][] vehiculos, Scanner sc) {
		boolean guardado = false;
		for(int i=0; i<vehiculos.length; i++) {
			if(vehiculos[i][0]==null) {
				System.out.print("\nIngresa la matrícula:");
				vehiculos[i][0] = sc.next();
				System.out.print("\nIngresa la marca:");
				vehiculos[i][1] = sc.next();
				System.out.print("\nIngresa el modelo:");
				vehiculos[i][2] = sc.next();
				System.out.print("\nIngresa el color:");
				vehiculos[i][3] = sc.next();
				System.out.print("\nIngresa el precio:");
				vehiculos[i][4] = sc.next();
				System.out.print("\nVehículo ingresado correctamente:");
				guardado = true;
				break;
			}
		}
		if(!guardado) System.out.println("\nNo se ha podido guardar el vehículo.");		
	}
	
	public static void modificarVehiculo(String[][] vehiculos, Scanner sc) {
		boolean modificado = false;
		System.out.print("\nDime la matrícula del vehículo que deseas modificar:");
		String matricula = sc.next();
		for(int i=0; i<vehiculos.length; i++) {
			if(vehiculos[i][0] != null && vehiculos[i][0].equalsIgnoreCase(matricula)){
				System.out.print("\nIngresa la marca:");
				vehiculos[i][1] = sc.next();
				System.out.print("\nIngresa la modelo:");
				vehiculos[i][2] = sc.next();
				System.out.print("\nIngresa el color:");
				vehiculos[i][3] = sc.next();
				System.out.print("\nIngresa el precio:");
				vehiculos[i][4] = sc.next();
				System.out.print("\nVehículo modificado correctamente:");
				modificado = true;
				break;
			}
		}
		if(!modificado) System.out.println("\nNo se ha podido modificar.");
	}
	
	public static void eliminarVehiculo(String[][] vehiculos, Scanner sc) {
		boolean eliminado = false;
		System.out.print("\nDime la matrícula del vehículo que deseas eliminar:");
		String matricula = sc.next();
		for(int i=0; i<vehiculos.length; i++) {
			if(vehiculos[i][0] != null && vehiculos[i][0].equalsIgnoreCase(matricula)) {
				vehiculos[i][0] = null;
				vehiculos[i][1] = null;
				vehiculos[i][2] = null;
				vehiculos[i][3] = null;
				vehiculos[i][4] = null;
				vehiculos[i][5] = null;
				eliminado = true;
				break;
			}
		}
		if(!eliminado) System.out.println("\nNo se ha podido eliminar.");
	}
	
	public static void mostrarVehiculosDisponibles(String[][] vehiculos) {
		int lista = 1;
		System.out.println("Los vehículos disponibles son:\n");
		for(int i=0; i<vehiculos.length; i++) {
			if(vehiculos[i][0] != null && vehiculos[i][5] == null) {
				System.out.println(lista+" "+vehiculos[i][1]+" "+vehiculos[i][2]+" "+vehiculos[i][3]+". ("+vehiculos[i][0]+"). ");
				lista++;
			}
		}
	}
	
	public static void venderVehiculo(String[][] vehiculos, Scanner sc) {
		mostrarVehiculosDisponibles(vehiculos);
		System.out.print("\nIntroduce la matrícula del vehículo que se va a vender:");
		String matricula = sc.next();
		boolean vendido = false;
		for(int i=0; i<vehiculos.length; i++) {
			if(vehiculos[i][0] != null && vehiculos[i][0].equalsIgnoreCase(matricula)) {
				System.out.print("\nIntroduce el DNI del comprador:");
				vehiculos[i][5] = sc.next();
				System.out.println("\nVehículo vendido correctamente.");
				vendido = true;
				break;
			}
		}
		if(!vendido) System.out.println("\nNo se ha encontrado la matrícula.");
	}
	
	public static void mostrarVehiculosVendidos(String[][] vehiculos) {
		int lista = 1;
		System.out.println("Los vehículos disponibles son:\n");
		for(int i=0; i<vehiculos.length; i++) {
			if(vehiculos[i][0] != null && vehiculos[i][5] != null) {
				System.out.println(lista+": Marca: "+vehiculos[i][1]+", modelo: "+vehiculos[i][2]+". DNI del comprador: "+vehiculos[i][5]+".");
				lista++;
			}
		}
	}
	
	public static void mostrarVehiculosCliente(String[][] vehiculos, Scanner sc) {
		int lista = 1;
		System.out.print("\nIntroduce el DNI del cliente");
		String cliente = sc.next();
		boolean match = false;
		for(int i=0; i<vehiculos.length; i++) {
			if(vehiculos[i][0] != null && vehiculos[i][5] != null && vehiculos[i][5].equalsIgnoreCase(cliente)) {
				System.out.println("\n"+lista+": Marca: "+vehiculos[i][1]+", modelo: "+vehiculos[i][2]+".");
				match = true;
			}
		}
		if(!match) System.out.println("El DNI introducido es incorrecto o no pertenece a ningún cliente.");
	}

}
