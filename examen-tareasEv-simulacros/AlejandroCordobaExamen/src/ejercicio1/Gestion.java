package ejercicio1;

import java.util.ArrayList;

public class Gestion {
	
	// Lectura l = new Lectura();
	Validador v = new Validador();
	ArrayList<Tren> listaTrenes = new ArrayList<>();
	
	Tren tren_1;
	Tren tren_2;
	
	protected void start() {
		
		try {
			tren_1 = new TrenPasajeros(1, "Pepito", 23, 23, 3);
			tren_2 = new TrenCarga(2, "Lolito", 23, 23, 2);
			v.validarTren(tren_1);
			v.validarTren(tren_2);
			listaTrenes.add(tren_1);
			listaTrenes.add(tren_2);
		}catch(TrenInvalidoExcepction e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		for(Tren t : listaTrenes) {
			System.out.println(t.mostrarInformacion());
		}
		
	}
	

}
