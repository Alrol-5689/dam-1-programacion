package ejercicio1;

public class TrenCarga extends Tren {
	
	private int capacidadPorVagon;
	
	public TrenCarga(int id, String nombre, int velocidadMax, int capacidaPorVagon, int numVagones) {
		super(id, nombre, velocidadMax, numVagones);
		this.capacidadPorVagon = capacidaPorVagon;
	}
	
	@Override
	public int calcularCapacidad() {
		// TODO Auto-generated method stub
		return capacidadPorVagon * numVagones;
	}

	@Override
	public String mostrarInformacion() {
		return nombre+" es un tren de carga con una capacidad de "+calcularCapacidad()+" kg.";
		
	}

	protected int getCapacidaPorVagon() {
		return capacidadPorVagon;
	}

	protected void setCapacidaPorVagon(int capacidaPorVagon) {
		this.capacidadPorVagon = capacidaPorVagon;
	}




		
}
