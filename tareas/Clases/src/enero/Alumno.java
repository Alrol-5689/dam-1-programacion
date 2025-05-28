package enero;

public class Alumno {
	
	// ATRIBUTOS
	
	protected String dni, nombre, expediente, movil;
	protected double nota;
	protected boolean matriculado;
	
	public Alumno() {
	}

	public Alumno(String dni, String nombre, String expediente, String movil, double nota, boolean matriculado) {
		this.dni = dni;
		this.nombre = nombre;
		this.expediente = expediente;
		this.movil = movil;
		this.nota = nota;
		this.matriculado = matriculado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public boolean isMatriculado() {
		return matriculado;
	}

	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}
	
	Alumno a = new Alumno();
	
	

	
	

}
