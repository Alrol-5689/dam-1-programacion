package paquete1;

public class V25_arrays_bidimensionales {
	
	public static void main(String[] args) {
		
		int[][] arrayBi=new int[4][5];
		
		arrayBi[0][0]=101;
		arrayBi[0][1]=102;
		arrayBi[0][2]=103;
		arrayBi[0][3]=104;
		arrayBi[0][4]=105;		
		
		arrayBi[1][0]=106;
		arrayBi[1][1]=107;
		arrayBi[1][2]=108;
		arrayBi[1][3]=109;
		arrayBi[1][4]=110;
				
		arrayBi[2][0]=111;
		arrayBi[2][1]=112;
		arrayBi[2][2]=113;
		arrayBi[2][3]=114;
		arrayBi[2][4]=115;
			
		arrayBi[3][0]=116;
		arrayBi[3][1]=117;
		arrayBi[3][2]=118;
		arrayBi[3][3]=119;
		arrayBi[3][4]=120;
		
		for(int i=0; i<4; i++) {
			
			System.out.println();
			
			for(int j=0; j<5; j++) {
				
				System.out.print(arrayBi[i][j]+"  ");
				
			}
			
		}
		
	}

}
