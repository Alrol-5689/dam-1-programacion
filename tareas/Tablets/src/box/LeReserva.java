package box;

import java.util.*;

public class LeReserva {

	// ATRIBUTOS
	
	protected Scanner sc = new Scanner(System.in);
	
	// MÉTODOS
	
	// ¿podría hacer que este método comprobase si la tablet ya está reservada por otro cliente? ¿y de ser así que devuelva un boolean?
	// comprobar siempre que la tablet no esté reservada antes de usar este método!!!!!!!!
	protected void reservarTablet(Cliente cliente, Tablet tablet, ArrayList<Reserva> arrayReservas) {
		
		tablet.setDisponible(false);
		Reserva nuevaReserva = new Reserva(tablet, cliente); // este constructor aumenta id reserva, todo ok
		arrayReservas.add(nuevaReserva);				
	}
	protected void cancelarReserva(Tablet tablet, ArrayList<Reserva> arrayReservas) {
		
		for(int i=0; i < arrayReservas.size(); i++) {
			if (arrayReservas.get(i).tablet.equals(tablet)) {
	            arrayReservas.get(i).tablet.setDisponible(true);
	            arrayReservas.remove(i);
	            break; 
	        }
		}
		/*for(Reserva r : arrayReservas) {
			if(r.tablet.equals(tablet)) {
				r.tablet.setDisponible(true);
				arrayReservas.remove(r);
			}
		} SALTA EXCEPCION - no puedo usar for-each para eliminar objetos*/
	}
}
