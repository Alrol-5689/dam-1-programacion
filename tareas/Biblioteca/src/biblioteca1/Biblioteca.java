package biblioteca1;

import java.util.*;

public class Biblioteca {
	
	final static int FILAS_REVISTAS=100, COLUMNAS_REVISTAS=3;
	final static int FILAS_LIBROS=100, COLUMNAS_LIBROS=4;
	final static int FILAS_PELICULAS=100, COLUMNAS_PELICULAS=2;
	final static int FILAS_ABONADOS=100, COLUMNAS_ABONADOS=5;
	
	static String[][] revistas = new String[FILAS_REVISTAS][COLUMNAS_REVISTAS];
	static String[][] libros = new String[FILAS_LIBROS][COLUMNAS_LIBROS];
	static String[][] peliculas = new String[FILAS_PELICULAS][COLUMNAS_PELICULAS];
	static String[][] abonados = new String[FILAS_ABONADOS][COLUMNAS_ABONADOS];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcionMenu;
		Scanner sc = new Scanner(System.in);
		
		
		do {
			
			mostrarMenu();
			opcionMenu = sc.nextInt();
			menuOpciones(sc, opcionMenu);
			
		}while(opcionMenu!=6);

	}
	
	public static void mostrarMenu() {
		
		System.out.println("\nElije una de las opciones:\n"
				+"\n  1.- Isertar artículo o abonado."
				+"\n  2.- Eliminar artículo."
				+"\n  3.- Modificar artículo."
				+"\n  4.- Alquilar artículo."
				+"\n  5.- Devolver artículo."
				+"\n  6.- Salir.\n");
	}
	
	public static void menuOpciones (Scanner sc, int opcionMenu) {
		
		switch(opcionMenu) {
			case 1: System.out.println("¿Qué quieres introducir en el sistema?\n"
					+ "\n  1.- Un nuevo abonado"
					+ "\n  2.- Una película"
					+ "\n  3.- Una revista"
					+ "\n  4.- Un libro"
					+ "\n  5.- Volver al menú anterior"
					+ "\n  6.- Salir.\n");
			
				opcionMenu = sc.nextInt();
				
				if(opcionMenu==1) {
					
					isertarAbonado(abonados, sc);
					
				}else if(opcionMenu==2) {
					
					isertarPelicula(peliculas, sc);
					
				}else if(opcionMenu==3) {
					
					isertarRevista(revistas, sc);	
					
				}else if(opcionMenu==4) {
					
					isertarLibro(libros, sc);		
					
				}else if(opcionMenu==6) {
					
					System.out.println("Hasta la próxima.");
					
				}
				break;
			case 2: System.out.println("¿Qué quieres eliminar del sistema sistema?\n"
					+ "\n  1.- Un abonado"
					+ "\n  2.- Una película"
					+ "\n  3.- Una revista"
					+ "\n  4.- Un libro"
					+ "\n  5.- Salir");
				break;
			case 3: 
				break;
			case 4: 
				break;
			case 5: 
				break;
			case 6: System.out.println("\nHasta la próxima.");
				break;
			default: System.out.println("\nOpcion incorrecta.");
				break;
		}
	}
	
	public static void isertarAbonado(String[][] abonados, Scanner sc) {
		boolean abonado = false;
		for(int i=0; i<abonados.length;i++) {
			if(abonados[i][0]==null) {
				System.out.println("Introduce el Nombre del abonado:");
				abonados[i][0]=sc.next();
				System.out.println("Introduce el apellido paterno del abonado:");
				abonados[i][1]=sc.next();
				System.out.println("Introduce el apellido materno del abonado:");
				abonados[i][2]=sc.next();
				System.out.println("Introduce el teléfono del abonado:");
				abonados[i][3]=sc.next();
				System.out.println("Introduce el DNI del abonado:");
				abonados[i][4]=sc.next();
				abonado = true;
				break;
			}
		}
		if(!abonado) System.out.println("\n No se ha podido realizar la inscripción.");
	}
	
	public static void isertarPelicula(String[][] peliculas, Scanner sc) {
		boolean pelicula = false;
		for(int i=0; i<peliculas.length;i++) {
			if(peliculas[i][0]==null) {
				System.out.println("Introduce el título de la película:");
				peliculas[i][0]=sc.next();
				System.out.println("¿Cuántas unidades vas a introducir de esta película?");
				peliculas[i][1]=sc.next();
				pelicula = true;
				break;
			}
		}
		if(!pelicula) System.out.println("\n No se ha podido introducir la película.");
	}
	public static void isertarRevista(String[][] revistas, Scanner sc) {
		boolean revista = false;
		for(int i=0; i<revistas.length;i++) {
			if(revistas[i][0]==null) {
				System.out.println("Introduce el nombre del periódico:");
				revistas[i][0]=sc.next();
				System.out.println("¿Introduce la fehca del periódico (DD/MM/AAAA):");
				revistas[i][1]=sc.next();
				System.out.println("¿Cuántas unidades vas a introducir?");
				revistas[i][2]=sc.next();
				revista = true;
				break;
			}
		}
		if(!revista) System.out.println("\n No se ha podido introducir la revista.");
	}
	public static void isertarLibro(String[][] libros, Scanner sc) {
		boolean libro = false;
		for(int i=0; i<libros.length;i++) {
			if(libros[i][0]==null) {
				System.out.println("Introduce el ISBN del libro:");
				peliculas[i][0]=sc.next();
				System.out.println("Introduce el título del libro:");
				peliculas[i][1]=sc.next();
				System.out.println("¿Cuántas unidades vas a introducir?");
				peliculas[i][2]=sc.next();
				libro = true;
				break;
			}
		}
		if(!libro) System.out.println("\n No se ha podido introducir la revista.");
	}
}
