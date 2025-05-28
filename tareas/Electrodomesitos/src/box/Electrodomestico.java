package box;

public class Electrodomestico {
	
	// ATRIBUTOS
	
	protected double precioBase, precio, peso;
	protected String color, marca, modelo;
	protected char consumo;
	protected int id;
	
	// Constanter (final) para inicializar los atributos:	

	protected final char CONSUMO_POR_DEFECTO = 'F';
	protected final int PESO_POR_DEFECTO = 5;
	protected final double PRECIO_BASE = 100;
	protected final String COLOR_POR_DEFECTO = "blanco", MARCA_VACIA = "Genérica", MODELO_VACIO = "Estandar";
	
	protected static int idSiguiente; // un atributo static para llevar el conteo de los ids 
	
	// CONSTRUCTORES
	
	protected Electrodomestico() {
		this.marca = MARCA_VACIA;
		this.modelo = MODELO_VACIO;
		this.precioBase = PRECIO_BASE;
		this.color = COLOR_POR_DEFECTO;
		this.consumo = CONSUMO_POR_DEFECTO;
		this.peso = PESO_POR_DEFECTO;	
		id =++ idSiguiente;
	}

	protected Electrodomestico(double peso, double precio_base) {
		this.marca = MARCA_VACIA;
		this.modelo = MODELO_VACIO;
		this.precioBase = precio_base;
		this.peso = peso;
		this.color = COLOR_POR_DEFECTO;
		this.consumo = CONSUMO_POR_DEFECTO;
		id =++ idSiguiente;
	}

	protected Electrodomestico(String marca, String modelo, String color, char consumo,  double peso, double precio_base) {
		this.marca = marca.toUpperCase();
		this.modelo = modelo;
		this.precioBase = precio_base;
		// this.color = color;
		comprobarColor(color);
		// this.consumo = consumo;
		comprobarConsumo(consumo);
		this.peso = peso;
		id =++ idSiguiente;
	}
	
	// MÉTODOS:
	
	@Override
	public String toString() {
	    return String.format("| Id: %-5d | %-9s | %-9s | %-8s | '%c' | %6.1f kg | %8.2f € | %8.2f € |",
	                         id, marca, modelo, color, consumo, peso, precioBase, precio);
	}
	
	protected void precioFinal() {
		this.precio = this.precioBase;
		switch(this.consumo) {
			case 'A': this.precio += 100; break;
			case 'B': this.precio += 80; break;
			case 'C': this.precio += 60; break;
			case 'D': this.precio += 50; break;
			case 'E': this.precio += 30; break;
			case 'F': this.precio += 10; break;
			default: this.precio += 10;
		}
		if(this.peso >= 0 && this.peso <= 19) {this.precio += 10;
		}else if(this.peso >= 20 && this.peso <= 49) {this.precio += 50;
		}else if(this.peso >= 50 && this.peso <= 79) {this.precio += 80;
		}else if(this.peso >= 80) {this.precio += 100;
		}else if(this.peso < 0) {		
		}else {this.precio += 10;
		}
	}

	protected void comprobarConsumo(char letra) {
		letra = Character.toUpperCase(letra);
		switch(letra) {
			case 'A': this.consumo = 'A'; break;
			case 'B': this.consumo = 'B'; break;
			case 'C': this.consumo = 'C'; break;
			case 'D': this.consumo = 'D'; break;
			case 'E': this.consumo = 'E'; break;
			case 'F': this.consumo = 'F'; break;
			default: this.consumo = 'F';
		}
	}
	
	protected void comprobarColor(String color) {
		color = color.toLowerCase();
		switch(color) {
			case "blanco": this.color = "blanco"; break;
			case "negro": this.color = "negro"; break;
			case "rojo": this.color = "rojo"; break;
			case "azul": this.color = "azul"; break;
			case "gris": this.color = "gris"; break;
			default: this.color = "blanco";
		}
	}
	
	// MÉTODOS SETTERS & GETTERS:

	protected double getPrecio() {return precio;}
	protected String getColor() {return color;}
	protected char getConsumo() {return consumo;}
	protected double getPeso() {return peso;}
	protected String getModelo() {return modelo;}
	protected String getMarca() {return marca;}
	protected int getId() {return id;}
	
	

	/*protected void setMarca(String marca) {
		this.marca = marca;
	}*/

	/*protected void setModelo(String modelo) {
		this.modelo = modelo;
	}*/

	

	/*protected void setId(int id) {
		this.id = id;
	}*/

	/*protected void setPrecio_base(double precio_base) {this.precio_base = precio_base;}*/
	/*protected void setColor(String color) {this.color = color;}*/
	/*protected void setConsumo(char consumo) {this.consumo = consumo;}*/
	/*protected void setPeso(int peso) {this.peso = peso;}*/
	


}
