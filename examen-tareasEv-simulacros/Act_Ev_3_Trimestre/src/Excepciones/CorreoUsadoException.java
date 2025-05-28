package Excepciones;

public class CorreoUsadoException extends Exception {

	private static final long serialVersionUID = 1L;

	public CorreoUsadoException(String mensaje) {
		super(mensaje);
	}

}
