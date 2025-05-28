package box;

import java.util.ArrayList;

public interface OperacionesCuenta {
	
	public void actualizarPerfil(String nuevoNik, String nuevoCorreo, int nuevoTel);

	public boolean publicarMensaje(String publicacion, ArrayList<Publicacion> lista_Publicaciones);

}
