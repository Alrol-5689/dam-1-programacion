/*2.- 
 * Debes de crear una calculadora. 
 * La aplicación mostrará un menú con las operaciones que puede realizar (sumar, restar, multiplicar, dividir y resto).
 * También debe pedir al usuario que introduzca los dos números. 
 * Para la operación de restar debemos de comprobar que reste el número mayor menos el menor, es decir que si el usuario introduce, por ejemplo, 5 y 7 deberá hacer 7-5, no puede dar un número negativo. 
 * Para la operación división el divisor no podrá ser cero, en dicho caso le mostrará un mensaje diciendo que no se puede hacer la división.
 */

import java.util.Scanner;

public class Ejercicio_2_Calculadora {

	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABLES
		
		int op1, op2, resta;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime el primer número: ");
		op1=sc.nextInt();
		
		System.out.print("Dime el segundo número: ");
		op2=sc.nextInt();
		
		/* sc.next(); // LECTURA DE CADENA DE TEXTO HASTA QUE ENCUENTRA UN ESPACIO
		sc.nextLine(); // LECTURA DE CADENA DE TEXTO ENTERA
		sc.nextDouble(); // LECTURA DE VALOR double */
		
		
		System.out.println("La suma de "+op1+" más "+op2+" es "+(op1+op2)); //no ocupa espacio en la memoria
		
		if(op1>=op2) {
			System.out.println("La resta de "+op1+" menos "+op2+" es "+(op1-op2)); 
		}
		else {
			System.out.println("La resta de "+op2+" menos "+op1+" es "+(op2-op1));
		}
		
		System.out.println("La multiplicación de "+op1+" por "+op2+" es "+(op1*op2));
		
		if(op2==0||op1==0) {
			System.out.println("El dividendo o el divisor (o los dos) es cero. No podemos realizar la operación.");
		}
		else {
			System.out.println("La división de "+op1+" entre "+op2+" es "+(op1/op2));
		}
		
		if(op2==0||op1==0) {
			System.out.println("El dividendo o el divisor (o los dos) es cero. No podemos obtener el resto. ");
		}
		else {
		    System.out.println("El resto de "+op1+" y "+op2+" es "+(op1%op2));
		}
		
	}

}
