import java.util.*;

public class CALCULADORA_PARTE_I {

    public static void main(String[] args) {
    
        // DECLARACION DE VARIABLES
      
    	int num1, num2, resultado=0;
        String operacion;
        Scanner sc = new Scanner(System.in);
                
        // PETICION DE DATOS Y EJECUCIÓN
        
        do {
        	
        	System.out.println("\nRealizamos una operación? "
        			+"\n\n  ( S ) ---> Sí" 
        			+"\n  ( N ) ---> No\n");
        	operacion = sc.next().toUpperCase();
        	
        	if(operacion.equals("N")) {
        		System.out.println("\nHasta la próxima.");
        	}else {
	        	System.out.print("\nEscribe el primer número a operar: ");
	            num1 = sc.nextInt();
	            
	            imprimirMenuPrincipal();
	            operacion = sc.next().toUpperCase();
	            
	            if(!operacion.equals("X")) {
	            	
		            System.out.print("\nEscribe el segundo número a operar: ");
		            num2 = sc.nextInt();
		            System.out.println();
		            menuOperaciones(num1, num2, operacion);
		            
	            }else System.out.println("\nHasta la próxima.");
        	}
                      
        }while(!operacion.equals("X") && !operacion.equals("N"));
        
        
    }
    
    // MÉTODOS (FUERA DEL MAIN PERO DENTRO DE LA CLASE)
    
    public static void imprimirMenuPrincipal() {
    	System.out.println("\n¿Qué operación deseas realizar?");
    	System.out.println("\n   ( S ) ---> Sumar.");
        System.out.println("   ( R ) ---> Restar.");
        System.out.println("   ( M ) ---> Multiplicar.");
        System.out.println("   ( D ) ---> Dividir.");
        System.out.println("   ( T ) ---> Calcular el resto.");
        System.out.println("   ( X ) ---> Salir.");
        System.out.print("\nEscribe la letra de la operación que deseas realizar: ");
    }
    
    public static void menuOperaciones(int num1, int num2, String operacion) {
    	switch (operacion) {
        case "S": sumar(num1, num2);
            break;
        case "R": restar(num1, num2);
        	break;
        case "M": multiplicar(num1, num2);
            break;
        case "D": dividir(num1, num2);
            break;
        case "T": resto(num1, num2);
            break;
        default:
            System.out.println("Operación no reconocida. Por favor elige S, R, M, D o T.");
    	}
    }
    
    public static void sumar(int num1, int num2) { // COPIA POR VALOR (SON VARIABLES DISTINTAT)
    	System.out.println("La suma de "+num1+" y "+num2+" es "+(num1+num2));
    }
    
    public static void restar(int num1, int num2) { // COPIA POR VALOR (SON VARIABLES DISTINTAT)
    	if(num1>=num2) {
    		System.out.println(num1+" menos "+num2+" es "+(num1-num2));
    	}
    	else System.out.println(num2+" menos "+num1+" es "+(num2-num1));
    }
    
    public static void multiplicar(int num1, int num2) { // COPIA POR VALOR (SON VARIABLES DISTINTAT)
    	System.out.println(num1+" multiplicado por "+num2+" es "+(num1*num2));
    }
    
    public static void dividir(int num1, int num2) { // COPIA POR VALOR (SON VARIABLES DISTINTAT)
    	if (num2 != 0) System.out.println("Resultado: " + (num1 / num2));
        else System.out.println("Error. El divisor no pueden ser cero");
    }
    
    public static void resto(int num1, int num2) { // COPIA POR VALOR (SON VARIABLES DISTINTAT)
    	 if (num2 != 0) System.out.println("Resultado: " + (num1 % num2));
         else System.out.println("Error: No se puede calcular el resto con divisor cero.");
    }
}
