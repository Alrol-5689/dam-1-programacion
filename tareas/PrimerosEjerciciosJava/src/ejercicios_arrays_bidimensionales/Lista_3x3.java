package ejercicios_arrays_bidimensionales;

public class Lista_3x3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] lista = new int[3][3];
		int contador=1;
		
		for(int i=0; i<lista.length;i++) {
			for(int j=0; j<lista[i].length; j++) {
				lista[i][j]=contador;
				contador++;
			}
		}
		for(int i=0; i<lista.length;i++) {
			System.out.println();
			for(int j=0; j<lista[i].length; j++) {
				System.out.print(lista[i][j]);
			}
		}
		

	}

}
