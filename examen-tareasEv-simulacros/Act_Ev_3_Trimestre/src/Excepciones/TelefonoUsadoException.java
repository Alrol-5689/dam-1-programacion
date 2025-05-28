package Excepciones;

public class TelefonoUsadoException extends Exception {

	private static final long serialVersionUID = 1L;

	public TelefonoUsadoException(String mensaje) {
		super(mensaje);
	}

}