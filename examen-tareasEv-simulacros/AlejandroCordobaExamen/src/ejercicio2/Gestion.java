package ejercicio2;

import java.util.Scanner;

public class Gestion {
	
	Validar v = new Validar();
	Scanner sc = new Scanner(System.in);
	
	protected void start() {
		
		boolean correcto = false;
		
		while(!correcto) {
			try {
				System.out.println("Introduce el DNI:");
				String dni = sc.nextLine();
				v.validarDni_formato(dni);
				correcto = true;
				System.out.println("Introducido correctamente.");
			}catch(DniInvalidoException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
		
		
	}

}
