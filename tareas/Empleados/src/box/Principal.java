package box;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<Empleado> empleados = new ArrayList<>();
		empleados.add(new EmpleadoTiempoCompleto("David", 2000));
		empleados.add(new EmpleadoPorHoras("Javier", 2300, 160, 15));
		
		for(Empleado e : empleados) {
			e.mostrarInfo();
			if(e instanceof Beneficios) {
				System.out.println("Beneficios: " + ((Beneficios)e).obtenerBeneficios());
			}
			System.out.println("---------------------------------------------------");
		}
		
		/*for(Empleado e : empleados) {
			if(e instanceof EmpleadoTiempoCompleto) {
				System.out.println("Beneficios: " + ((EmpleadoTiempoCompleto)e).obtenerBeneficios());
			}
		}
		
		for(Empleado e : empleados) {
			if(e instanceof EmpleadoPorHoras) {
				System.out.println("Beneficios: " + ((EmpleadoPorHoras)e).obtenerBeneficios());
			}
		}*/

	}

}
