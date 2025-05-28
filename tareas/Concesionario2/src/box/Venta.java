package box;

import java.util.Date;

public class Venta {
	
	// Atributos
	
	Cliente cliente;
	Coche coche;
	protected Date fecha;
	protected int id;
	protected static int idSiguiente;
	
	// Constructores
	
	protected Venta(Cliente cliente, Coche coche) {
		this.cliente = cliente;
		this.coche = coche;
		this.fecha = new Date();
		id =++ idSiguiente;
	}
	
	// Métodos

	@Override
	public String toString() {
		return "Venta [cliente=" + cliente.nombre + ", coche=" + coche.matricula + ", fecha=" + fecha + ", id=" + id + "]";
	}


	protected Cliente getCliente() {
		return cliente;
	}

	protected void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	protected Coche getCoche() {
		return coche;
	}

	protected void setCoche(Coche coche) {
		this.coche = coche;
	}

	protected Date getFecha() {
		return fecha;
	}

	protected void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

}
