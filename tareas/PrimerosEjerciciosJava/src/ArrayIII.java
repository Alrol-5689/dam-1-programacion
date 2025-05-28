
public class ArrayIII {
	
    public static void main(String[] args) {
    	
        int[][][] array = new int[4][2][3];        
        int contador=12;
        boolean ayb=true;
        

        // Llenar el array con valores según su "posición"
        
        for (int i = 0; i < array.length; i++) {          // 4 carpetas principales
        	
            for (int j = 0; j < array[i].length; j++) {      // 2 subcarpetas en cada carpeta
            	
                for (int k = 0; k < array[i][j].length; k++) {  // 3 valores en cada subcarpeta
                	
                	array[i][j][k] = contador; // Asignar el valor actual del contador
                    contador++;  
                }
            }
        }
        
        contador=1; // PARA NÚMERO DE CARPETA, SUBCARPETA Y ARCHIVO
    
        for (int i = 0; i < array.length; i++) {  
            System.out.println("Carpeta " +(1+ i) + ":");
            for (int j = 0; j < array[i].length; j++) {  
                System.out.print("\n  Subcarpeta " +(1+ j) + ": \n");
                for (int k = 0; k < array[i][j].length; k++) {  
                    System.out.print("\n      Archivo " +contador+": "+array[i][j][k] + " ");
                    contador++;
                }
                System.out.println();  
            }
            System.out.println(); 
        }
    }


}
