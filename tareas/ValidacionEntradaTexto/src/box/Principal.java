package box;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		String txt;
		Validador v = new Validador();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("Cuentame algo: ");
			
			try {
				
				txt = sc.nextLine();
				v.validarTxtEmpty(txt); // hay que poner este primero porque un empty siempre está en blanco
				v.validarTxtBlank(txt);
				System.out.println("Me has contado: "+txt);
				break;
				
			}catch(IsEmptyException | IsBlankException e) {
				
				System.err.println("Error: "+e.getMessage());
				
			}
		}
		
		sc.close();
		
	}

}
