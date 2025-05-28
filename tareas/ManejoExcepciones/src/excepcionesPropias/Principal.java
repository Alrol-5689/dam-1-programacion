package excepcionesPropias;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		String telefono = "666101855";
		String correo = "usuario@correo";
		Validador v = new Validador();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("Ingrese su número de teléfono: ");
			telefono = sc.nextLine();
			try {
				v.validarTelefono(telefono);
				System.out.println("Teléfono válido: "+telefono);
				break;
			}catch(TelefonoInvalidoException e) {
				System.err.println("Error: "+e.getMessage());
			}
		}
		while(true) {
			System.out.print("Ingrese su correo electrónico: ");
			correo = sc.nextLine();
			try {
				v.validarCorreo(correo);
				System.out.println("Correo válido: "+correo);
				break;
			}catch(CorreoInvalidoException e) {
				System.err.println("Error: "+e.getMessage());
			}
		}

	}

}
