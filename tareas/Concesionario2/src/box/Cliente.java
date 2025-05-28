package box;

public class Cliente extends Persona {
	
	// ATRIBUTOS
	
	protected String direccion;
	
	// CONSTRUCTORES
	
	protected Cliente(String dni) {
		super(dni);
	}
	
	protected Cliente(String nombre, String apellidos, int anyoNacimiento, int tlf, String dni, String direccion) {
		super(nombre, apellidos, anyoNacimiento, tlf, dni);
		this.direccion = direccion;
	}
	
	// MÉTODOS
	
	
	
	protected String getDireccion() {
		return direccion;
	}


	@Override
	public String toString() {
		return super.toString() +"[ direccion: " + direccion + " ]";
	}

	protected void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

	
	
}
