package box;

public class Coche_Usado extends Coche {
	
	// ATRIBUTOS
	
	protected double km;
	protected final double KM_POR_DEFECTO = 1000;
	
	// CONSTRUCTORES
	
	protected Coche_Usado(String matricula) {
		super(matricula);
		this.km = KM_POR_DEFECTO;
	}
	
	protected Coche_Usado(String matricula, double kilometros) {
		super(matricula);
		if(kilometros == 0) {
			this.km = KM_POR_DEFECTO;
		}else this.km = kilometros;
	}
	
	protected Coche_Usado(String matricula, String marca, String modelo, String color, int anyo, double kilometros) {
		super(matricula, marca, modelo, color, anyo);
		if(kilometros == 0) {
			this.km = KM_POR_DEFECTO;
		}else this.km = kilometros;
	}
	
	// MÉTODOS
	
	@Override
	public String toString() {
		return super.toString() + " || Coche usado [km=" + km + "]";
	}
	

	protected double getKm() {
		return km;
	}

	protected void setKm(double km) {
		this.km = km;
	}

}
