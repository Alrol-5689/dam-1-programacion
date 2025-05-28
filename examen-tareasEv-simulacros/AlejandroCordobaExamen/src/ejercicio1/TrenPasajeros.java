package ejercicio1;

public class TrenPasajeros extends Tren {
	
	private int pasajerosPorVagon;

	public TrenPasajeros(int id, String nombre, int velocidadMax, int numVagones, int pasajerosPorVagon) {
		super(id, nombre, velocidadMax, numVagones);
		this.pasajerosPorVagon = pasajerosPorVagon;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calcularCapacidad() {
		
		return numVagones * pasajerosPorVagon;
	}

	@Override
	public String mostrarInformacion() {
		return nombre + " es un tren de pasajeros con una capacidad de " + calcularCapacidad()+ " personas.";
		
	}

	protected int getPasajerosPorVagon() {
		return pasajerosPorVagon;
	}

	protected void setPasajerosPorVagon(int pasajerosPorVagon) {
		this.pasajerosPorVagon = pasajerosPorVagon;
	}

}
