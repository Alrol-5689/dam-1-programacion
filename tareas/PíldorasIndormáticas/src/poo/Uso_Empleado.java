package poo;

import java.util.*;

public class Uso_Empleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Jefatura jefe_RRHH = new Jefatura("juan", 55000, 2006, 9, 25);
		jefe_RRHH.estableIncentivo(2570);
		Empleado[] misEmpleados = new Empleado[6];
		
		// int[] ejemplo = new int[4];
		
		misEmpleados[0] = new Empleado("Ana", 30000, 2000, 7, 7);
		misEmpleados[1] = new Empleado("Carlos", 50000, 1995, 6, 15);
		misEmpleados[2] = new Empleado("Paco", 25000, 2005, 9, 25);
		misEmpleados[3] = new Empleado("Antonio", 47500, 2009, 11, 9);
		misEmpleados[4] = jefe_RRHH; // POLIMORFISMO EN ACCIÓN. PRINCIPIO DE SUSTITUCIÓN
		misEmpleados[5] = new Jefatura("María", 95000, 1999, 5, 26);
		
		/* 
		 misEmpleados[5].estableceIncentivo --> NO LO PODEMOS UTILIZAR, PERO VEAMOS LA ALTERNATIVA:
		  
		 RECORDATORIO:
		 
		 double num1 = 7.5;
		 int num2 = (int) num1; 
		 
		 AHORA HARMEOS LO MISMO CON EL OBJETO
		 */
		
		Jefatura jefa_Finanzas = (Jefatura) misEmpleados[5];
		jefa_Finanzas.estableIncentivo(55000);
		
		
		for(Empleado e: misEmpleados) {
			e.subeSueldo(5);
		}
		
		for(Empleado e: misEmpleados) {
			System.out.println("Nombre: "+e.dameNombre()
			+" Sueldo: "+e.dameSueldo()
			+" Fecha de Alta: "+e.dameFechaContrato());
		}

	}

}
