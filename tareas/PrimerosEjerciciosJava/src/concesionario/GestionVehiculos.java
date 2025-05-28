package concesionario;

import java.util.*;

public class GestionVehiculos {
	
	private static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion;
		
		do {
			
			mostrarMenu();
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch (opcion) {
			case 1: 
				insertarVehiculo();
				break;
			case 2: 
				eliminarVehiculo();
				break;
			case 3:
                modificarVehiculo();
                break;
            case 4:
                System.out.println("¡Hasta pronto!");
                break;
            default:
                System.out.println("Opción no válida.");
			}
			
		}while(opcion != 4);

	} // SALIMOS DEL MAIN
	
	public static void mostrarMenu() {
        System.out.println("\n--- Gestión de Vehículos ---");
        System.out.println("1. Insertar vehículo");
        System.out.println("2. Eliminar vehículo");
        System.out.println("3. Modificar vehículo");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
    }

    public static void insertarVehiculo() {
        System.out.print("Introduce la matrícula del vehículo: ");
        String matricula = sc.nextLine();

        // Comprobar si la matrícula ya existe
        if (buscarVehiculoPorMatricula(matricula) != null) {
            System.out.println("Error: La matrícula ya existe.");
            return;
        }

        System.out.print("Introduce el modelo del vehículo: ");
        String modelo = sc.nextLine();

        listaVehiculos.add(new Vehiculo(matricula, modelo));
        System.out.println("Vehículo añadido correctamente.");
    }

    public static void eliminarVehiculo() {
        System.out.print("Introduce la matrícula del vehículo a eliminar: ");
        String matricula = sc.nextLine();

        Vehiculo vehiculo = buscarVehiculoPorMatricula(matricula);
        if (vehiculo != null) {
            listaVehiculos.remove(vehiculo);
            System.out.println("Vehículo eliminado correctamente.");
        } else {
            System.out.println("Error: No se encontró un vehículo con esa matrícula.");
        }
    }

    public static void modificarVehiculo() {
        System.out.print("Introduce la matrícula del vehículo a modificar: ");
        String matricula = sc.nextLine();

        Vehiculo vehiculo = buscarVehiculoPorMatricula(matricula);
        if (vehiculo != null) {
            System.out.print("Introduce el nuevo modelo: ");
            String nuevoModelo = sc.nextLine();
            vehiculo.setModelo(nuevoModelo);
            System.out.println("Vehículo modificado correctamente.");
        } else {
            System.out.println("Error: No se encontró un vehículo con esa matrícula.");
        }
    }

    public static Vehiculo buscarVehiculoPorMatricula(String matricula) {
        for (Vehiculo v : listaVehiculos) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                return v;
            }
        }
        return null;
    }
}
