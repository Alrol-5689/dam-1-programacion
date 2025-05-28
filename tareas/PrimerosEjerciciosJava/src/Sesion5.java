import java.util.Scanner;

public class Sesion5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String[][] tabla_alumnos = new String [10][3];
		String dni;
		int opcion;
		boolean existe=false;
		
		do {
			
		System.out.println("Menú de opciones");
		System.out.println("1.- Insertar alumnos");
		System.out.println("6.- Salir");
		opcion=sc.nextInt();
		
		
			switch(opcion) {
			case 1: System.out.println("Dime tu DNI:");
					dni=sc.next();
					for(int i=0;i<tabla_alumnos.length;i++) {
						if(dni.equals(tabla_alumnos[i][0])) {
							System.out.println("No se puede insertar, ya existe.");
							existe=true;
							i=tabla_alumnos.length;
						}
					}
					if(!existe) {
						for(int i=0;i<tabla_alumnos.length;i++) {
							if(tabla_alumnos[i][0]==null) {								
								tabla_alumnos[i][0]=dni;
								System.out.println("Dime tu nombre");
								tabla_alumnos[i][1]=sc.next();
								System.out.println("Dime tu nota.");
								tabla_alumnos[i][2]=sc.next();
								System.out.println("Registro efectuado.");
								i=tabla_alumnos.length;
							}
						}
					}
						
					
					
					
				break;
			case 2:
				break;
			default:
			}
		} while(opcion!=6);

	}

}
