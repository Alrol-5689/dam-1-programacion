import java.util.Random;

public class Matriz_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matriz1=new int [3][3];
		int[][] matriz2=new int [3][3];
		int[][] matrizResultado=new int [3][3];
		
		Random aleatorio = new Random();
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				matriz1[i][j]=aleatorio.nextInt(10);
				matriz2[i][j]=aleatorio.nextInt(10);
				matrizResultado[i][j]=matriz1[i][j]+matriz2[i][j];
			}
		}
		
		System.out.println("Matriz 1:");
   		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(matriz1[i][j]+" ");
			}
			System.out.println();
		}
   		
   		System.out.println("Matriz 2:");
   		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(matriz2[i][j]+" ");
			}
			System.out.println();
		}
   		
   		System.out.println("Matriz Resultado:");
   		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(matrizResultado[i][j]+" ");
			}
			System.out.println();
		}

	}

}
