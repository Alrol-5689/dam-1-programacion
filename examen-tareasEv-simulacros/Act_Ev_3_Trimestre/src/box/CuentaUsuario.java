package box;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class CuentaUsuario implements OperacionesCuenta {
	
	// Atributos
	
	private ArrayList<Publicacion> lista_publicaciones = new ArrayList<>();
	private String nik, nombre, email, dni, pin;
	private LocalDate fecha_nacimiento;
	private int telefono, id;
	
	private static int idSiguiente;
	
	// Constructores	

	public CuentaUsuario() {
	}

	public CuentaUsuario(String nik, String nombre, String email, String dni, LocalDate fecha_nacimiento, int telefono) {
		this.nik = nik;
		this.nombre = nombre;
		this.email = email;
		this.dni = dni;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.id =++ idSiguiente;
		this.pin = "1234";
		this.lista_publicaciones = new ArrayList<>();
	}
	
	// Métodos

	protected String getNik() {
		return nik;
	}

	protected void setNik(String nik) {
		this.nik = nik;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}

	protected String getPin() {
		return pin;
	}

	protected void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "ID: " +id+ ", nombre: " +nombre+ ", nik: " +nik+ ", DNI: " +dni+ ", email: " +email+ ", fecha de nacimiento: " +fecha_nacimiento
				+ ", telefono: " +telefono+ ", PIN: "+pin;

	}

	public abstract String mostrarInformacion();

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	protected void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	protected int getTelefono() {
		return telefono;
	}

	protected void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;		
	}
	protected ArrayList<Publicacion> getLista_publicaciones() {
		return lista_publicaciones;
	}

	protected void setLista_publicaciones(ArrayList<Publicacion> lista_publicaciones) {
		this.lista_publicaciones = lista_publicaciones;
	}

	protected static void setIdSiguiente(int id) {
		idSiguiente = id;
		
	}

	

	

}
