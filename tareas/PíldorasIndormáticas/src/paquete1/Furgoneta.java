package paquete1;

public class Furgoneta extends Coche { // HIJO Y PADRE
	
	private int capacidad_carga;
	private int plazas_extra;
	
	public Furgoneta(int plazas_extra, int capacidad_carga) { // CONSTRUCTOR
		
		super(); // LLAMA A PADRE ( V32_COCHE )
		
		this.capacidad_carga = capacidad_carga;
		this.plazas_extra = plazas_extra;
	}
	
	public String getDatosFurgoneta() {
		
		return "La capacidad de carga es: "+capacidad_carga
			  +" y las plazas son "+plazas_extra;
	}
	

}
