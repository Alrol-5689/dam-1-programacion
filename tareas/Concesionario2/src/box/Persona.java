package box;

public abstract class Persona {
	
	// ATRIBUTOS
	
	protected int anyoNacimiento, tlf, id;
	protected String nombre, apellidos, dni;
	
	protected static int idSiguiente;
	
	// CONTRUCTOR
	
	protected Persona(String dni) {
		this.dni = dni;
		this.id =++ idSiguiente;
	}
	
	protected Persona(String nombre, String apellidos, int anyoNacimiento, int tlf,  String dni) {
		this.anyoNacimiento = anyoNacimiento;
		this.tlf = tlf;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.id =++ idSiguiente;
	}
	
	// MÉTODOS
	
	@Override
	public String toString() {
		return nombre + " " + apellidos+" [ Nacimiento: " + anyoNacimiento + " ] [ Tlf: " + tlf + " ]" + " [ DNI: "+ dni + " ]";
	}

	protected int getAnyoNacimiento() {
		return anyoNacimiento;
	}

	protected void setAnyoNacimiento(int anyoNacimiento) {
		this.anyoNacimiento = anyoNacimiento;
	}

	protected int getTlf() {
		return tlf;
	}

	protected void setTlf(int tlf) {
		this.tlf = tlf;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}

	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
	
	
}
