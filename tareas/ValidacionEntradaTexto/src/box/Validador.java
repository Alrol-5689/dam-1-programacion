package box;

public class Validador {
	
	protected Validador() {
	}
	
	protected void validarTxtBlank(String entrada) throws IsBlankException{
		if(entrada.isBlank()) {
			throw new IsBlankException("Cadena de txt en blanco.");
		}
	}
	
	protected void validarTxtEmpty(String entrada) throws IsEmptyException{
		if(entrada.isEmpty()) {
			throw new IsEmptyException("Cadena de txt vacía.");
		}
	}
	
	

}
