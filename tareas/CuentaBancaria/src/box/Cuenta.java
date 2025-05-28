package box;

import java.util.Date;
import java.util.GregorianCalendar;

public class Cuenta {

	// ATRIBUTOS
	
	protected String nombre, primerAp, segundoAp, dni;
	protected double dinero;
	protected boolean activa; // false por defecto
	protected static int IdSiguiente; // static PARA QUE NO PERTENEZCA A LOS OBJETOS
	protected int id, tlf;
	protected Date fechaNacimiento;
	
	// CONSTRUCTORES DE UNA NUEVA CUENTA
	
	public Cuenta(String dni, String nombre, String primerAp, String segundoAp, int tlf, int anyoN, int mesN, int diaN, double dinero) {
		this.dinero=dinero;
		this.nombre=nombre;
		this.primerAp=primerAp;
		this.segundoAp=segundoAp;
		this.dni=dni;
		this.tlf=tlf;
		this.activa=true;
		GregorianCalendar x = new GregorianCalendar(anyoN, mesN-1, diaN);
		this.fechaNacimiento=x.getTime();
		this.id=++IdSiguiente;
	}
	public Cuenta(String dni) {
		this.dinero=0;
		this.dni=dni;
		this.activa=true;
		this.id=++IdSiguiente;
	}
	public Cuenta() {
		this.dinero=0;
		this.activa=true;
		this.id=++IdSiguiente;
	}
	
	// MÉTODOS:
	

	public String mostrarDetalles() {
		return "Id: " + id +", DNI: "+dni+ ", titular: " + nombre +" "+primerAp+ " "+segundoAp+", "+"Tlf: "+tlf+", saldo: "+dinero+"€.";
    }
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerAp() {
		return primerAp;
	}
	public void setPrimerAp(String primerAp) {
		this.primerAp = primerAp;
	}
	public String getSegundoAp() {
		return segundoAp;
	}
	public void setSegundoAp(String segundoAp) {
		this.segundoAp = segundoAp;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean alta) {
		this.activa = alta;
	}
	public int getTlf() {
		return tlf;
	}
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(int anyoN, int mesN, int diaN) {
		GregorianCalendar x = new GregorianCalendar(anyoN, mesN-1, diaN);
		this.fechaNacimiento = x.getTime();
	}
	
	
}
