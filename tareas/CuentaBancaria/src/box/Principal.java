package box;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		
		GestionCuentas gestion = new GestionCuentas();
		int opcionMenu;
		Scanner sc = new Scanner(System.in);	
		
		do {			
			mostrarMenu();
			opcionMenu = sc.nextInt();
			sc.nextLine(); // limpiar buffer
			menuOpciones(sc, opcionMenu, gestion);			
		}while(opcionMenu!=8);
		
	}
	
	/*POSIBLE MEJORA:
	  1.: Que una cuenta no pueda estar activa si tiene algún campo null, para ello:
	    - Los constructores de la clase Cuenta que no pidan todos los campos no la activarán por defecto.
	    - Cambiar el método activarDesactivarCuenta para que pida los campos que falten antes de activar.
	  2.: Crear un método para listar a todos los titulares, otro para listar los activados y otro para los desactivados*/
	 
	
	public static void mostrarMenu() {
		
		System.out.println("\nElige una de las siguientes opciones: \n"
				+"\n  1.- Ingresar dinero."
				+"\n  2.- Retirar dinero."
				+"\n  3.- Realizar una transferencia a un cliente de este banco."
				+"\n-------------------------------------------------------------------"
				+"\n  4.- Crear nueva cuenta."
				+"\n  5.- Modificar una cuenta existente."
				+"\n  6.- Desactivar o Activar una cuenta."
				+"\n  7.- Eliminar cuenta definitivamente."
				+"\n  8.- Salir.");
	}
	
	public static void menuOpciones(Scanner sc, int opcionMenu, GestionCuentas gestion) {
		
		switch(opcionMenu) {
		case 1: ingresar(sc, gestion);
			break;
		case 2: retirar(sc, gestion);
			break;
		case 3: transferencia(sc, gestion);
			break;
		case 4: agregarCuenta(sc, gestion);
			break;
		case 5: modificarCuenta(sc, gestion);
			break;
		case 6: desactivarActivarCuenta(sc, gestion);
			break;
		case 7: eliminarCuenta(sc, gestion);
			break;
		case 8: System.out.println("\nHasta la prócima.");
			break;
		default: System.out.println("\nOpción incorrecta.");
			break;
		}
	}
	
	public static void eliminarCuenta(Scanner sc, GestionCuentas gestion) {
		
		// PEDIMOS EL TITULAR QUE VA A SER ELIMINADO DEL SISTEMA DEFINITIVAMENTE
		
		System.out.print("\nIntroduce el nombre o el DNI del titular que va a ser eliminado:");
		String entrada = sc.nextLine();
		
		// LO BUSCAMOS Y LO MOSTRAMOS POR CONSOLA
		
		Cuenta titular = gestion.buscarCuenta(entrada);
		if(titular == null) return;
		System.out.println("\n"+titular.mostrarDetalles());		
		
		// NOS ASEGURAMOS DE QUE DESEA ELIMINARLO Y DADO EL CADO LO ELIMINAOS
		
		System.out.println("\n¿Seguro que quieres eliminar a "+titular.getNombre()+" del sistema\n?"
				+"\n   Sí.- (s)"
				+"\n   No.- (n)");
		String eliminar = sc.nextLine();
		if(eliminar.equalsIgnoreCase("s")) {
			System.out.println("\n"+titular.mostrarDetalles()
				+"\nELIMINADO DEL SISTEMA");
			gestion.cuentas.remove(titular);
		}else System.out.println("\nAbortado. "+titular.getNombre()+" sigue en el sistema.");
		
	}
	
	public static void desactivarActivarCuenta(Scanner sc, GestionCuentas gestion) {

		// PEDIMOS EL TITULAR DEL QUE SE VA A MODIFICAR EL ESTADO DE ACTIVACIÓN 
		
		System.out.print("\nIntroduce el nombre o el DNI del titular que se va a activar o descactivar:");
		String entrada = sc.nextLine();
		
		// LO BUSCAMOS Y LO MOSTRAMOS POR CONSOLA
		
		Cuenta titular = gestion.buscarCuenta(entrada);
		if(titular == null) return;
		System.out.println("\n"+titular.mostrarDetalles());
		
		// PREGUNTAMOS QUÉ QUIERE HACER EN FUNCIÓN DE CÓMO SE ENCUENTRE LA ACTIVACIÓN DE LA CUENTA Y CAMBIAMOS EL ESTADO SI ES PRECISO
		
		if(titular.isActiva()) {
			System.out.println("\nActualmente esta cuenta se encuentra activada, ¿quieres desactivarla?\n"
					+"\n   Sí.- (s)"
					+"\n   No.- (n)");
			String desactivar = sc.nextLine();
			if(desactivar.equalsIgnoreCase("s")) {
				titular.setActiva(false);
				System.out.println("\nLa cuenta he sido desactivada correctemnte.");
			}else System.out.println("\nLa cuenta permanecerá activada.");
		}else {
			System.out.println("\nActualmente esta cuenta se encuentra desactivada, ¿quieres activarla?\n"
					+"\n   Sí.- (s)"
					+"\n   No.- (n)");
			String activar = sc.nextLine();
			if(activar.equalsIgnoreCase("s")) {
				titular.setActiva(true);
				System.out.println("\nLa cuenta ha sido activada correctemnte.");
			}else System.out.println("\nLa cuenta permanecerá desactivada.");
		}
		
	}
	
	public static void modificarCuenta(Scanner sc, GestionCuentas gestion) {
		
		// PEDIMOS EL TITULAR DEL QUE SE VA A MODIFICAR LA CUENTA 
		
		System.out.print("\nIntroduce el nombre o el DNI del titular que realizará la transferencia:");
		String entrada = sc.nextLine();
		
		// LO BUSCAMOS Y LO MOSTRAMOS POR CONSOLA
		
		Cuenta titular = gestion.buscarCuenta(entrada);
		if(titular == null) return;
		System.out.println("\n"+titular.mostrarDetalles());
		
		// PREGUNTAMOS LOS VALORES A CAMBIAR 
		
		System.out.println("\nIngresa los nuevos valores o deja en blando para mantener: \n");
		
		System.out.print("\nNombre alcual: "+titular.getNombre()+"\nNuevo nombre :");
		String nombre = sc.nextLine();	
		if(!nombre.isBlank()) titular.setNombre(nombre);
		
		System.out.print("\nPrimer apellido alcual: "+titular.getPrimerAp()+"\nNuevo primer apellido :");
		String ap1 = sc.nextLine();
		if(!ap1.isBlank()) titular.setPrimerAp(ap1);
		
		System.out.print("\nSegundo apellido alcual: "+titular.getSegundoAp()+"\nNuevo nombre :");
		String ap2 = sc.nextLine();
		if(!ap2.isBlank()) titular.setSegundoAp(ap2);
		
		System.out.print("\nDNI alcual: "+titular.getDni()+"\nNuevo DNI :");
		String dni = sc.nextLine();
		if(!dni.isBlank()) {
			if(!gestion.dniValido(dni)) {
				System.out.println("\nDNI erróneo. No se modificó el DNI.");
			}else if(!gestion.dniUnico(dni)) {
				System.out.println("\nYa exista una cuenta con este DNI. No se modificó el DNI.");				
			}else titular.setDni(dni);
		}
		System.out.print("\nTeléfono alcual: "+titular.getTlf()+"\nNuevo teléfono :");
		String entradaTlf = sc.nextLine();
		if(!entradaTlf.isBlank()) {
			try {
				int tlf = Integer.parseInt(entradaTlf);
				titular.setTlf(tlf);
			}catch(NumberFormatException e) {
				System.out.println("\nEntrada no válida. No se modificó el teléfono.");
			}
		}
		/*System.out.println("\nSaldo alcual: "+titular.getDinero()+"\nNuevo saldo :");
		double saldo = sc.nextDouble();
		sc.nextLine(); // limpiar buffer
		if(saldo != 0) titular.setDinero(saldo);*/
		
		System.out.println("\nTitular modificado: \n"+titular.mostrarDetalles());
		
	}
	
	public static void transferencia(Scanner sc, GestionCuentas gestion) {
		
		// PEDIMOS EL TITULAR QUE VA A REALIZAR LA TRANSFERENCIA
		
		System.out.print("\nIntroduce el nombre o el DNI del titular que realizará la transferencia:");
		String entrada = sc.nextLine();
		Cuenta titularEnvia = gestion.buscarCuenta(entrada);
		if(titularEnvia ==null) return;
		if(!titularEnvia.isActiva()) {
			System.out.println("\nLa cuenta debe esta activada.");
			return;
		}
		
		// PEDIMOS EL TITULAR QUE VA A RECIBIR LA TRANSFERENCIA
		
		System.out.print("\nIntroduce el nombre o el DNI del titular que recibirá la transferencia:");
		String entrada_2 = sc.nextLine();
		Cuenta titularRecibe = gestion.buscarCuenta(entrada_2);
		if(titularRecibe ==null) return;
		if(!titularRecibe.isActiva()) {
			System.out.println("\nLa cuenta del titular que va a recibir la transferencia debe esta activada.");
			return;
		}
		
		// COMPROBAMOS QUE NO SE ESTÉ ENVIANDO DINERO A SÍ MISMO
		
		if(titularEnvia.equals(titularRecibe)) {
			System.out.println("\nLas cuentas han de ser diferentes.");
			return;
		}
		
		// PEDIMOS LA CANTIDAD QUE VA A SER TRANSFERIDA Y COMPROBAMOS QUE TENGA FONDOS SUFICIENTES
		
		System.out.print("\nIndica la cantida que va a ser transferida");
		double cantidad = sc.nextDouble();
		sc.nextLine(); // limpiar buffer
		if(cantidad <= 0) {
			System.out.println("\nLa cantidad debe ser mayor que 0.");
	        return;
		}
		if(cantidad > titularEnvia.getDinero()) {
			System.out.println("\nLa cantidad supera el saldo disponible.");
	        return;
		}
		
		// REALIZAMOS LA TRANSFERENCIA Y MOSTRAMOS RESUMEN POR CONSOLA
		
		titularEnvia.setDinero(titularEnvia.getDinero()-cantidad);
		titularRecibe.setDinero(titularRecibe.getDinero()+cantidad);
		
		System.out.println("\nTransferencia realizada: \n"
				+"\n   "+titularEnvia.mostrarDetalles()
				+"\n   "+titularRecibe.mostrarDetalles());	
		
	}
	
	public static void ingresar(Scanner sc, GestionCuentas gestion) { 
		
		// PEDIMOS DATOS DEL TITULAR QUE VA A REALIZAR EL INGRESO
		
		System.out.print("\nIntroduce el nombre o el DNI del titular de la cuenta que va a ingresar dinero:");
		String entrada = sc.nextLine();
		Cuenta titular = gestion.buscarCuenta(entrada); // Lo buscamos con gestion.buscarCuenta(String entrada); de la clase GestionCuentas
		if(titular == null) return;
		
		// PREGUNTAMOS LA CANTIDAD A INGRESAR
		
		System.out.print("\nIndica la cantida que va a ser ingresada");
		double cantidad = sc.nextDouble();
		sc.nextLine(); // limpiar buffer
		if(cantidad <= 0) {
			System.out.println("\nLa cantidad debe ser mayor que 0.");
	        return;
		}
		
		// REALIZAMOS EL INGRESO
		
		if(titular.isActiva()) { // Comprobamos que la cuenta esté activa
			gestion.setIngresar(titular, cantidad); // Ingresamos con gestion.setIngresar(Cuenta cuenta, double cantidad); de la clase GestionCuentas
		}else System.out.println("\nLa cuenta debe estar activa para realizar el ingreso.");
	}
	
	public static void retirar(Scanner sc, GestionCuentas gestion) {
		
		// PEDIMOS DATOS DEL TITULAR QUE VA A REALIZAR LA RETIRADA
		
		System.out.print("\nIntroduce el nombre o el DNI del titular de la cuenta que va a retirar dinero:");
		String entrada = sc.nextLine();
		Cuenta titular = gestion.buscarCuenta(entrada); // Lo buscamos con gestion.buscarCuenta(String entrada); de la clase GestionCuentas
		if(titular == null) return;
		
		// PREGUNTAMOS LA CANTIDAD A RETIRAR
		
		System.out.print("\nIndica la cantida que va a ser retirada");
		double cantidad = sc.nextDouble();
		sc.nextLine(); // limpiar buffer
		if(cantidad <= 0) {
			System.out.println("\nLa cantidad debe ser mayor que 0.");
	        return;
		}
		if(titular.isActiva()) { // Comprobamos que la cuenta esté activa
			gestion.setRetirar(titular, cantidad); // Retiramos con gestion.setIngresar(Cuenta cuenta, double cantidad); de la clase GestionCuentas
		}else System.out.println("\nLa cuenta debe estar activa para realizar el ingreso.");
		
		// COMENTARIO DEL MÉTODO ANTERIOR:
		
		/*ArrayList<Cuenta> titularesCoincidentes = new ArrayList<>();
		Cuenta titular = null;
		System.out.print("\nIntroduce el nombre o el DNI del titular de la cuenta que va a retirar dinero:");
		String entrada = sc.nextLine();
		if(gestion.dniValido(entrada)) {
			if(!gestion.dniUnico(entrada)) { // hay redundancia. Este paso se podría obviar ya en la siguiente línea recorro las cuentas.
				for(Cuenta a : gestion.cuentas) {
					if(a.getDni().equalsIgnoreCase(entrada)) {
						titular = a;
						break;
					}
				}
			}else { // Si es un DNI pero no está en el sistema: 
				System.out.println("\nNo existe ninguna cuenta con ese DNI.");
				return; // Pensar en meter todo esto en un do-while para no salir del método
			}
		}else { // Si no es un DNI buscamos por nombre:
			for(Cuenta a : gestion.cuentas) {
				if(a.getNombre().equalsIgnoreCase(entrada)) {
					titularesCoincidentes.add(a);
				}
			}
			
		}
		if(titularesCoincidentes.isEmpty()) {
			System.out.println("\nNo se encontró ninguna cuenta con ese nombre o el DNI introducido es incorrecto.");
            return;
		}
		if(titularesCoincidentes.size() == 1) {
			titular = titularesCoincidentes.get(0);
			System.out.println("\nTitular encontrado: "+titular.mostrarDetalles());
		}else if(titularesCoincidentes.size() > 1) {
			System.out.println("\nSe encontraron varias coincidencias con ese nombre: ");
			for(int i=0; i<titularesCoincidentes.size(); i++) {
				Cuenta a = titularesCoincidentes.get(i);
				System.out.println((i+1)+".- "+a.mostrarDetalles());
			}
			System.out.println("Selecciona el número del titular que va a realizar la retirada: ");
			int seleccion = sc.nextInt();
			sc.nextLine(); // limpiar buffer
			if(seleccion < 1 || seleccion > titularesCoincidentes.size()) {
				System.out.println("\nOpción inválida.");
				return;
			}
			titular = titularesCoincidentes.get(seleccion-1);
			System.out.println("\nTitular encontrado: "+titular.mostrarDetalles());
		}
		System.out.print("\nIndica la cantidad que va a ser retirada: ");
		double cantidad = sc.nextDouble();
		sc.nextLine(); // limpiar buffer
		if(cantidad <= 0) {
			System.out.println("\nLa cantida a de ser mayor que 0.");
			return;
		}
		if(titular.isActiva()) {
			gestion.setRetirar(titular, cantidad);
		}else System.out.println("\nLa cuenta debe de estar activa para poder realizar la retirada.");*/
	}
	
	public static void agregarCuenta(Scanner sc, GestionCuentas gestion) {
		
		String dni;
	    do {
	        System.out.print("\nIntroduce el DNI del titular de la cuenta: ");
	        dni = sc.nextLine();
	        if (!gestion.dniValido(dni)) {
	            System.out.println("\nDebes introducir un DNI válido.");
	            continue;
	        }
	        if (!gestion.dniUnico(dni)) {
	            System.out.println("\nYa existe una cuenta con este DNI: " + dni);
	            return; // Salir del método, no tiene sentido seguir
	        }
	        break; // El DNI es válido y único, salir del bucle
	    } while (true);		
		System.out.print("Introduce el nombre: ");
		String nombre = sc.nextLine();		
		System.out.print("Introduce el primer apellido: ");
		String apellido1 = sc.nextLine();		
		System.out.print("Introduce el segundo apellido: ");
		String apellido2 = sc.nextLine();		
		System.out.print("Introduce el teléfono: ");
		int tlf = sc.nextInt();
		sc.nextLine(); // limpiar buffer		
		System.out.print("Introduce el año de nacimiento: ");
		int anyoN = sc.nextInt();
		sc.nextLine(); // limpiar buffer		
		System.out.print("Introduce el mes de nacimiento: ");
		int mesN = sc.nextInt();
		sc.nextLine(); // limpiar buffer		
		System.out.print("Introduce el día de nacimiento: ");
		int diaN = sc.nextInt();
		sc.nextLine(); // limpiar buffer		
		System.out.print("Introduce el saldo con el que se va a abrir la cuenta: ");
		double saldo = sc.nextDouble();
		sc.nextLine(); // limpiar buffer		
		Cuenta nuevaCuenta = new Cuenta(dni, nombre, apellido1, apellido2, tlf, anyoN, mesN, diaN, saldo);
		gestion.agregarCuenta(nuevaCuenta); // Este método comprueba que no haya otra cuenta con el mismo DNI		
	}
	
}
