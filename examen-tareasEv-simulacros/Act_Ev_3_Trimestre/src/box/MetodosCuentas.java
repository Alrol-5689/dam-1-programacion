package box;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import Excepciones.CorreoInvalidoException;
import Excepciones.CorreoUsadoException;
import Excepciones.DniInvalidoException;
import Excepciones.DniUsadoException;
import Excepciones.NikUsadoException;
import Excepciones.PinInvalidoException;
import Excepciones.TelefonoInvalidoException;
import Excepciones.TelefonoUsadoException;

public class MetodosCuentas {
	
	protected Path rutaCuentas = Paths.get("examen-tareasEv-simulacros", "Act_Ev_3_Trimestre", "cuentas.txt");
	
	protected ArrayList<CuentaUsuario> cargarCuentasDesdeArchivo() {
		
	    ArrayList<CuentaUsuario> cuentas = new ArrayList<>();
	    var mayorId = 0;
	    try (BufferedReader reader = Files.newBufferedReader(rutaCuentas)) {
	        String linea;
	        while ((linea = reader.readLine()) != null) {
	            String[] partes = linea.split(";");
	            if (partes.length >= 9) {
	            	var tipo = partes[0];
	                var nik = partes[1];
	                var nombre = partes[2];
	                var email = partes[3];
	                var dni = partes[4];
	                var fechaNacimiento = LocalDate.parse(partes[5]);
	                var telefono = Integer.parseInt(partes[6]);
	                var pin = (partes[7]);
	                var id = Integer.parseInt(partes[8]);

	                CuentaUsuario cuenta;
	                if (tipo.equalsIgnoreCase("premium")) {
	                    cuenta = new CuentaPremium(nik, nombre, email, dni, fechaNacimiento, telefono);
	                } else {
	                    cuenta = new CuentaBasica(nik, nombre, email, dni, fechaNacimiento, telefono);
	                }
	                // Tenemos que meter manualmente los atributos que no están en el constructor
	                cuenta.setPin(pin);
	                cuenta.setId(id);
	                cuentas.add(cuenta);
	                // nos quedamos con el id del útimo usuario y seteamos idSigueinte para no perder el orden
	                if (id > mayorId) {
	                    mayorId = id;
	                }
	            }
	        }
	        // Actualizamos el idSiguiente estático
	        CuentaUsuario.setIdSiguiente(mayorId);
	    } catch (IOException e) {
	        System.out.println("Error al cargar las cuentas: " + e.getMessage());
	    }
	    return cuentas;



	}
	

	protected void guardarCuentasEnArchivo(ArrayList<CuentaUsuario> cuentas) {
		
	    try (BufferedWriter writer = Files.newBufferedWriter(rutaCuentas)) {
	        for (CuentaUsuario c : cuentas) {
	            writer.write(formatoCuenta(c));
	            writer.newLine();
	        }
	    } catch (IOException e) {
	        System.out.println("Error al guardar las cuentas: " + e.getMessage());
	    }
	    
	}
	
	protected String formatoCuenta(CuentaUsuario c) {
		
	    String tipo = (c instanceof CuentaPremium) ? "premium" : "basica";
	    return tipo + ";" + c.getNik() + ";" + c.getNombre() + ";" + c.getEmail() + ";" +
	           c.getDni() + ";" + c.getFecha_nacimiento() + ";" + c.getTelefono() + ";" + c.getPin() + ";" + c.getId();
	    
	}
	
