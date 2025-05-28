package ejercicio16;

public class BarcoPasajeros extends Barco {
	
	private int numCamarotes, pasajerosPorCamarote;
	
	public BarcoPasajeros() {
		
	}
	
	public BarcoPasajeros(String nombre, double velocidadMaxima, int numCamarotes, int pasajerosPorCamarote) {
		super(nombre, velocidadMaxima);
		this.numCamarotes = numCamarotes;
		this.pasajerosPorCamarote = pasajerosPorCamarote;
	}

	@Override
	public double calcularCapacidad() {
		return numCamarotes * pasajerosPorCamarote;
		
	}

	@Override
	protected String mostrarInformacion() {
		return "ID: "+this.id+". Este barco de pasajeros tiene capacidad para "+calcularCapacidad()+" personas.";
		
	}

	protected int getNumCamarotes() {
		return numCamarotes;
	}

	protected void setNumCamarotes(int numCamarotes) {
		this.numCamarotes = numCamarotes;
	}

	protected int getPasajerosPorCamarote() {
		return pasajerosPorCamarote;
	}

	protected void setPasajerosPorCamarote(int pasajerosPorCamarote) {
		this.pasajerosPorCamarote = pasajerosPorCamarote;
	}

}
