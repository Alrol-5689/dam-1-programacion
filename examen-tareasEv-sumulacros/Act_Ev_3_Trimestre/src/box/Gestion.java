package box;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {
	
	protected Lectura l = new Lectura();
	protected MetodosCuentas c = new MetodosCuentas();
	protected MetodosPublicaciones p = new MetodosPublicaciones();
	protected Validador v = new Validador();
	
	protected CuentaUsuario cuentaActiva = null; // Para loguearte --> luego todos los cambios y publicaciones son sobre tu cuenta
	protected ArrayList<CuentaUsuario> cuentas = c.cargarCuentasDesdeArchivo(); // Al arrancar el programa mete en sus array las cuentas y las publicaciones desde los txt.
	protected ArrayList<Publicacion> publicaciones = p.cargarPublicacionesDesdeArchivo(cuentas);
	
	protected int opcion;
	protected Scanner sc = new Scanner(System.in);
	
	protected void Start() { // método principal del programa
		
		do {
			
			if(cuentaActiva == null) {
				opcion = l.menuSesion(sc); // 1.- Iniciar sesión. 2.- Crear cuenta. 3.- Salir
				c.guardarCuentasEnArchivo(cuentas); 
				p.guardarPublicacionesEnArchivo(publicaciones);
				switch (opcion) {			
					case 1: // Login. 
						if(cuentas.isEmpty()) {
							System.out.println("\nAún no hay ninguna cuenta creada.");
							continue;
						}else {
							cuentaActiva = iniciarSesion(cuentas, sc);
						}				
						break;
					case 2: // Despues de crear la cuenta tendremos que loguearnos... continue;
						c.nuevaCuenta(cuentas, sc, l, v);
						continue; // hemos creado la cuenta pero no estamos logueados. Volvemos para loguearnos
					case 3: // Salir. Cerramos sesión
						cuentaActiva = null;
						break;
					// default: l.menuSesion en Lectura se encarga de nunca meter otro número.
				}
			}
			if(cuentaActiva == null) { // Si hemos seleccionado salir
				opcion = 7;
			}else {
				opcion = l.menuPrincipal(sc);
				c.guardarCuentasEnArchivo(cuentas);
				p.guardarPublicacionesEnArchivo(publicaciones);
			}
						
			switch (opcion) {
			
				case 1: // PUBLICAR
					p.publicar(cuentaActiva, publicaciones, l, sc);
					break;
				case 2: // ELIMINAR PUBLICACIÓN
					p.eliminarPublicacion(cuentaActiva, publicaciones, l, sc);
					break;
				case 3: // ELIMINAR CUENTA
					boolean eliminada = c.eliminarCuenta(cuentas, cuentaActiva, publicaciones, sc, l);
					if(eliminada) cuentaActiva = null; // esto solo indica que cuentaActiva ya no referencia a ninguna cuenta (no elimina)				
					break;
				case 4: // EDITAR PERFIL ( NIK, CORREO, TELÉFONO )
					c.editarPerfil(cuentaActiva, cuentas, l, sc, v);
					break;
				case 5: // CAMBIAR PIN
					c.cambiarPin(cuentaActiva, cuentas, l, sc, v);
					break;
				case 6: // CERRAR SESIÓN
					c.guardarCuentasEnArchivo(cuentas);
					p.guardarPublicacionesEnArchivo(publicaciones);
					cuentaActiva = null;
					System.out.println("\nSesión cerrada.");
					break;
				case 7: // SALIR
					c.guardarCuentasEnArchivo(cuentas);
					p.guardarPublicacionesEnArchivo(publicaciones);
					System.out.println("\nHasta la próxima.");
					break;
					
				default: // l.menuPrincipal no admite números fuera del rango
			}
			
		}while(opcion != 7);
	}
	
	protected CuentaUsuario iniciarSesion(ArrayList<CuentaUsuario> listaCuentas, Scanner sc) {
		
		CuentaUsuario usuario = null;
		System.out.println("\n------------------------------------------------------------------------------\n");
		String dni = l.pedirString(sc, false, "Introduce tu DNI: ");		
		while(true) {			
			for(CuentaUsuario u : listaCuentas) {
				if(dni.equalsIgnoreCase(u.getDni())) {
					usuario = u;
					break;
				}
			}
			if(usuario == null) {
				System.out.println("Ninguna coincidencia.");
				int entrada = l.pedirOpcion(sc, 1, 2, "\nOpciones:\n" + """
						1.- Introducir de nuevo el DNI.
						2.- Salir.
						\nSelecciona una opcion: """ + " ");
				if(entrada == 1) {
					dni = l.pedirString(sc, false, "Introduce tu DNI de nuevo: ");
					continue;
				}else return null;
			}else break;
		}		
		String pin = l.pedirString(sc, false, "Introduce el pin: ");
		int intentos = 1;		
		while(true) {
			if(usuario.getPin().equals(pin)) {
				System.out.println("\nSesión iniciada correctamente.");
				return usuario;
			}else if(intentos < 3) {
				System.out.println("PIN incorrecto.");
				pin = l.pedirString(sc, false, "Introduce el PIN nuevamente: ");
				intentos++;
			}else {
				System.out.println("Has superado los intentos. No puedes iniciar sesión.");
				return null;
			}			
		}	
		
    }	
	
}
