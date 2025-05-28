package concesionario;

public class Vehiculo {
	
	private String matricula;
	private String modelo;
	
	/* PRIVATE: ESTAS PROPIEDADES ESTÁN ENCAPSULADAS
	POR LO QUE SOLO SE PUEDEN MODIFICAR POR EL CANAL CORRESPONDIENTE (MÉTODOS)*/
	
	public Vehiculo(String matricula, String modelo) { 
		// MÉTODO CONSTRUCTOR (MISMO NOMBRE QUE LA CLASE)
		// ESTABLECEMOS CON ESTE MÉTODO EL ESTADO INICIAL DEL OBJETO VEHICULO
		this.matricula = matricula;
		this.modelo = modelo;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String toString() {
		return "Matrícula: "+matricula+". Modelo: "+modelo+".";
	}

}
