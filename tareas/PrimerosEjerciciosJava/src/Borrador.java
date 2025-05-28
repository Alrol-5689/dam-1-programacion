import java.util.Scanner; // BORRADOR PARA TRIANGULO ESCALENO

public class Borrador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double lado=0, lado_a=0, lado_b=0, lado_c=0, base=0, altura=0, alturaA=0, alturaB=0, alturaC=0, anguloA=0, anguloB=0, anguloC=0, area=0, perimetro=0, semiPerimetro=0; 
		Scanner sc = new Scanner(System.in);
		String seleccion;
		
		System.out.println("\nDatos que me vas a proporcionar:\n\n  ( A ) ---> CONOZCO LA ALTURA Y LA BASE."
												             + "\n  ( B ) ---> CONOZCO LOS 3 LADOS");
												           //  + "\n  ( C ) ---> RELLENAR DESPUÉS "
												           //  + "\n  ( D ) ---> RELLENAR DESPUÉS");
		seleccion = sc.next().toUpperCase();
		
		switch(seleccion) {
		
		case "A": // CONOZCO LA ALTURA Y LA BASE
			
			System.out.print("\nDime la altura:");
			alturaB = sc.nextDouble();
			System.out.print("\nDime la base:");
			lado_b = sc.nextDouble();
			area = (alturaB * lado_b) / 2;
			System.out.println("\nLa superficie del triángulo es "+area+"cm^2.");
			System.out.println("\n¿Quieres proporcionarme más datos para que calculemos el perímetro?"
																+ "\n   ( S ) ---> Sí."
																+ "\n   ( N ) ---> A nadie le importa el perímetro. ");
			seleccion = sc.next();
			if(seleccion.equalsIgnoreCase("S")) {
				System.out.println("\n¿Cuál de los siguientes datos me vas a dar?\n\n  ( A ) ---> Ángulo opuesto a la base."
						                                                        + "\n  ( B ) ---> Ángulo que toca la base (cualquiera de los dos)"
						                                                        + "\n  ( C ) ---> Otro lado (cualquiera de los dos que quedan)");
				seleccion = sc.next();
				if(seleccion.equalsIgnoreCase("A")) {
					System.out.print("\nEscribe el ángulo opuesto a la base:");
					anguloB = Math.toRadians(sc.nextDouble()); // CONVERTIMOS A RADIANDES
					double x = 0, y = 0; // SERÁN LAS PARTICIONES DEL LADO B (BASE DEL TRIÁNGULO) EN DOS PARTES SEGÚN LA PERPENDICULAR DEL ÁNGULO B, O SEA, LA ALTURA
					x = alturaB / Math.tan(anguloB);
					y = lado_b - x;
				}
			}
			else System.out.println("\nPues a descansar.");
			break;
		}

	}

}