	protected void editarPerfil(CuentaUsuario usuario, ArrayList<CuentaUsuario> cuentas, Lectura l, Scanner sc, Validador v) {
		
		System.out.println("\n------------------------------------------------------------------------------\n");
		System.out.println("Introduce los nuevos campos o deja en blanco los que no quieras cambiar.");
		String nuevoNik = l.pedirString(sc, true, "Nik: ");
		while(true) {
			if(nuevoNik == null || nuevoNik.isBlank()) {
				nuevoNik = null;
				break;
			}
			try {
				v.nikUnico(cuentas, nuevoNik);
				break;
			}catch(NikUsadoException e) {
				System.out.println("Error: "+e.getMessage());
				System.out.println();
				nuevoNik = l.pedirString(sc, true, "Pulsa intro para mantener '"+usuario.getNik()+"' o introduce el nuevo nik: ");
			}
		}
		String nuevoCorreo = l.pedirString(sc, true, "Correo electrónico: ");
		while(true) {
			if(nuevoCorreo == null || nuevoCorreo.isBlank()) {
				nuevoCorreo = null;
				break;
			}
			try {
				v.validarCorreo(nuevoCorreo);
				v.correoUnico(cuentas, nuevoCorreo);
				break;
			}catch(CorreoInvalidoException | CorreoUsadoException e) {
				System.out.println("Error: "+e.getMessage());
				System.out.println();
				nuevoCorreo = l.pedirString(sc, true, "Pulsa intro para mantener '"+usuario.getEmail()+"' o introduce el nuevo correo: ");
			}
		}
		int nuevoTel = 0;
		String input = l.pedirString(sc, true, "Teléfono: ");
		while(true) {
			if(input == null || input.isBlank()) {
				input = null;
				break;
			}
			try {
				nuevoTel = Integer.parseInt(input);
				v.validarTelefono(nuevoTel);
				v.tlfUnico(cuentas, nuevoTel);
				break;
			}catch(NumberFormatException | TelefonoInvalidoException | TelefonoUsadoException e) {
				System.out.println("Error: "+e.getMessage());
				System.out.println();
				nuevoTel = 0;
				input = l.pedirString(sc, true, "Pulsa intro para mantener '"+usuario.getTelefono()+"' o introduce el nuevo teléfono: ");
			}
		}
		System.out.println("\nResumen: \n");
		System.out.println(nuevoNik == null ? "Nik sin cambios: " +usuario.getNik() : "Nuevo nik: "+nuevoNik);
		System.out.println(nuevoCorreo == null ? "Email sin cambios: "+usuario.getEmail() : "Nuevo email: "+nuevoCorreo);
		System.out.println(nuevoTel == 0 ? "Teléfono sin cambios: "+usuario.getTelefono()+"\n" : "Nuevo teléfono: "+nuevoTel+"\n");

		boolean confirmarEdicion = l.confirmacionSiNo(sc, "¿Procedemos con los cambios? ( 's' / 'n' ): ");
		
		if(confirmarEdicion) { // si es una cuenta básico el nik no cambiará
			usuario.actualizarPerfil(nuevoNik, nuevoCorreo, nuevoTel);	// Realizamos los cambios de prefil
		}else {			
			System.out.println("\nAbortamos la edición del perfil.\n");
			return;			
		}
		if(usuario instanceof CuentaBasica && nuevoNik != null) { // advertimos de que el nik en una cuenta básica no cambiará
			System.out.println("\nLas cuentas báscas no pueden cambiar de nik. Lo siento.\n");
			if(nuevoCorreo != null || nuevoTel != 0) {
				System.out.println("Resto de cambios realizados correctamente.");
				return;
			}
			return;
		}
		System.out.println("\nPerfil editado correctamente. \n");

	}
	
	protected void cambiarPin(CuentaUsuario usuario, ArrayList<CuentaUsuario> cuentas, Lectura l, Scanner sc, Validador v) {
		
		System.out.println("\n------------------------------------------------------------------------------\n");
		while(true) {
			String nuevoPin = l.pedirString(sc, false, "Introduce el nuevo PIN: ");
			try {
				v.validarPin(nuevoPin);
			}catch(PinInvalidoException e) {
				System.out.println("Error: "+e.getMessage());
				System.out.println();
				continue;
			}
			String match = l.pedirString(sc, false, "Vuelve a escribirlo: ");
			if(nuevoPin.equals(match)) {
				System.out.println("\nPIN modificado correctamente");
				usuario.setPin(nuevoPin);
				break;
			}else {
				System.out.println("No hay coincidencia.");
				boolean tryAgain = l.confirmacionSiNo(sc, "¿Quieres intentarlo de nuevo? ( 's' / 'n' ): ");
				if(tryAgain) {
					continue;
				}else {
					System.out.println("Abortamos el cambio de PIN.");
					return;
				}
			}
		}
				
	}

