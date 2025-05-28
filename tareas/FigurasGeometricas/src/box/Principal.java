package box;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Figura2D> figuras = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		do {
			System.out.println("----------------------------------------------------------------");
			System.out.println("1.- Rectángulo");
			System.out.println("2.- Círculo");
			System.out.println("3.- Triángulo");
			System.out.println("4.- Salir");
			System.out.print("Introduce el número de la figura cuyo perímetro quieres calcular:");
			opcion = sc.nextInt();
			sc.nextLine(); // limpiar buffer
			
			switch(opcion) {
			case 1: 
				
				System.out.print("Introduce el nombre del rectángulo: ");
				String nombreRectangulo = sc.nextLine();
				System.out.print("Introduce cuánto mide la base: ");
				double baseRectangulo = sc.nextDouble();
				System.out.print("Introduce cuánto mide la altura: ");
				double alturaRectangulo = sc.nextDouble();
				Rectangulo rectangulo = new Rectangulo(nombreRectangulo, baseRectangulo, alturaRectangulo);
				figuras.add(rectangulo);
				double perimetroRectangulo = rectangulo.calcularPerimetro();
				System.out.println("El perímetro del rectángulo "+nombreRectangulo+" es "+perimetroRectangulo);
				break;
			case 2:
				System.out.print("Introduce el nombre del círculo: ");
				String nombreCirculo = sc.nextLine();
				System.out.print("Introduce el radio: ");
				double radioCirculo = sc.nextDouble();
				Circulo circulo = new Circulo(nombreCirculo, radioCirculo);
				figuras.add(circulo);
				double perimetroCirculo = circulo.calcularPerimetro();
				System.out.println("El perímetro del circulo "+nombreCirculo+" es "+perimetroCirculo);
				
				break;
			case 3:
				System.out.print("Introduce el nombre del rectángulo: ");
				String nombreTriangulo = sc.nextLine();
				System.out.print("Introduce el lado 'a': ");
				double aTriangulo = sc.nextDouble();
				System.out.print("Introduce el lado 'b': ");
				double bTriangulo = sc.nextDouble();
				System.out.print("Introduce el lado 'c': ");
				double cTriangulo = sc.nextDouble();
				Triangulo triangulo = new Triangulo(nombreTriangulo, aTriangulo, bTriangulo, cTriangulo);
				figuras.add(triangulo);
				double perimetroTriangulo = triangulo.calcularPerimetro();
				System.out.println("El perímetro del triángulo "+nombreTriangulo+" es "+perimetroTriangulo);
				break;
			case 4:
				break;
			case 5:
				break;
			default:
			}
			
			
		}while(opcion != 4);


	}

}
