package box;

public class Coche_Nuevo extends Coche {
	
	protected static int unidades;

	protected Coche_Nuevo(String matricula) {
		super(matricula);
		unidades++;
	}
	
	protected Coche_Nuevo(String matricula, String marca, String modelo, String color, int anyo) {
		super(matricula, marca, modelo, color, anyo);
		unidades++;
	}

	// MÉTODOS
	
	protected static int getUnidades() {
		return unidades;
	}

	protected static void setUnidades(int unidades) {
		Coche_Nuevo.unidades = unidades;
	}
	
	protected static void sumarUnidades(int unidades) {
		Coche_Nuevo.unidades += unidades;
	}
	
	protected static void restarUnidades(int unidades) {
		Coche_Nuevo.unidades -= unidades;
	}

}
