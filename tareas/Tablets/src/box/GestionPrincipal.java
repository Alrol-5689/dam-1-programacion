package box;

import java.util.*;
public class GestionPrincipal {
	
	// ATRIBUTOS
	
	protected Scanner sc = new Scanner(System.in);
	protected int opcionMenus;
	
	// *quizá es mejor crear los arrays en sus respectivas clases de gestión
	protected ArrayList<Tablet> arrayTablets = new ArrayList<>(); 
	protected ArrayList<Cliente> arrayClientes = new ArrayList<>();
	protected ArrayList<Reserva> arrayReservas = new ArrayList<>();
	protected ArrayList<Compra> arrayCompras = new ArrayList<>();
	
	// ATRIBUTOS DE LECTURA-ESCRITUTA
	
	protected LecturaEscritura le = new LecturaEscritura(); // los menús y las comprobaciones de DNI están aquí 
	
	protected LeTablet leTab = new LeTablet();
	protected LeCliente leCli = new LeCliente();
	protected LeCompra leCom = new LeCompra();
	protected LeReserva leRes = new LeReserva();
	
	// ATRIBUTOS DE GESTIÓN
	
	protected GeTablet geTab = new GeTablet();
	protected GeCliente geCli = new GeCliente();
	protected GeCompra geCom = new GeCompra();
	protected GeReserva geRes = new GeReserva();
	
	protected void gestionPrincipal() {
		
		do {			
			opcionMenus = le.mPrincipal();		
			
			switch(opcionMenus) {		
			
			case 1: // EDITAR STOCK		
				
						opcionMenus = le.mEditarStock();		
						
						switch(opcionMenus) {						
						case 1: geTab.nuevaTablet(arrayTablets);
							break;
						case 2: geTab.modificarTablet(leTab, arrayTablets, leRes, arrayReservas); // puedes modificar varias o una si el filtro se refina a 1 (filtrar por id)
							break;
						case 3: geTab.eliminarTablet(leTab, arrayTablets, arrayReservas); // puedes eliminar varias o una si el filtro se refina a 1 (filtrar por id)
							break;
						case 4: // VOLVER
							break;
						case 5: 
							System.out.println("\nHasta la próxima.");
							opcionMenus = 6;
							break;
						default: System.out.println("\nOpción no válida. Inténtalo de nuevo.");						
						}
						
				break;
				
			case 2: // EDITAR BDD CLIENTES
				
						opcionMenus = le.mEditarBDDClientes();	
						
						switch(opcionMenus) {						
						case 1: geCli.nuevoCliente(le, leCli, arrayClientes);
							break;
						case 2: geCli.modificarCliente(le, leCli, arrayClientes);
							break;
						case 3: geCli.eliminarCliente(leCli, arrayClientes, arrayReservas);
							break;
						case 4: geCli.desactivarCliente(leCli, arrayClientes);
							break;
						case 5: // volver
							break;
						case 6: 
							System.out.println("\nHasta la próxima.");
							opcionMenus = 6;
							break;
						default: System.out.println("\nOpción no válida. Inténtalo de nuevo.");						
						}	
						
				break;
				
			case 3: // CONSULTAR STOK Y TABLETS VENDIDAS
				
						opcionMenus = le.mConsultarStock();
						
						switch(opcionMenus) {
						case 1: leTab.mostrarTablets_disponibles(arrayTablets);
							break;
						case 2: leTab.mostrarTablets_reservadas(arrayReservas);
							break;
						case 3: leTab.mostrarTablets_vendidas(arrayCompras);
							break;
						case 4: leTab.mostrarTablets_todas(arrayTablets, arrayReservas, arrayCompras);
							break;
						case 5: // volver
							break;
						case 6:
							System.out.println("\nHasta la próxima.");
							opcionMenus = 6;
							break;
						default: System.out.println("\nOpción no válida. Inténtalo de nuevo.");
						}				
				
				break;
				
			case 4: // CONSULTAR BDD CLIENTE/S
				
				geCli.consultarCliente(leCli, arrayClientes, arrayCompras, arrayReservas);
							
				break;
				
			case 5: // COMPRAS Y RESERVAS
				
						opcionMenus = le.mComprasYReservas();
						
						switch(opcionMenus) {
						case 1: geCom.venderTablet(geCli, geTab, leCli, leTab, leRes, arrayTablets, arrayClientes, arrayCompras, arrayReservas);
							break;
						case 2: geCom.devolverTablet(geCli, leCli, arrayClientes, arrayCompras, arrayTablets);
							break;
						case 3: geRes.reservarTablet(geCli, leCli, geTab, leTab, leRes, arrayClientes, arrayTablets, arrayReservas);
							break;
						case 4: geRes.cancelarReserva(geCli, leCli, arrayClientes, arrayReservas);
							break;
						case 5: // volver
							break;
						case 6:
							System.out.println("\nHasta la próxima.");
							opcionMenus = 6;
							break;
						default: System.out.println("\nOpción no válida. Inténtalo de nuevo.");
						}
				break;
				
			case 6: System.out.println("\nHasta la próxima.");
				break;
				
			default: System.out.println("\n❌ Opción no válida. Inténtalo de nuevo.");			
			}	
			
		}while(opcionMenus != 6);
	}
		
}
	

	

	


