package paquete1;

public class Coche {
	
	private int ruedas, largo, ancho, motor, peso_plataforma, peso_total;
	private String color;
	private boolean asientos_cuero, climatizador;	
	/* PRIVATE: ESTAS PROPIEDADES ESTÁN ENCAPSULADAS
	POR LO QUE SOLO SE PUEDEN MODIFICAR POR EL CANAL CORRESPONDIENTE (MÉTODOS)*/
	
	public Coche() { // MÉTODO CONSTRUCTOR (MISMO NOMBRE QUE LA CLASE)
		// ESTABLECEMOS CON ESTE MÉTODO EL ESTADO INICIAL DEL OBJETO V32_COCHE
		ruedas=4;
		largo=2000;
		ancho=300;
		motor=1600;
		peso_plataforma=500;		
	} 
	
	public void establece_color(String color_coche){ // SETER (void PORQUE NO HAY return)
		
		color = color_coche;
	}
	
	public String dime_color() { // GETTER
		
		return "El color del vehículo es "+color+". ";
	}
	
	public void configura_asientos(String asientos_cuero) {
		
		if(asientos_cuero=="si") {
			this.asientos_cuero=true;
		}else {
			this.asientos_cuero=false;
		}
	}
	
	public String dime_asientos() {
		
		if(asientos_cuero==true) {
			return "El coche tiene asientos de cuero";
		}else{
			return "El coche tiene asientos de serie";
		}
	}
	
	public void configura_climatizador(String climatizador) { // SETTER
		
		if(climatizador=="si") {
			this.climatizador=true;
		}else {
			this.climatizador=false;
		}
	}
	
	public String dime_climatizador() { // GETTER
		
		if (climatizador==true) {
			return "El coche incorpora climatizador";
		}else {
			return "El coche incorpora aire acondicionado";
		}
	}
	
	public String dime_datos_generales() {
		
		return "La plataforma del vehículo tiene "
				+ruedas+" ruedas. "+"Mide "
				+largo/1000+" metros de largo y "
				+ancho+" centímetros de ancho. "
				+"La plataforma pesa "+peso_plataforma+" kg.";
	}
	
	// SE RECOMIENDA NO HACER LO SIGUIENTE (JUNTAR SETTER Y GETTER)
	
	public String dime_peso_coche() {  // SETTER & GETTER
		
		int peso_carroceria=500;
		peso_total=peso_plataforma+peso_carroceria;
		
		if(asientos_cuero==true) {
			peso_total=peso_total + 50;
		}		
		if(climatizador==true) {
			peso_total=peso_total + 20;
		}		
		return "El peso total es "+peso_total+" kg";
	}
	
	public int dime_precioToral() { // GETTER
		
		int precio_final=10000;
		
		if(asientos_cuero==true) {
			precio_final+=2000;			
		}
		if(climatizador==true) {
			precio_final+=1500;
		}
		return precio_final;
		
	}

}