	protected boolean eliminarCuenta(ArrayList<CuentaUsuario> cuentas, CuentaUsuario usuario, ArrayList<Publicacion> publicaciones, Scanner sc, Lectura l) {
		
		System.out.println("\n------------------------------------------------------------------------------\n");
	    boolean confirmacion = l.confirmacionSiNo(sc, "¿Seguro que quieres eliminar tu cuenta de manera permanente? ( 's' / 'n' ): ");
	    if (!confirmacion) {
	        System.out.println("\nOperación cancelada.");
	        return false;
	    } 
	    publicaciones.removeIf(p -> p.getAutor().equals(usuario)); // Eliminar todas sus publicaciones del sistema    
	    cuentas.remove(usuario); // Eliminar usuario de la lista
	    System.out.println("\nCuenta eliminada correctamente.");
	    return true; // si devuelve true en gestión cerramos sesion
	    
	}
	
	protected void nuevaCuenta(ArrayList<CuentaUsuario> cuentas, Scanner sc, Lectura l, Validador v) {
		
		System.out.println("\n------------------------------------------------------------------------------\n");

		String nombre = l.pedirString(sc, false, "Nombre: ");
		String nik = l.pedirString(sc, false, "Nik: ");
		while(true) {
			try {
				v.nikUnico(cuentas, nik);
				break;
			}catch(NikUsadoException e) {
				System.out.println("Error: "+e.getMessage());
				System.out.println();
				nik = l.pedirString(sc, false, "Introduce de nuevo el nik: ");
			}
		}		
		String correo = l.pedirString(sc, false, "Email: ");		
		while(true) {
			try {
				v.validarCorreo(correo);
				v.correoUnico(cuentas, correo);
				break;
			}catch(CorreoInvalidoException | CorreoUsadoException e) {
				System.out.println("Error: "+e.getMessage());
				System.out.println();
				correo = l.pedirString(sc, false, "Introduce de nuevo del correo: ");
			}
		}		
		String dni = l.pedirString(sc, false, "DNI: ");
		while(true) {
			try {
				v.validarDni(dni);
				v.dniUnico(cuentas, dni);
				break;
			} catch (DniUsadoException | DniInvalidoException e) {
			    System.out.println("Error: " + e.getMessage());
			    System.out.println();
			    dni = l.pedirString(sc, false, "Introduce el DNI de nuevo: ");
			}
		}		
		int telefono = l.pedirInt(sc, "Teléfono: ");
		while(true) {
			try {
				v.validarTelefono(telefono);
				v.tlfUnico(cuentas, telefono);
				break;
			}catch(TelefonoInvalidoException | TelefonoUsadoException e) {
				System.out.println("Error: " + e.getMessage());
				System.out.println();
				telefono = l.pedirInt(sc, "Introduce el teléfono: ");
			}
		}		
		LocalDate fechaNacimiento = l.pedirFecha(sc, "Introduce tu fecha de nacimiento: ");
		boolean premium = l.confirmacionSiNo(sc, "\n¿Se trata de una cuenta PREMIUM? ( 's' / 'n' ): ");		
		System.out.println("\nResumen:\n");
		System.out.println("Nombre: "+nombre+", nik: "+nik+", email: "+correo+", DNI: "+dni+", Teléfono: "+telefono+", "
				+ "Fecha de nacimiento: "+fechaNacimiento+", Premium: "+premium);	
		if(!l.confirmacionSiNo(sc, "\n¿Son correctos todos los campos? ( 's' / 'n'): ")) {
			System.out.println("\nAbortamos el alta de la nueva cuenta.");
			return;
		}		
		CuentaUsuario nuevaCuenta;		
		if(premium) {
			nuevaCuenta = new CuentaPremium(nik, nombre, correo, dni, fechaNacimiento, telefono);
		}else nuevaCuenta = new CuentaBasica(nik, nombre, correo, dni, fechaNacimiento, telefono);
		cuentas.add(nuevaCuenta);
		System.out.println("\n"+nuevaCuenta+". "+nuevaCuenta.mostrarInformacion());
		System.out.println("\nCuenta creada con éxito.");

	}

}
