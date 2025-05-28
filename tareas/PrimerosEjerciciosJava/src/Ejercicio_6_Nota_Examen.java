import java.util.Scanner;

public class Ejercicio_6_Nota_Examen {

	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABLES
		
		double nota;
		Scanner sc = new Scanner(System.in);
		
		// PETCICIÓN DE NOTA
		
		System.out.print("ESCRIBE TU NOTA: ");
		nota=sc.nextDouble();
		
		// IMPRIMIENDO RESULTADO
		
		if(nota >= 0 && nota < 5) {
			System.out.println("INSUFICIENTE.");
		}
		if(nota >= 5 && nota < 6) {
			System.out.println("SUFICIENTE.");
		}
		if(nota >= 6 && nota < 7) {
			System.out.println("BIEN.");
		}
		if(nota >= 7 && nota <= 8) {
			System.out.println("NOTABLE.");
		}
		if(nota >= 9 && nota < 10) {
			System.out.println("SOBRESALIENTE.");
		}
		if(nota == 10) {
			System.out.println("MATRÍCULA DE HONOR.");
		}
		if(nota>=5 && nota<=10) {
			System.out.println("PASAS DE CURSO.");
		}
		if(nota<5) {
			System.out.println("NO PASAS DE CURSO.");
		}
		if(nota>10 || nota<0) {
			System.out.println("NOTA INCORRECTA, TIENES QUE INTRODUCIR UN VALOR DE 0 A 10.");
		}

	}

}
