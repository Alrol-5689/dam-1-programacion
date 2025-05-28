package box;

import java.util.Date;
import java.util.GregorianCalendar;

public class Mecanico extends Persona {
	
	// ATRIBUTOS
	
	protected Date fechaContrato;
	protected double salario;
	
	protected final double SALARIO_BASE = 1400;
	
	// CONSTRUCTORES
	
	protected Mecanico(String dni) {
		super(dni);
		this.salario = SALARIO_BASE;
	}
	
	protected Mecanico(String nombre, String apellidos, int anyoNacimiento, int tlf, String dni, int anyo, int mes, int dia, double salario) {
		super(nombre, apellidos, anyoNacimiento, tlf, dni);
		GregorianCalendar x = new GregorianCalendar(anyo, mes-1, dia);
		fechaContrato = x.getTime();
		if(salario < SALARIO_BASE) {
			this.salario = SALARIO_BASE;
		}else this.salario = salario;
		
	}

}
