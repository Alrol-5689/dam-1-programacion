package excepcionesPropias;

public class CorreoInvalidoException extends Exception { // a esto se le llama PROPAGAR	

	public CorreoInvalidoException(String mensaje) {
		super(mensaje);
	}

}
