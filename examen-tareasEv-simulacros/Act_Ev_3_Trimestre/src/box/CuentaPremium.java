package box;

import java.time.LocalDate;
import java.util.ArrayList;

public class CuentaPremium extends CuentaUsuario {
	
	// Constructores
	
	public CuentaPremium() {
	}
	
	public CuentaPremium(String nik, String nombre, String email, String dni, LocalDate fecha_nacimiento, int telefono) {
		super(nik, nombre, email, dni, fecha_nacimiento, telefono);
	}
	
	// Métodos

	@Override
	public String mostrarInformacion() {
		return "Esta cuenta es premium.";
		
	}

	@Override // Solo las cuentas premium pueden actualizar el nik
	public void actualizarPerfil(String nuevoNik, String nuevoCorreo, int nuevoTel) {
		
		if(nuevoNik != null) {
			this.setNik(nuevoNik);
		}
		if(nuevoCorreo != null) {
			this.setEmail(nuevoCorreo);
		}
		if(nuevoTel != 0) {
			this.setTelefono(nuevoTel);
		}

	}

	@Override
	public boolean publicarMensaje(String publicacion, ArrayList<Publicacion> publicaciones) {
		
	    LocalDate hoy = LocalDate.now();
	    Publicacion nueva = new Publicacion(publicacion, hoy, this); // El constructor de Publicacion ya mete la publicación en la lista del usuario
	    //getLista_publicaciones().add(nueva); no hace falta porque ya se encarga el constructor de publicación
	    publicaciones.add(nueva); // metemos la publicación en publicaciones
	    System.out.println("Publicación realizada con éxito.");
	    return true;
	}


}
