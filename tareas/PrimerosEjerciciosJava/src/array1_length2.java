import java.util.Scanner;

public class array1_length2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el número de valores que tendrá la lista: ");
		int lista1[]=new int[sc.nextInt()];
		
		System.out.println();
		
		for(int i=0;i<lista1.length;i++) {
			System.out.print("Introduce la posición "+(i+1)+" de la lista: ");
			lista1[i]=sc.nextInt();
		}
		sc.close();
		
		System.out.println();
		
		for(int i=0;i<lista1.length;i++) {
			System.out.println("En la posición "+(i+1)+" se encuentra el valor "+lista1[i]+".");
		}
		

	}

}
