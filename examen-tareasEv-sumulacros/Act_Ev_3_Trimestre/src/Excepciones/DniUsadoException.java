package Excepciones;

public class DniUsadoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public DniUsadoException(String mensaje) {
		super(mensaje);
	}
	
}
