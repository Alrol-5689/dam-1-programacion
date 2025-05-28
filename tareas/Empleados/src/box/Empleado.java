package box;

public abstract class Empleado {
	
	// Atributos
	
	protected String nombre;
	protected double salarioBase;
	
	// Constructores
	
	protected Empleado(String nombre, double salarioBase) {
		this.nombre = nombre;
		this.salarioBase = salarioBase;
	}
	
	// Métodos
	
	protected void mostrarInfo() {
		System.out.println("Nombre: "+nombre+". Salario: "+calcularSalario());
	}
	
	protected abstract double calcularSalario();

}
