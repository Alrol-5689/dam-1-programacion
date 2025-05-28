package box1;

public class Producto {
	
	// Atributos
	
	protected String nombre;
	protected double precio;
	protected int stock;
	
	// Constructores
	
	Producto(String nombre, double precio, int stock){
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	
	// Métodos
	
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected double getPrecio() {
		return precio;
	}

	protected void setPrecio(double precio) {
		this.precio = precio;
	}

	protected int getStock() {
		return stock;
	}

	protected void setStock(int stock) {
		this.stock = stock;
	}
	

}
