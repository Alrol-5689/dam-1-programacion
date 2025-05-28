package box;

import java.util.Date;
import java.util.GregorianCalendar;

public class Reserva {
	
	// ATRIBUTOS
	
	protected Tablet tablet;
	protected Cliente cliente;
	protected Date fechaReserva;
	protected int idReserva;
	
	protected static int idSiguiente;
	protected static Reserva reservaX = new Reserva(); // para guardar valores de una reserva entre métodos

	// CONSTRUCTORES
	
	protected Reserva() {
		this.fechaReserva = new Date();
		this.idReserva = idSiguiente;
	}

	protected Reserva(Tablet tablet, Cliente cliente) {
		this.tablet = tablet;
		this.cliente = cliente;
		this.fechaReserva = new Date();
		this.idReserva = idSiguiente;
	}

	@Override
	public String toString() {
		return "Id Reserva "+idReserva+" ["+fechaReserva+"] "
				+ "Id tablet: "+tablet.getIdTablet()+", "+tablet.getMarca()+" "+tablet.getModelo()+", año: "+tablet.getLanzamiento()+", precio: "+tablet.getPrecio()+" €. "
				+ "Id Cliente "+cliente.getIdCliente()+", "+cliente.getNombre()+".";
				
				// "Reserva [tablet=" + tablet + ", cliente=" + cliente + ", fechaReserva=" + fechaReserva + ", idReserva="+ idReserva + "]";
	}

	protected Tablet getTablet() {return tablet;}

	protected void setTablet(Tablet tablet) {this.tablet = tablet;}

	protected Cliente getCliente() {return cliente;}

	protected void setCliente(Cliente cliente) {this.cliente = cliente;}

	protected Date getFechaReserva() {return fechaReserva;}

	protected void setFechaReserva(Date fechaReserva) {this.fechaReserva = fechaReserva;}
	
	protected void setFechaReserva(int anyo, int mes, int dia) {
		GregorianCalendar x = new GregorianCalendar(anyo, mes-1, dia);
		this.fechaReserva = x.getTime();
	}
	
}
