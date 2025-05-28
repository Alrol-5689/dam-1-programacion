package box;

public class EmpleadoPorHoras extends Empleado implements Beneficios {
	
	// Atributos
	
	private int horasTrabajadas;
	private double tarifaPorHora;
	
	// Constructores
	
	protected EmpleadoPorHoras(String nombre, double salarioBase, int horasTrabajadas, double tarifaPorHora) {
		super(nombre, salarioBase);
		this.horasTrabajadas = horasTrabajadas;
		this.tarifaPorHora = tarifaPorHora;
	}
	
	// Métodos
	
	@Override
	protected double calcularSalario() {
		return horasTrabajadas * tarifaPorHora;
	}

	@Override
	public String obtenerBeneficios() {
		return "Bono por horas extrar trabajadas.";
	}
	
	
	
	
	

	
	

}
