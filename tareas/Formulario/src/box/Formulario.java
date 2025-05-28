package box;

import java.util.Scanner;

public class Formulario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion = 0;
		boolean nombreOk = false, apellidosOk = false, dniOk = false, emailOk = false;
		String nombre;
		String apellidos;
		String dni;
		String email;
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.println("1.- Rellenar nombre.");
			System.out.println("2.- Rellenar apellidos.");
			System.out.println("3.- Rellenar DNI.");
			System.out.println("4.- Rellenar e-mail.");
			System.out.println("5.- Salir.");
			
			opcion = sc.nextInt();
			sc.nextLine(); // limpiar buffer
			
			switch(opcion) {
				case 1: 
					System.out.print("Introduce el nombre: ");
					while(!nombreOk) {			
						nombre = sc.next();
						if(!nombre.isBlank()) {
							nombreOk = true;
						}else System.out.print("Por favor introduce un nombre válido: ");
					}				
					break;
				case 2:
					System.out.print("Introduce el apellidos: ");
					while(!apellidosOk) {
						apellidos = sc.next();
						if(!apellidos.isBlank()) {
							apellidosOk = true;
						}else System.out.print("Por favor introduce apellidos válidos: ");
					}
					break;
				case 3:
					System.out.print("Introduce el DNI: ");
					while(!dniOk) {
						dni = sc.next();
						if(!dni.isBlank()) {
							dniOk = true;
						}else System.out.print("Por favor introduce apellidos válidos: ");
					}
					break;
				case 4:
					System.out.print("Introduce el email: ");
					while(!emailOk) {
						email = sc.next();
						if(!email.isBlank()) {
							emailOk = true;
						}else System.out.print("Por favor introduce apellidos válidos: ");
					}
					break;
				case 5:
					if(!nombreOk || !apellidosOk || !dniOk || !emailOk) {
						System.out.println("Para salir primero has de cumplimentar el formulario.");
						System.out.println("Datos que faltan por rellenar:");
						if(!nombreOk) System.out.println("Nombre.");
						if(!apellidosOk) System.out.println("Apellidos.");
						if(!dniOk) System.out.println("DNI.");
						if(!emailOk) System.out.println("email.");
						opcion = 0;
					}else System.out.println("Hasta la próxima.");
				default:
			}
			
			
			
		}while(opcion != 5);

	}

}
