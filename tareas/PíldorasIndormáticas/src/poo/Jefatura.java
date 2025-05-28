package poo;

class Jefatura extends Empleado {
			
	public Jefatura(String nom, double sue, int anyo, int mes, int dia) {
		
		super(nom, sue, anyo, mes, dia);
		
	}
	
	public void estableIncentivo(double b) {
		
		incentivo=b;
		
	}
	
	public double dameSueldo() {
		
		double sueldoJefe = super.dameSueldo(); 
		// DAMESUELDO DE LA CLASE PADRE
		return sueldoJefe + incentivo;
	}
	
	private double incentivo;
	

}
