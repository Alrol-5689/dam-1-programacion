import java.util.Scanner;

public class ev_Trim1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// DECLARACIÓN DE VARIABLES
		
		final double A=25, B=20, C=15, D=10, ret_15=0.85, ret_20=0.8;
		double horas=0, salario_b=0, salario_a=0;
		String opcion="";
		Scanner sc = new Scanner(System.in);
		
		// EJECUCIÓN DEL PROGRAMA
		
		do { // COMIENZO DEL BUCLE ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
					System.out.println("\nIndica la clase a la que perteneces:\n"
							+"\n  ( A ) ---> Clase A"
							+"\n  ( B ) ---> Clase B"
							+"\n  ( C ) ---> Clase C"
							+"\n  ( D ) ---> Clase D"
							+"\n  ( X ) ---> Salir\n");
					
					opcion=sc.next();
					
					if(!opcion.toUpperCase().equals("X") && (opcion.toUpperCase().equals("A") || // AÑADIMOS PARÉNTESIS AGRUPANDO LAS OPCIONES "OR" SEPARADAS DEL "AND" 
					                                         opcion.toUpperCase().equals("B") || // PARA QUE NO FALLE LA LÓGICA
					                                         opcion.toUpperCase().equals("C") || 
				    	                                     opcion.toUpperCase().equals("D"))
					 ) {
						

							System.out.print("\nCuántas horas has trabajado este mes? ");
							horas=sc.nextInt();
							
							
							switch(opcion.toUpperCase()) {
							case "A":
								salario_b=A*horas;
								break;
							case "B":
								salario_b=B*horas;
								break;
							case "C":
								salario_b=C*horas;
								break;
							case "D":
								salario_b=D*horas;
								break;
							default: System.out.println("Opción incorrecta.");
							}
							
							
							if(salario_b<=1200) {
								salario_a=salario_b*ret_15;
								System.out.println("\nTu salario bruto es de "+salario_b+"€");
								System.out.println("Tu retención de IRPF es del 15%");
								System.out.println("Tu salario neto es de "+salario_a+"€");
							}
							else {
								salario_a=salario_b*ret_20;
								System.out.println("\nTu salario bruto es de "+salario_b+"€");
								System.out.println("Tu retención de IRPF es del 20%");
								System.out.println("Tu salario neto es de "+salario_a+"€");
							}
			
							
							do { // CONTROLAMOS TAMBIÉN ESTA RESPUESTA INTRODUCIENDO OTRO BUCLE -------------------------------------------------
							
								System.out.println("\n¿Quieres calcular otro salario?\n"
										+"\n  ( S ) ---> Sí"
										+"\n  ( N ) ---> No\n");
								
								opcion=sc.next();
				
								if(opcion.equalsIgnoreCase("n")){
									opcion="x";
									System.out.println("\nHasta la próxima!");
								}
								else if(!opcion.equalsIgnoreCase("s") && !opcion.equalsIgnoreCase("n")) {
									System.out.println("\nHas introducido una opción incorrecta.");
								}
							
							}while(!opcion.equalsIgnoreCase("S") && !opcion.equalsIgnoreCase("X"));	// -----------------------------------------
				
							
					}
					
					else if (opcion.toUpperCase().equals("X")) System.out.println("\nHasta la próxima!"); // FIN (X)
					
					else System.out.println("\nHas introducido una opción incorrecta."); // NO HAY X, VOLVEMOS ARRIBA
		
		// SIMPRE QUE NO SEA "X" VOLVEREMOS AL PRINCIPIO. ASEGURARME DE QUE TERMINE EN X AL PREGUNTAR SI QUIERE CONTINUAR.
					
		}while(!opcion.equalsIgnoreCase("x")); // FINAL DEL BUCLE /////////////////////////////////////////////////////////////////////////////////////////////////
		
		// opcion.equalsIgnoreCase("")  =  opcion.toUpperCase().equals("")  =  opcion.toLowerCase().equals("")  ------>> AUNQUE IgnoreCase NO VALE PARA EL switch

	}

}
