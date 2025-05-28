package box;

import java.util.*;

public class GestionCuentas {
	
	// ATRIBUTOS
	
	protected ArrayList<Cuenta> cuentas;
	
	// CONSTRUCTORES
	
	public GestionCuentas() {
		this.cuentas = new ArrayList<>();
	}
	
	// MÉTODOS
	
	public void agregarCuenta(Cuenta cuenta) { // Uso: gestion.agregarCuenta(cuenta); 
		if(!dniUnico(cuenta.getDni())) {
			System.out.println("\nYa existe una cuenta con este DNI: " + cuenta.getDni());
	        return;
		}
		cuentas.add(cuenta);
		System.out.println("\nCuenta creada y agregada al sistema: "+"\n " + cuenta.mostrarDetalles());
		System.out.println("\nLista de cuentas existentes:");
		for (Cuenta c : cuentas) {
	        System.out.println(c.mostrarDetalles());
	    }
	}
	
	public void setIngresar(String dni, double cantidad) {
	    for (Cuenta a : cuentas) {
	        if (a.getDni().equalsIgnoreCase(dni)) {
	            double saldoActual = a.getDinero();
	            a.setDinero(saldoActual + cantidad); // Actualizar el saldo
	            System.out.println(cantidad + "€ se añadieron a la cuenta: " + a.mostrarDetalles());
	            return;
	        }
	    }
	    System.out.println("No se encontró ninguna cuenta con el DNI: " + dni);
	}
	
	public void setIngresar(Cuenta cuenta, double cantidad) {
		double saldoActual = cuenta.getDinero();
		cuenta.setDinero(saldoActual+cantidad);
		System.out.println(cantidad + "€ se añadieron a la cuenta: " + cuenta.mostrarDetalles());
	}
	
	public void setRetirar(String dni, double cantidad) {
	    for(Cuenta a : cuentas) {
	    	if(a.getDni().equalsIgnoreCase(dni)) {
	    		if(a.getDinero()<cantidad) {
	    			System.out.println("Actualmente no dispones de esta cantidad."
	    					+"\nSaldo actual: "+a.getDinero()+"€.");
	    		}else {
	    			double saldoActual = a.getDinero();
	    			a.setDinero(saldoActual-cantidad);
	    			System.out.println("Has retirado " + cantidad + "€. "
	    					+ "\nSaldo actual: " + a.getDinero()+"€.");
	    		}
	    	}
	    }
	}
	
	public void setRetirar(Cuenta cuenta, double cantidad) {
		if(cuenta.getDinero()<cantidad) {
			System.out.println("Actualmente no dispones de esta cantidad."
					+"\nSaldo actual: "+cuenta.getDinero()+"€.");
		}else {
			double saldoActual = cuenta.getDinero();
			cuenta.setDinero(saldoActual-cantidad);
			System.out.println("Has retirado " + cantidad + "€. "
					+ "\nSaldo actual: " + cuenta.getDinero()+"€.");
		}
	}
	
	public boolean dniValido(String dni) {
		return dni.matches("\\d{8}[A-Za-z]");
	}
	
	public boolean dniUnico(String dni) {
		for(Cuenta a: cuentas) {
			if(a.getDni().equalsIgnoreCase(dni)) {
				return false;
			}
		}
		return true;
	}
	
	public void mostrarCuentas() {
		for(Cuenta a: cuentas) {
			System.out.println(a.mostrarDetalles());
		}
	}
	public Cuenta buscarCuenta(String entrada) {
		ArrayList<Cuenta> coincidencias = new ArrayList<>();
		if(dniValido(entrada)) {
			for(Cuenta a : cuentas) {
				if(a.getDni().equalsIgnoreCase(entrada)) {
					return a;
				}
			}
			System.out.println("\nNo existe ninguna cuenta con este DNI.");
			return null;
		}
		for(Cuenta a : cuentas) {
			if(a.getNombre().equalsIgnoreCase(entrada)) {
				coincidencias.add(a);
			}
		}
		if(coincidencias.isEmpty()) {
			System.out.println("\nNo se encontró ninguna cuenta con ese nombre o has introducido un DNI incorrecto.");
			return null;
		}
		if(coincidencias.size() == 1) {
			return coincidencias.get(0);
		}
		System.out.println("\nSe encontraron varias coincidencias con ese nombre: ");
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<coincidencias.size(); i++) {
			System.out.println((i+1)+coincidencias.get(i).mostrarDetalles());
		}
		int seleccion;
		do {
	        System.out.print("\nSelecciona el número de la cuenta correcta (del 1 al: "+coincidencias.size() + 1+"): ");
	        while (!sc.hasNextInt()) {
	            System.out.println("Por favor, introduce un número válido.");
	            sc.next(); // Consumir la entrada inválida para evitar un bucle infinito
	        }
	        seleccion = sc.nextInt();
	        sc.nextLine(); // Limpiar buffer			
		}while(seleccion < 1 || seleccion > coincidencias.size());
		return coincidencias.get(seleccion-1);	
	}
}
