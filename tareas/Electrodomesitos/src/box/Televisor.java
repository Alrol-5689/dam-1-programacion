package box;

public class Televisor extends Electrodomestico {
	
	// ATRIBUTOS
	
	protected double resolucion;
	protected boolean tdt;
	
	protected final double RESOLUCION_POR_DEFECTO = 20;
	protected final boolean TDT_POR_DEFECTO = false;
	
	// CONSTRUCTORES
	
	protected Televisor() {
		super();
		this.resolucion = RESOLUCION_POR_DEFECTO;
		this.tdt = TDT_POR_DEFECTO;
		precioFinal();
	}

	protected Televisor(double peso, double precio_base) {
		super(peso, precio_base);
		this.resolucion = RESOLUCION_POR_DEFECTO;
		this.tdt = TDT_POR_DEFECTO;
		precioFinal();
	}

	protected Televisor(String marca, String modelo, String color, char consumo, double peso, double precio_base, double resolucion, boolean tdt) {
		super(marca, modelo, color, consumo, peso, precio_base);
		this.resolucion = resolucion;
		this.tdt = tdt;
		precioFinal();
	}
	
	// MÉTODOS
	
	protected void precioFinal() {
		super.precioFinal();
		if(this.resolucion > 40) this.precio *= 1.3;
		if(this.tdt) this.precio += 50;
	}
	
	
	
	
	@Override
	public String toString() {
		return String.format("%-10s", "Televisor:") + super.toString() + " Resolución: " + resolucion + "'' |" + (tdt ? " TDT: SÍ |" : " TDT: NO |");
	}


	protected double getResolucion() {return resolucion;}

	protected boolean isTdt() {return tdt;}

	
	
	

}
