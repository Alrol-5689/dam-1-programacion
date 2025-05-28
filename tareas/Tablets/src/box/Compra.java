package box;

import java.util.*;

public class Compra {
	
	// ATRIBUTOS
	
	protected Tablet tablet;
	protected Cliente cliente;
	protected Date fechaCompra;
	protected double precioFinal;
	protected int idCompra;
	
	protected static int idSiguiente;
	protected static Compra compraX = new Compra(); // para guardar valores de una compra entre métodos
	
	// CONSTRUCTORES
	
	protected Compra() {
		this.fechaCompra = new Date(); 
		this.idCompra=++idSiguiente;		
	}

	protected Compra(Tablet tablet, Cliente cliente, double precioFinal) { // este es el único que uso, se pone la fecha de compra automáticamente
		this.tablet = tablet;
		// this.tablet.isDisponible(true); esto no me deja hacerlo
		this.cliente = cliente;
		this.precioFinal = precioFinal;
		this.fechaCompra = new Date(); 
		this.idCompra=++idSiguiente;
	}
	
	protected Compra(Tablet tablet, Cliente cliente, double precioFinal, Date fechaCompra) {
		this.tablet = tablet;
		this.cliente = cliente;
		this.precioFinal = precioFinal;
		this.fechaCompra = fechaCompra; 
		this.idCompra=++idSiguiente;
	}
	
	protected Compra(Tablet tablet, Cliente cliente, double precioFinal, int anyo, int mes, int dia) {
		this.tablet = tablet;
		this.cliente = cliente;
		this.precioFinal = precioFinal;
		GregorianCalendar x = new GregorianCalendar(anyo, mes-1, dia);
		this.fechaCompra = x.getTime(); 
		this.idCompra=++idSiguiente;
	}
	
	// MÉTODOS GETTERS & SETTERS

	@Override
	public String toString() {
		return "ID Compra: " + idCompra + " | Cliente: Id "+cliente.getIdCliente() +", "+ cliente.getNombre() + 
	               " | Tablet: Id "+tablet.getIdTablet()+", " + tablet.getModelo() + " (" + tablet.getMarca() + ")" +
	               " | Precio: " + precioFinal + "€ | Fecha: " + fechaCompra;
	}

	protected Tablet getTablet() {return tablet;}

	protected void setTablet(Tablet tablet) {this.tablet = tablet;}

	protected Cliente getCliente() {return cliente;}

	protected void setCliente(Cliente cliente) {this.cliente = cliente;}

	protected Date getFechaCompra() {return fechaCompra;}

	protected double getPrecioFinal() {return precioFinal;}

	protected void setPrecioFinal(double precioFinal) {this.precioFinal = precioFinal;}

	protected int getIdCompra() {return idCompra;}

	protected void setIdCompra(int idCompra) {this.idCompra = idCompra;}	
	
	protected void setFechaCompra(Date fechaCompra) {this.fechaCompra = fechaCompra;}
	
	protected void setFechaCompra(int anyo, int mes, int dia) {
		GregorianCalendar x = new GregorianCalendar(anyo, mes-1, dia);
		this.fechaCompra = x.getTime(); 
	}
	
	

}
