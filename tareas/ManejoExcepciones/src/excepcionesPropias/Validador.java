package excepcionesPropias;

public class Validador {

	protected Validador() {
	}
	
	protected void validarTelefono(String telefono) throws TelefonoInvalidoException{
		if(!telefono.matches("\\d{10}")) {
			throw new TelefonoInvalidoException("Número de teléfono inválido: "+telefono);
		}
	}
	
	protected void validarCorreo(String correo) throws CorreoInvalidoException{
		if(!correo.matches("^[\\W.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$")) {
			throw new CorreoInvalidoException("Correo inválido: "+correo);
		}
	}

}
