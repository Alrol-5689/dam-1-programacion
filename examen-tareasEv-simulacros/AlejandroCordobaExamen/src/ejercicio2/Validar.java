package ejercicio2;

public class Validar {
	
	public void validarDni_formato(String dni) throws DniInvalidoException {
		if (!dni.matches("\\d{8}[A-Za-z]")) {
			throw new DniInvalidoException("formato incorrecto.");
		}
	}

}
