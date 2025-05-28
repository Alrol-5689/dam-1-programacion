package ejercicio16;

public class BarcoCarga extends Barco {
	
	private double capacidadPorBodega_KG;
	private int numBodegas;
	
	public BarcoCarga() {
		
	}
	
	public BarcoCarga(String nombre, double velocidadMaxima, double capacidadPorBodega_KG, int numBodegas) {
		super(nombre, velocidadMaxima);
		this.capacidadPorBodega_KG = capacidadPorBodega_KG;
		this.numBodegas = numBodegas;
	}
	
	

	@Override
	public double calcularCapacidad() {		
		return capacidadPorBodega_KG * numBodegas;		
	}

	@Override
	protected String mostrarInformacion() {
		return "ID: "+this.id+". Este barco de carga tiene una capacidad de "+calcularCapacidad()+" kilogramos.";
		
	}

	protected double getCapacidadPorBodega_KG() {
		return capacidadPorBodega_KG;
	}

	protected void setCapacidadPorBodega_KG(double capacidadPorBodega_KG) {
		this.capacidadPorBodega_KG = capacidadPorBodega_KG;
	}

	protected int getNumBodegas() {
		return numBodegas;
	}

	protected void setNumBodegas(int numBodegas) {
		this.numBodegas = numBodegas;
	}

}
