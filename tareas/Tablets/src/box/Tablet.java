package box;

public class Tablet {
	
	// ATRIBUTOS
	
	protected double precio, pulgadas;
	protected boolean disponible;
	protected String marca, modelo, color;

	protected int idTablet, anyo;
	
	protected static int idSiguiente;
	
	protected final boolean DISPONIBLE = true;
	
	// CONSTRUCTORES
	
	protected Tablet() {this.disponible = this.DISPONIBLE;}
	
	protected Tablet(String marca, String modelo, String color, double pulgadas, double precio, int anyo) {		
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.pulgadas = pulgadas;
		this.precio = precio;
		this.anyo = anyo;	
		this.disponible = this.DISPONIBLE;				
		this.idTablet=++idSiguiente;
	}
	
	// MÉTODOS

	@Override
	public String toString() {
		return "Tablet: Id: "+idTablet+". "+marca+" "+modelo+" (Color: "+color+") de "+pulgadas+"\" | "
				+ "Precio: "+precio+" € | Año: "+anyo+" | Disponible: "+disponible+" |";
	}
	
	protected String getResumen() {
		return marca+" "+modelo+" (Color: "+color+") de "+pulgadas+"\" | Precio: "+precio+" € | Año: "+anyo+" |";
	}
	
	protected static void restarIdSiguiente() {if(idSiguiente > 1) idSiguiente--;}
	
	protected int getIdTablet() {return idTablet;}
	
	protected double getPrecio() {return precio;}
	
	protected void setPrecio(double precio) {this.precio = precio;}
	
	protected double getPulgadas() {return pulgadas;}
	
	protected void setPulgadas(double pulgadas) {this.pulgadas = pulgadas;}
	
	protected boolean isDisponible() {return disponible;}
	
	protected void setDisponible(boolean disponible) {this.disponible = disponible;}
	
	protected String getMarca() {return marca;}
	
	protected void setMarca(String marca) {this.marca = marca;}
	
	protected String getModelo() {return modelo;}
	
	protected void setModelo(String modelo) {this.modelo = modelo;}
	
	protected int getLanzamiento() {return anyo;}
	
	protected void setLanzamiento(int lanzamiento) {this.anyo = lanzamiento;}
	
	protected String getColor() {return color;}

	protected void setColor(String color) {this.color = color;}

}
