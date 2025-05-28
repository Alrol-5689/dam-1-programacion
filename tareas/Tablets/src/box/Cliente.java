package box;

import java.util.*;

public class Cliente {

	// ATRIBUTOS
	
	protected boolean alta; // No tiene ninguna función por el momento, pero permite futuras posibles mejoras.
	protected String dni, nombre, apellido_1, apellido_2;
	protected int idCliente, telefono;
	protected Date fechaAlta;
	protected final boolean ALTA = true; // Por si en un futuro no quiero crearlos activados de forma predeterminada
	
	protected static int idSiguiente;
	protected static Cliente clienteX = new Cliente(); // para guardar valores de un cliente entre métodos
	

	
	// CONSTRUCTORES
	
	public Cliente() {this.alta = this.ALTA;} // "vacío" con activación automática
	
	public Cliente(boolean activado) {this.alta = activado;}

	public Cliente(String dni, String nombre, String apellido_1, String apellido_2, int telefono) { 
		// (activación autoática)
		this.dni = dni;
		this.nombre = nombre;
		this.apellido_1 = apellido_1;
		this.apellido_2 = apellido_2;
		this.telefono = telefono;
		this.alta = this.ALTA;
		this.fechaAlta = new Date(); // si usamos el constructor vacío, acordarnos de meter la fecha de alta
		this.idCliente=++idSiguiente;
	}
	
	public Cliente(String dni, String nombre, String apellido_1, String apellido_2, int telefono, boolean activado) { 
		// (se puede crear desactivado)
		this.dni = dni;
		this.nombre = nombre;
		this.apellido_1 = apellido_1;
		this.apellido_2 = apellido_2;
		this.telefono = telefono;
		this.fechaAlta = new Date(); // si usamos el constructor vacío, acordarnos de meter la fecha de alta
		this.alta = activado;
		this.idCliente=++idSiguiente;
	}
	
	// MÉTODOS GETTERS & SETTERS

	@Override
	public String toString() {
		return "Cliente: id "+idCliente+". "+nombre+" "+apellido_1+" "+apellido_2+" | Tlf: "+telefono+" | DNI: "+dni+" | Cuenta activa: "+alta;
	}
	
	protected static void restarIdSiguiente() {if(idSiguiente > 1) idSiguiente--;}

	protected boolean isActivado() {return alta;}

	protected void setActivado(boolean activado) {this.alta = activado;}

	protected String getDni() {return dni;}

	protected void setDni(String dni) {this.dni = dni;}

	protected String getNombre() {return nombre;}

	protected void setNombre(String nombre) {this.nombre = nombre;}

	protected String getApellido_1() {return apellido_1;}

	protected void setApellido_1(String apellido_1) {this.apellido_1 = apellido_1;}

	protected String getApellido_2() {return apellido_2;}

	protected void setApellido_2(String apellido_2) {this.apellido_2 = apellido_2;}

	protected int getIdCliente() {return idCliente;}

	protected void setIdCliente(int id) {this.idCliente = id;}

	protected int getTelefono() {return telefono;}

	protected void setTelefono(int telefono) {this.telefono = telefono;}

	protected Date getFechaAlta() {return fechaAlta;}

	protected void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}
