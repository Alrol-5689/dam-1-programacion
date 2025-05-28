package poo;

import java.sql.*;
import java.util.*;
import java.util.Date;

class Empleado {
	
	private String nombre;
	private double sueldo;
	private Date altaContrato;
	private static int IdSiguiente;
	private int Id;
	
	public Empleado(String nom, double sue, int anyo, int mes, int dia) {
		
		nombre = nom;
		sueldo= sue;
		GregorianCalendar calendario = new GregorianCalendar(anyo, mes-1, dia);
		altaContrato = calendario.getTime();
		++IdSiguiente;
		Id = IdSiguiente;
	}
	
	public Empleado(String nom) {
		
		this(nom, 30000, 2000, 01, 01);
	}
	
	public String dameNombre() {
		return nombre + " Id: "+Id;
	}
	
	public double dameSueldo() {
		return sueldo;
	}
	
	public Date dameFechaContrato() {
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje) {
		double aumento = sueldo*porcentaje/100;
		sueldo+=aumento;
	}

}
