package EjerciciosResueltos;


import java.util.Scanner;

public class Ejercicio_4 {

	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABLES
		
		int num1, num2, num3;
		Scanner sc = new Scanner(System.in);
		
		// PETICIÓN DE DATOS
		
		System.out.print("Dime el primer número: ");
		num1 = sc.nextInt();
		
		System.out.print("Dime el segundo número: ");
		num2 = sc.nextInt();
		
		System.out.print("Dime el tercer número: ");
		num3 = sc.nextInt();
						
		// IMPRIMIENDO EL RESULTADO
						
		if (num1>num2) { // 1>2
			if (num1>num3) { // 1>2 && 1>3 ---> (1)(x)(x)
				System.out.println("El número mayor es el "+num1+".");
				if(num2>num3) { // 1>2 && 1>3 && 2>3 ---> (1)(2)(3)
					System.out.println("El número mediano es el "+num2+".");
					System.out.println("El número pequeño es el "+num3+".");
				}
				else { // 1>2 && 1>3 && 3>2 ---> (1)(3)(2)
					System.out.println("El número mediano es el "+num3+".");
					System.out.println("El número pequeño es el "+num2+".");
				}
			}
			else { // 1>2 && 3>1 ---> (3)(1)(2)
				System.out.println("El número mayor es el "+num3+".");
				System.out.println("El número mediano es el "+num1+".");
				System.out.println("El número pequeño es el "+num2+".");		
			}
		}
		else { // 2>1
			if (num2>num3) { // 2>1 && 2>3 ---> (2)(x)(x)
				System.out.println("El número mayor es el "+num2+".");
				if(num1>num3) { // 2>1 && 2>3 && 1>3 ---> (2)(1)(3)
					System.out.println("El número mediano es el "+num1+".");
					System.out.println("El número pequeño es el "+num3+".");
				}
				else { // 2>1 && 2>3 && 3>1 ---> (2)(3)(1)
					System.out.println("El número mediano es el "+num3+".");
					System.out.println("El número pequeño es el "+num1+".");
				}
			}
			else { // 2>1 && 3>2 ---> (3)(2)(1)
				System.out.println("El número mayor es el "+num3+".");
				System.out.println("El número mediano es el "+num2+".");
				System.out.println("El número pequeño es el "+num1+".");		
			}
		}			
	}
}
