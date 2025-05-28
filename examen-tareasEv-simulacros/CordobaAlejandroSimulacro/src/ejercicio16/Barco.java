package ejercicio16;

public abstract class Barco implements Capacidad {
	
	protected int id;
	private String nombre;
	private double velocidadMaxima;
	
	private static int idSiguiente;
	
	public Barco() {		
	}
	
	public Barco(String nombre, double velocidadMaxima) {
		this.setNombre(nombre);
		this.setVelocidadMaxima(velocidadMaxima);
		this.setId(++ idSiguiente);
	}
	
	protected abstract String mostrarInformacion();

	protected double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	protected void setVelocidadMaxima(double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

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

}
