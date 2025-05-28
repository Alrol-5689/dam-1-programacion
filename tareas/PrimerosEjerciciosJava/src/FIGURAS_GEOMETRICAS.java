import java.util.Scanner;

public class FIGURAS_GEOMETRICAS {
	
	public static void main(String[] args) {
		
		// DECLARACION DE VARIABLES
		
		double lado=0, l=0, a=0, b=0, c=0, base=0, altura=0, h=0, A=0, B=0, C=0, x=0, y=0, Ba=0, Bc=0, area=0, perimetro=0, semiperimetro=0;                                                     
		Scanner sc = new Scanner(System.in);
		String seleccion;
		
		// PETICION DE DATOS Y RESULTADO
		
		System.out.println("\n¿De qué figura se trata?   \n\n  ( 1 ) ---> CUADRADO   "
														+ "\n  ( 2 ) ---> RECTÁNGULO   "
														+ "\n  ( 3 ) ---> TRIÁNGULO\n");
		seleccion = sc.next().toUpperCase();
						
		switch(seleccion) { // ABRIMOS TODO 
		
		case "1": // CUADRADO
			
			System.out.print("\n¿Cuántos centímetros mide el lado del cuadrado?  ");
			lado = sc.nextDouble();
			area = Math.pow(lado, 2);
			perimetro = lado * 4;
			System.out.print("\nOkey, entonces su perímetro es de "+perimetro+"cm y su superficie "+area+"cm^2.");
			break;
			
		case "2": // RECTÁNGULO
			
			System.out.print("\n¿Cuántos centímetros mide la base del rectángulo?  ");
			base = sc.nextDouble();
			System.out.print("\n¿Cuántos centímetros tiene de altura?  ");
			altura = sc.nextDouble();
			area = base * altura;
			perimetro = (altura * 2) + (base * 2);
			System.out.println("\nOk, entonces el perímetro es de "+perimetro+"cm y el área "+area+"cm^2.");
			break;
		
		case "3": // TRIÁNGULO  
			
			System.out.println("\nConcreta:\n\n  ( 1 ) ---> ESCALENO "
										  + "\n  ( 2 ) ---> ISÓSCELES "
									      + "\n  ( 3 ) ---> RECTÁNGULO "
										  + "\n  ( 4 ) ---> EQUILÁTERO\n");
			seleccion = sc.next().toUpperCase();
			
			switch(seleccion) {  // ABRIMOS TIPO DE TRIÁNGULO____________________________________________________________________________________________________
			
			case "1": // ESCALENO - - - ESCALENO - - - ESCALENO - - - ESCALENO - - - ESCALENO - - - ESCALENO - - - ESCALENO - - - ESCALENO - - - ESCALENO - - - ESCALENO - - - 
				System.out.println("\nDatos que me vas a proporcionar:\n\n  ( 1 ) ---> CONOZCO LA ALTURA Y LA BASE."
						                                             + "\n  ( 2 ) ---> CONOZCO LOS 3 LADOS."
					                                             	 + "\n  ( 3 ) ---> CONOZCO LA BASE Y LOS DOS ANGULOS QUE LA TOCAN.\n ");
				seleccion = sc.next().toUpperCase();
				
				switch(seleccion) {
				
				case "1": //  ESCALENO - CONOZCO LA ALTURA Y LA BASE
					
					System.out.print("\nDime la altura:  ");
					h = sc.nextDouble();
					System.out.print("\nDime la base:  ");
					b = sc.nextDouble();
					area = (h * b) / 2;
					System.out.println("\nLa superficie del triángulo es "+area+"cm^2.");
					
								System.out.println("\n¿Quieres proporcionarme más datos para que calculemos el perímetro?\n\n   ( S ) ---> Sí."
																														+ "\n   ( N ) ---> A nadie le importa el perímetro.\n ");
								seleccion = sc.next();
								
										if(seleccion.equalsIgnoreCase("S")) {
											
													System.out.println("\n¿Cuál de los siguientes datos me vas a dar?\n\n  ( 1 ) ---> Ángulo que toca a la base por la izquierda." // C
															                                                        + "\n  ( 2 ) ---> Ángulo que toca a la base por la derehca."   // A
															                                                        + "\n  ( 3 ) ---> Lado que toca a la base por la derecha." // c
															                                                        + "\n  ( 4 ) ---> Lado que toca a la base por la izquierda.\n"); // a
													seleccion = sc.next();
													if(seleccion.equalsIgnoreCase("1")) {
														System.out.print("\nDime los grados del ángulo:  ");
														C=Math.toRadians(sc.nextDouble());
														a=h/Math.sin(C);
														x=Math.cos(C)*a;
														y=b-x;
														c=Math.sqrt((h*h)+(y*y));
														perimetro=a+b+c;
														System.out.println("\nOk, el perímetro es de "+perimetro+"cm");
													}
													else if(seleccion.equalsIgnoreCase("2")) {
														System.out.print("\nDime los grados del ángulo:  "); 
														A=Math.toRadians(sc.nextDouble());
														c=h/Math.sin(A);
														y=Math.cos(A)*c;
														x=b-y;
														a=Math.sqrt((h*h)+(x*x));
														perimetro=a+b+c;
														System.out.println("\nOk, el perímetro es de "+perimetro+"cm");
													}
													else if(seleccion.equalsIgnoreCase("3")) {
														System.out.print("\nDime cuántos cm mide el lado que toca a la base por la derehca (ha de ser igual o mayor a "+h+"cm):  ");
														c=sc.nextDouble();
														if(c>=h) {
														y=Math.sqrt((c*c)-(h*h));
														x=b-y;
														a=Math.sqrt((x*x)+(h*h));
														perimetro=a+b+c;
														System.out.println("\nOk, el perímetro es de "+perimetro+"cm");
														}
														else System.out.println("Dato inválido");
													}
													else if(seleccion.equalsIgnoreCase("4")) {
														System.out.print("\nDime cuántos cm mide el lado que toca a la base por la izquierda (ha de ser igual o mayor a "+h+"cm):  ");
														a=sc.nextDouble();
														if(a>=h) {
														x=Math.sqrt((a*a)-(h*h));
														y=b-x;
														c=Math.sqrt((y*y)+(h*h));
														perimetro=a+b+c;
														System.out.println("\nOk, el perímetro es de "+perimetro+"cm");
														}
														else System.out.println("Dato inválido");
													}
													else System.out.println("Has introducido una opción incorrecta.");														
										}
										else System.out.println("\nPues a descansar."); // NO QUIERE CALCULAR EL PERÍMETRO
					break;
				
				case "2": // CONOZCO LOS 3 LADOS
					System.out.print("\nDime el primer lado:  ");
					b=sc.nextDouble();
					System.out.print("\nDime el segundo lado:  ");
					a=sc.nextDouble();
					System.out.print("\nDime el tercer lado:  ");
					c=sc.nextDouble();
					perimetro=a+b+c;
					semiperimetro=perimetro/2;
					area=Math.sqrt(semiperimetro*(semiperimetro-a)*(semiperimetro-b)*(semiperimetro-c));
					System.out.print("\nEl perímetro mide "+perimetro+"cm, y el área "+area+"cm^2.");
					break;
				case "3": // CONOZCO LA BASE Y LOS DOS ANGULOS QUE LA TOCAN
					System.out.print("\nDime la base:  ");
					b=sc.nextDouble();
					System.out.print("\nDime el ángulo de la izquierda:  ");
					C=Math.toRadians(sc.nextDouble());
					System.out.print("\nDime el ángulo de la derecha:  ");
					A=Math.toRadians(sc.nextDouble());
					B=Math.PI-A-C; // PI ES EL EQUIVALENTE A 180º EN RADIANES
					c=Math.sin(C)*b/Math.sin(B);
					a=Math.sin(A)*b/Math.sin(B);
					perimetro=a+b+c;
					semiperimetro=perimetro/2;
					area=Math.sqrt(semiperimetro*(semiperimetro-a)*(semiperimetro-b)*(semiperimetro-c));
					System.out.print("\nEl perímetro mide "+perimetro+"cm, y el área "+area+"cm^2.");
					break;
				default: System.out.print("Error.");
					break;
				}
				
				break; //BREAK DE ESCALENO
				
			case "2": // ISÓSCELES - - - - ISÓSCELES - - -ISÓSCELES - - -ISÓSCELES - - -ISÓSCELES - - -ISÓSCELES - - -ISÓSCELES - - -ISÓSCELES - - -ISÓSCELES - - -ISÓSCELES - - -
				
				System.out.println("\nDatos que me vas a proporcionar:\n\n  ( 1 ) ---> CONOZCO LA ALTURA Y LA BASE."
												                     + "\n  ( 2 ) ---> CONOZCO LA ALTURA Y UN LADO (CUALQUIRA, QUE VALEN LO MISMO)."
												                     + "\n  ( 3 ) ---> CONOZCO LA BASE Y EL ÁNGULO QUE LA TOCA (CUALQUIRA DE LOS DOS, MISMA LÓGICA).\n ");
				seleccion=sc.next();
				
				switch(seleccion) {
				case "1": // CONOZCO LA ALTURA Y LA BASE
					System.out.print("\nDime la altura:  ");
					h=sc.nextDouble();
					System.out.print("\nDime la base:  ");
					b=sc.nextDouble();
					x=b/2;
					a=Math.sqrt((x*x)+(h*h));
					c=a;
					perimetro=a+b+c;
					semiperimetro=perimetro/2;
					area=Math.sqrt(semiperimetro*(semiperimetro-a)*(semiperimetro-b)*(semiperimetro-c));
					System.out.print("\nEl perímetro mide "+perimetro+"cm, y el área "+area+"cm^2.");
					break;
				case "2": // CONOZCO LA ALTURA Y UN LADO
					System.out.print("\nDime la altura:  ");
					h=sc.nextDouble();
					System.out.print("\nDime un lado:  ");
					a=sc.nextDouble();
					x=Math.sqrt((a*a)-(h*h));
					b=2*x;
					c=a;
					perimetro=a+b+c;
					semiperimetro=perimetro/2;
					area=Math.sqrt(semiperimetro*(semiperimetro-a)*(semiperimetro-b)*(semiperimetro-c));
					System.out.print("\nEl perímetro mide "+perimetro+"cm, y el área "+area+"cm^2.");
					break;
				case "3": // CONOZCO LA BASE Y EL ÁNGULO QUE LA TOCA
					System.out.print("\nDime la base:  ");
					b=sc.nextDouble();
					System.out.print("\nDime uno de los ángulos que toca a la base:  ");
					C=Math.toRadians(sc.nextDouble());
					A=C;
					B=Math.PI-A-C;
					x=b/2;
					y=x;
					Ba=B/2;
					Bc=Ba;
					a=Math.sin(A)*b/Math.sin(B);
					c=a;
					perimetro=a+b+c;
					semiperimetro=perimetro/2;
					area=Math.sqrt(semiperimetro*(semiperimetro-a)*(semiperimetro-b)*(semiperimetro-c));
					System.out.print("El perímetro mide "+perimetro+"cm, y el área "+area+"cm^2.");
					break;
				default: System.out.print("Error.");
					break;
				}
				break; //BREAK DE ISÓSCELES
				
			case "3": // RECTÁNGULO - - - - RECTÁNGULO - - - -RECTÁNGULO - - - -RECTÁNGULO - - - -RECTÁNGULO - - - -RECTÁNGULO - - - -RECTÁNGULO - - - -RECTÁNGULO - - - -RECTÁNGULO - - - -
				System.out.print("\nVamos a suponer que el ángulo recto toca la base. ¿Cuánto mide la base?  ");
				b=sc.nextDouble();
				System.out.print("\n¿Cuánto mide la altura?  ");
				h=sc.nextDouble();
				c=Math.sqrt((h*h)+(b*b));
				perimetro=h+b+c;
				area=b*h/2;
				System.out.print("\nEl perímetro mide "+perimetro+"cm, y el área "+area+"cm^2.");
				break;
				
			case "4": // EQUILÁTERO - - - EQUILÁTERO - - - -EQUILÁTERO - - - -EQUILÁTERO - - - -EQUILÁTERO - - - -EQUILÁTERO - - - -EQUILÁTERO - - - -EQUILÁTERO - - - -EQUILÁTERO - - - -
				System.out.print("\nDime cualquiera de los lados:  ");
				b=sc.nextDouble();
				a=b;
				c=b;
				perimetro=a+b+c;
				semiperimetro=perimetro/2;
				area=Math.sqrt(semiperimetro*(semiperimetro-a)*(semiperimetro-b)*(semiperimetro-c));
				System.out.print("\nEl perímetro mide "+perimetro+"cm, y el área "+area+"cm^2.");
				break;
				
			default: System.out.println("\nError de selección."); 
				break;
			} // CERRAMOS TIPO DE TRIÁNGULO______________________________________________________________________________________________________________________
			break; // AQUÍ SE ROMPEN TODOS LOS TRIÁNGULOS
			
		default: System.out.println("\nError de selección."); // CERRAMOS TODO 
			break;
			
		}
	}
}
