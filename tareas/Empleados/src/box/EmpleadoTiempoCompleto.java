package box;

public class EmpleadoTiempoCompleto extends Empleado implements Beneficios {
	
	// Atributos
	
	// Constructores

	protected EmpleadoTiempoCompleto(String nombre, double salarioBase) {
		super(nombre, salarioBase);
	}
	
	//Métodos
	
	@Override
	protected double calcularSalario() {
		return salarioBase + (salarioBase * 0.1); // Bono del 10%
	}
	
	@Override
	public String obtenerBeneficios() {
		return "Seguro médico y vacaciones pagadas.";
	}

}
