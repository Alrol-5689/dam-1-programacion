package ejercicio1;

public abstract class Tren implements Capacidad {
	
	protected String nombre;
	protected int id, velocidadMax; 
	protected int numVagones;
	
	public Tren(int id, String nombre, int velocidadMax, int numVagones) {
		this.id = id;
		this.nombre = nombre;
		this.numVagones = numVagones;
		this.velocidadMax = velocidadMax;
	}
	
	public abstract String mostrarInformacion();

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected int getVelocidadMax() {
		return velocidadMax;
	}

	protected void setVelocidadMax(int velocidadMax) {
		this.velocidadMax = velocidadMax;
	}

	public int getNumVagones() {
		return numVagones;
	}

	public void setNumVagones(int numVagones) {
		this.numVagones = numVagones;
	}
}
