import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        int num1, num2;
        char ope;
        Scanner sc = new Scanner(System.in);
        boolean mas;
        
        do {

        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();

        System.out.print("Introduce la operación (+, -, *, /): ");
        ope = sc.next().charAt(0); // Obtenemos el primer carácter introducido

        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();

        // Usamos un switch para determinar la operación
        
        switch (ope) {
            case '+':
                System.out.println("Resultado: " + (num1 + num2));
                break;
            case '-':
                System.out.println("Resultado: " + (num1 - num2));
                break;
            case '*':
                System.out.println("Resultado: " + (num1 * num2));
                break;
            case '/':
                // Verificamos que no se divida entre cero
                if (num2 != 0) {
                    System.out.println("Resultado: " + ((double) num1 / num2));
                } else {
                    System.out.println("Error: No se puede dividir entre cero.");
                }
                break;
            default:
                System.out.println("Operación no válida.");
        }
        
        System.out.println("¿Quieres realizar otra operación?\n (S) --> Sí\n (N) --> No");
        ope = sc.next().charAt(0);
        
        if (ope=='s'||ope=='S') mas=true;
        else mas=false;
        
        }while(mas);
        
        sc.close(); // Cerramos el scanner
        
    }
}

