package ejercicio1;

public class Validador {
	
	public void validarTren(Tren tren) throws TrenInvalidoExcepction {
		if (tren.getNumVagones() < 0) {
			throw new TrenInvalidoExcepction("el tren no puede tener menos de 0 vagones.");
		}
	}

}
