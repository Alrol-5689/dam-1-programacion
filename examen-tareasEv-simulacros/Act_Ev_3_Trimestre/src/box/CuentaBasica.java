package box;

import java.time.LocalDate;
import java.util.ArrayList;

public class CuentaBasica extends CuentaUsuario {
	
	// Contructores
	
	public CuentaBasica() {
	}
	
	public CuentaBasica(String nik, String nombre, String email, String dni, LocalDate fecha_nacimiento, int telefono) {
		super(nik, nombre, email, dni, fecha_nacimiento, telefono);
	}
	
	// Métodos

	@Override
	public String mostrarInformacion() {
		return "Esta cuenta es básica.";
		
	}

	@Override
	public void actualizarPerfil(String nuevoNik, String nuevoCorreo, int nuevoTel) {

		if(nuevoCorreo != null) {
			this.setEmail(nuevoCorreo);
		}
		if(nuevoTel != 0) {
			this.setTelefono(nuevoTel);
		}
	}

	@Override // Al ser una cuenta básica tiene un límite de 5 publicaciones diarias.
	public boolean publicarMensaje(String mensaje, ArrayList<Publicacion> publicaciones) {
		
	    LocalDate hoy = LocalDate.now();
	    // Contar publicaciones del día actual
	    long publicacionesHoy = getLista_publicaciones().stream()
	        .filter(p -> p.getFecha().equals(hoy))
	        .count();

	    if (publicacionesHoy >= 5) {
	        System.out.println("Has alcanzado el límite de 5 publicaciones diarias con una cuenta básica.");
	        return false;
	    }
	    Publicacion nueva = new Publicacion(mensaje, hoy, this); // el id se autogenera y mete la publicacion en la lista del usuario
	    //getLista_publicaciones().add(nueva); el constructor de publicación mete la publicación en la lista del usuario también
	    publicaciones.add(nueva);
	    System.out.println("Publicación realizada con éxito.");
	    return true;
	}




}
