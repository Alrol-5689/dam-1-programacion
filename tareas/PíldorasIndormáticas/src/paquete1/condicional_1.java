package paquete1;

import javax.swing.*;

public class condicional_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String clave="Alex";
		
		String pass="";
		
		while(clave.equals(pass)==false) {
			
			pass=JOptionPane.showInputDialog("Introduce la contraseña, por favor");
			
			if(clave.equals(pass)==false) {
				
				System.out.println("Contraseña incorrecta");
				
			}
			
		}
		
		System.out.println("Contraseña correcta. Acceso permitido");

	}

}
