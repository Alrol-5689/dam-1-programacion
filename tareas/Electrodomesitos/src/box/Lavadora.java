package box;

public class Lavadora extends Electrodomestico {
	
	// ATRIBUTOS
	
	protected int carga;
	protected final int CARGA_POR_DEFECTO = 5;
	
	// CONSTRUCTORES	
	
	protected Lavadora() {
		super();
		this.carga = CARGA_POR_DEFECTO;
	}

	protected Lavadora(double peso, double precio_base) {
		super(peso, precio_base);
		this.carga = CARGA_POR_DEFECTO;
	}

	protected Lavadora(String marca, String modelo, String color, char consumo,  double peso, double precio_base, int carga) {
		super(marca, modelo, color, consumo, peso, precio_base);
		this.carga = carga;
		precioFinal();
	}
	
	// MÉTODOS:

	@Override
	public String toString() {
		return String.format("%-10s", "Lavadora:") + super.toString() + " Carga: " + carga + " kg |";
	}
	
	protected void precioFinal() {
		super.precioFinal();
		if(carga >= 30) this.precio += 50;
	}
	
	// GETTER
	
	protected int getCarga() {return carga;}
	

}
