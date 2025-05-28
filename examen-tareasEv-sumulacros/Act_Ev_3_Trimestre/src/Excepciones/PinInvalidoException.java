package Excepciones;

public class PinInvalidoException extends Exception{

	private static final long serialVersionUID = 1L;

	public PinInvalidoException(String mensaje) {
		super(mensaje);
	}

}
