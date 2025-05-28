package box;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Revistas {
	
	// ATRIBUTOS
	
	protected String periodico;
	protected Date diaRevista;
	private static int IdSiguiente; // static PARA QUE NO PERTENEZCA A LOS OBJETOS
	protected int id;
	
	// CONSTRUCTORES

	public Revistas(String periodico, int anyo, int mes, int dia) {
		this.periodico = periodico;
		GregorianCalendar diaRevista = new GregorianCalendar(anyo, mes-1, dia);
		this.diaRevista = diaRevista.getTime();
		this.id = ++IdSiguiente;
	}
	
	public Revistas() {
		this.id = ++IdSiguiente;
		
	}
	
	// MÉTODOS GETTERS Y SETTERS
	
	public String getMostrarDetalles() {
		return "Id: "+id+", periódico "+periodico+", fecha: "+diaRevista;
	}
	
	public static void mostrarRevistasDisponibles(ArrayList<Revistas> arrayRevistas, Scanner sc) {
		
		if(arrayRevistas.isEmpty()) {
			System.out.println("No hay ninguna revisa disponible.");
		}else {
			for(Revistas a: arrayRevistas) {
				System.out.println(a.getMostrarDetalles());
			}
		}
			
	}

	public int getId() {
		return id;
	}

	public String getPeriodico() {
		return periodico;
	}

	public void setPeriodico(String periodico) {
		this.periodico = periodico;
	}

	public Date getDiaRevista() {
		return diaRevista;
	}

	public void setDiaRevista(int anyo, int mes, int dia) {
	    GregorianCalendar diaRevista = new GregorianCalendar(anyo, mes - 1, dia);
	    this.diaRevista = diaRevista.getTime();
	}


}
