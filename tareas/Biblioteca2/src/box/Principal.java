package box;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcionMenu;
		Scanner sc = new Scanner(System.in);

		ArrayList <Revistas> arrayRevistas = new ArrayList <>();
		ArrayList <Peliculas> arrayPeliculas = new ArrayList <>();
		ArrayList <Libros> arrayLibros = new ArrayList <>();
		ArrayList <Abonados> arrayAbonados = new ArrayList <>();	
		
		do {
			
			mostrarMenu();
			opcionMenu = sc.nextInt();
			sc.nextLine(); // LIMPIAR EL BUFFER
			menuOpciones(sc, opcionMenu, arrayRevistas, arrayPeliculas, arrayLibros, arrayAbonados);
			
		}while(opcionMenu!=11);

	}
	
	public static void mostrarMenu() {
			
			System.out.println("\nElije una de las opciones:\n"
					
					+"\n  1.- Isertar artículo"
					+"\n  2.- Modificar artículo."
					+"\n  3.- Eliminar artículo."
					+"\n  ------------------------------------"
					+"\n  4.- Alquilar artículo (libros o películas)."
					+"\n  5.- Devolver artículo (libros o películas)."
					+"\n  6.- Comprar revista."
					+"\n  ------------------------------------"
					+"\n  7.- Dar de alta a un abonado."
					+"\n  8.- Dar de baja a un abonado."
					+"\n  9.- Modificar los datos de un abonado."	
					+"\n  ------------------------------------"
					+"\n  10.- Volver al menú anterior."
					+"\n  11.- Salir.\n");
	}
	
	public static void menuOpciones (Scanner sc, int opcionMenu, ArrayList<Revistas> arrayRevistas,
    ArrayList<Peliculas> arrayPeliculas, ArrayList<Libros> arrayLibros, ArrayList<Abonados> arrayAbonados) {
		
		switch(opcionMenu) {
		
			case 1: // INSERTAR ARTÍCULO
				System.out.println("\n¿Qué artículo quieres introducir?\n"
						
					+"\n 1.- Un libro"
					+"\n 2.- Una revista"
					+"\n 3.- Una película"
					+"\n 4.- Volver al menú anterior"
					+"\n 5.- Salir\n");
		
				int opcionInsertar = sc.nextInt();
				sc.nextLine(); // LIMPIAR BUFFER
				
				switch(opcionInsertar) {
				case 1: añadirLibro(arrayLibros, sc);
					break;
				case 2: añadirRevista(arrayRevistas, sc);
					break;
				case 3: añadirPelicula(arrayPeliculas, sc);
					break;
				case 4: System.out.println("\nHola de nuevo.");
					break;
				case 5: 
					System.out.println("\nHasta la próxima.");
					opcionMenu=11;
					break;
				default: System.out.println("\nOpcion incorrecta.");
				}
				break;	
				
			case 2: // MODIFICAR ARTÍCULO
				System.out.println("¿Qué elemento quieres modificar?"

						+"\n 1.- Un libro"
						+"\n 2.- Una revista"
						+"\n 3.- Una película"
						+"\n 4.- Volver al menú anterior"
						+"\n 5.- Salir");
				
				int opcionModificar = sc.nextInt();
				sc.nextLine(); // LIMPIAR BUFFER
				
				switch(opcionModificar) {
				case 1: modificarLibro(arrayLibros, sc);
					break;
				case 2: modificarRevista(arrayRevistas, sc);
					break;
				case 3: modificarPelicula(arrayPeliculas, sc);
					break;
				case 4: System.out.println("\nHola de nuevo.");
					break;
				case 5:
					System.out.println("\nHasta la próxima.");
					opcionMenu=11;
					break;
				default: System.out.println("\nOpcion incorrecta.");
				}
				break;
				
			case 3: // ELIMINAR ARTÍCULO
				System.out.println("¿Qué elemento quieres eliminar?"

						+"\n 1.- Un libro"
						+"\n 2.- Una revista"
						+"\n 3.- Una película"
						+"\n 4.- Volver al menú anterior"
						+"\n 5.- Salir");
				
				int opcionEliminar = sc.nextInt();
				sc.nextLine(); // LIMPIAR BUFFER
				
				switch(opcionEliminar) {
				case 1: eliminarLibro(arrayLibros, sc);
					break;
				case 2: eliminarRevista(arrayRevistas, sc);
					break;
				case 3: eliminarPelicula(arrayPeliculas, sc);
					break;
				case 4: System.out.println("\nHola de nuevo.");
					break;
				case 5:
					System.out.println("\nHasta la próxima.");
					opcionMenu=11;
					break;
				default: System.out.println("\nOpcion incorrecta.");
				}
				break;
				
			case 4: // ALQUILAR ARTÍCULO (PELÍCULAS Y LIBROS)
				System.out.println("\n¿Qué elemento quieres alquilar?\n"

						+"\n 1.- Un libro"
						+"\n 2.- Una película"
						+"\n 3.- Volver al menú anterior"
						+"\n 4.- Salir\n");
						
		
				int opcionAlquilar = sc.nextInt();
				sc.nextLine(); // LIMPIAR BUFFER
				
				switch(opcionAlquilar) {
				case 1: alquilarLibro(arrayLibros, arrayAbonados, sc);
					break;
				case 2: alquilarPelicula(arrayPeliculas, arrayAbonados, sc);
					break;
				case 3: System.out.println("\nHola de nuevo.");
					break;
				case 4:
					System.out.println("\nHasta la próxima.");
					opcionMenu=11;
					break;
				default: System.out.println("\nOpcion incorrecta.");
				}
				break;
				
			case 5: // DEVOLVER ARTÍCULO
				System.out.println("¿Qué elemento quieres devolver?"

						+"\n 1.- Un libro"
						+"\n 2.- Una película"
						+"\n 3.- Volver al menú anterior"
						+"\n 4.- Salir");	
		
				int opcionDevolver = sc.nextInt();
				sc.nextLine(); // LIMPIAR BUFFER
				
				switch(opcionDevolver) {
				case 1: devolverLibro(arrayLibros, arrayAbonados, sc);
					break;
				case 2: devolverPelicula(arrayPeliculas, arrayAbonados, sc);
					break;
				case 3: System.out.println("\nHola de nuevo.");
					break;
				case 4:
					System.out.println("\nHasta la próxima.");
					opcionMenu=11;
					break;
				default:
				}
				break;
			case 6: // comprarRevista(sc, opcionMenu, arrayRevistas);
				break;
			case 7: nuevoAbonado(arrayAbonados, sc);
				break;
			case 8: bajaAbonado(arrayAbonados, sc);
				break;
			case 9: modificarAbonado(arrayAbonados, sc);
				break;
			case 10: System.out.println("\nHola de nuevo.\n");
				break;
			case 11: System.out.println("\nHasta la próxima.");
				break;
			default: System.out.println("\nOpcion incorrecta.");
				break;
		}
	}
	
	// MÉTODOS PARA INSERTAR ELEMENTOS
	
	public static void añadirLibro(ArrayList<Libros> arrayLibros, Scanner sc) {
	    
	    System.out.print("\nIntroduce el título del libro: ");
	    String titulo = sc.nextLine();
	    
	    System.out.print("\nIntroduce el autor del libro: ");
	    String autor = sc.nextLine();
	    
	    System.out.print("\nIntroduce el año del libro: ");
	    int anyo = sc.nextInt();
	    sc.nextLine(); // LIMPIAR BUFFER
	    
	    System.out.print("\nIntroduce el ISBN del libro: ");
	    String isbn = sc.nextLine();    
	    
	    System.out.print("\n¿Cuántas unidades vas a añadir a la biblioteca?");
	    int unidades = sc.nextInt();
	    sc.nextLine(); // limpiar buffer
	    
	    if (unidades <= 0) {
	        System.out.println("\nEl número de unidades debe ser mayor que 0.");
	        return;
	    }
	    
	    for(int i=0; i<unidades; i++) {
	    	Libros nuevoL = new Libros(titulo, autor, anyo, isbn);
	    	arrayLibros.add(nuevoL);
	    	System.out.println("Unidad "+(i+1)+ " añadida correctamente: "+nuevoL.getMostrarDetalles());
	    }
	}
	
	public static void añadirRevista(ArrayList<Revistas> arrayRevistas, Scanner sc) {
	    
	    System.out.println("Introduce el nombre de la revista: ");
	    String nombre = sc.nextLine();
	    
	    System.out.println("Introduce el año: ");
	    int anyo = sc.nextInt();
	    
	    System.out.println("Introduce el mes: ");
	    int mes = sc.nextInt();
	    
	    System.out.println("Introduce el dia: ");
	    int dia = sc.nextInt();
	    
	    Revistas nuevaRevista = new Revistas(nombre, anyo, mes-1, dia);
	    
	    arrayRevistas.add(nuevaRevista);

	    System.out.println("Revista añadido correctamente: " + nuevaRevista.getPeriodico());
	}
	
	public static void añadirPelicula(ArrayList<Peliculas> arrayPeliculas, Scanner sc) {
	    
	    System.out.println("Introduce el título de la película: ");
	    String titulo = sc.nextLine();
	    
	    System.out.println("Introduce el director: ");
	    String director = sc.nextLine();
	    
	    System.out.println("Introduce el año: ");
	    int anyo = sc.nextInt();
	    
	    Peliculas nuevaPelicula = new Peliculas(titulo, director, anyo);
	    
	    arrayPeliculas.add(nuevaPelicula);

	    System.out.println("Revista añadido correctamente: " + nuevaPelicula.getTitulo());
	}
	
	// MÉTODOS PARA MODIFICAR ARTÍCULOSA
	
	public static void modificarLibro(ArrayList<Libros> arrayLibros, Scanner sc) {
		
		// BUSCAMOS EL LIBRO A MODIFICAR
		
		System.out.println("Introduce el título del libro que deseas modificar: ");
		String titulo = sc.nextLine();
		ArrayList<Libros> librosCoincidentes = new ArrayList<>();
		
		for(Libros e: arrayLibros) {
			if(e.getTitulo().equalsIgnoreCase(titulo)) {
				librosCoincidentes.add(e);
			}
		}
		
		// CONTROLAMOS CUANDO NO HAY COINCIDENCIAS
		
		if (librosCoincidentes.isEmpty()) {
	        System.out.println("No se encontraron libros con el título: " + titulo);
	        return;
	    }
		
		// LISTAR LAS UNIDADES COINCIDENTES
		
		System.out.println("Se encontraron las siguientes unidades del libro:");
		for(int i=0; i<librosCoincidentes.size(); i++) {
			Libros libro = librosCoincidentes.get(i);
			System.out.println((i+1)+".- ID: "+libro.getId()+", título: "+libro.getTitulo()
			+", autor: "+libro.getAutor()+", año: "+libro.getAnyo()+", ISBN: "+libro.getIsbn());
		}
		
		// PREGUNTAR CUAL MODIFICAR
		
		System.out.println("Introduce el número que deseas eliminar: ");
		int opcion = sc.nextInt();
		sc.nextLine(); // LIMPIAR EL BUFFER
		if(opcion<1 || opcion>librosCoincidentes.size()) {
			System.out.println("Opción inválida. No se eliminó ningún libro.");
			return;
		}
		
		// MODIFICAR
		
		Libros libroAModificar = librosCoincidentes.get(opcion-1);
		System.out.println("Introduce los nuevos valores (deja en blanco los valor a conservar): ");
		System.out.println("Título actual: " + libroAModificar.getTitulo());
	    System.out.print("Nuevo título: ");
	    String nuevoTitulo = sc.nextLine();
	    if (!nuevoTitulo.isBlank()) {
	        libroAModificar.setTitulo(nuevoTitulo);
	    }
	    System.out.println("Autor actual: " + libroAModificar.getAutor());
	    System.out.print("Nuevo autor: ");
	    String nuevoAutor = sc.nextLine();
	    if (!nuevoAutor.isBlank()) {
	        libroAModificar.setAutor(nuevoAutor);
	    }
	    System.out.println("Año actual: " + libroAModificar.getAnyo());
	    System.out.print("Nuevo año: ");
	    String nuevoAnyo = sc.nextLine();
	    if (!nuevoAnyo.isBlank()) {
	    	try {
	    		int anyoNuevoInt = Integer.parseInt(nuevoAnyo);
	    		libroAModificar.setAnyo(anyoNuevoInt);
	    	}catch(NumberFormatException e) {
	    		System.out.println("Año inválido. No se modificó.");
	    	}      
	    }
	    System.out.println("ISBN actual: " + libroAModificar.getIsbn());
	    System.out.print("Nuevo ISBN: ");
	    String nuevoIsbn = sc.nextLine();
	    if (!nuevoIsbn.isBlank()) {
	        libroAModificar.setIsbn(nuevoIsbn);
	    }
	    System.out.println("Libro modificado correctamente.");
		
	}
	
	public static void modificarRevista(ArrayList<Revistas> arrayRevistas, Scanner sc) {
		
		// PEDIMOS LOS DATOS DE LA REVISTA A MODIFICAR
		
		System.out.println("Introduce la revista que deseas modificar: ");
		String revista = sc.nextLine();
		
		System.out.println("Introduce el año de la revista:");
		int anyo = sc.nextInt();
		
		System.out.println("Introduce el mes de la revista:");
		int mes = sc.nextInt();
		
		System.out.println("Introduce el día de la revista:");
		int dia = sc.nextInt();
		
		sc.nextLine(); // LIMPIAR BUFFER
		
		GregorianCalendar fechaIngresada = new GregorianCalendar(anyo, mes - 1, dia);
	    Date fechaBusqueda = fechaIngresada.getTime();
	    
	    // BUSCAMOS LAS COINCIDENCIAS Y LAS LISTAMOS
	    
	    ArrayList<Revistas> revistasCoincidentes = new ArrayList<>();
	    for(Revistas e: arrayRevistas) {
	    	if(e.periodico.equalsIgnoreCase(revista) && e.diaRevista.equals(fechaBusqueda)) {
	    		revistasCoincidentes.add(e);
	    	}
	    }
	    if (revistasCoincidentes.isEmpty()) {
	        System.out.println("No se encontraron revistas del periódico '" + revista + "' con la fecha especificada.");
	        return;
	    }
	    System.out.println("Se encontraron las siguientes revistas:");
	    for (int i = 0; i < revistasCoincidentes.size(); i++) {
	        Revistas revista_M = revistasCoincidentes.get(i);
	        System.out.println((i + 1) + ".- ID: " + revista_M.id + ", Periódico: " + revista_M.periodico
	                + ", Fecha: " + revista_M.diaRevista);
	    }
	    
	    // MODIFICAMOS LOS CAMPOS
	    
	    System.out.println("Introduce el número de la revista que deseas modificar:");
	    int opcion = sc.nextInt();
	    sc.nextLine(); // LIMPIAR BUFFER

	    if (opcion < 1 || opcion > revistasCoincidentes.size()) {
	        System.out.println("Opción inválida. No se modificó ninguna revista.");
	        return;
	    }
	    Revistas revistaAModificar = revistasCoincidentes.get(opcion - 1);
	    System.out.println("Introduce los nuevos valores (deja en blanco para conservar los actuales):");
	    System.out.println("Periódico actual: " + revistaAModificar.periodico);
	    System.out.print("Nuevo periódico: ");
	    String nuevoPeriodico = sc.nextLine();
	    if (!nuevoPeriodico.isBlank()) {
	        revistaAModificar.periodico = nuevoPeriodico;
	    }
	    System.out.println("Fecha actual: " + revistaAModificar.diaRevista);
	    System.out.print("¿Deseas modificar la fecha? (s/n): ");
	    String modificarFecha = sc.nextLine();
	    if(modificarFecha.equalsIgnoreCase("s")) {
	    	System.out.println("Introduce el nuevo año:");
	        int nuevoAnyo = sc.nextInt();
	        System.out.println("Introduce el nuevo mes (1-12):");
	        int nuevoMes = sc.nextInt();
	        System.out.println("Introduce el nuevo día:");
	        int nuevoDia = sc.nextInt();
	        sc.nextLine();
	        GregorianCalendar nuevaFecha = new GregorianCalendar(nuevoAnyo, nuevoMes - 1, nuevoDia);
	        revistaAModificar.diaRevista = nuevaFecha.getTime();
	    }
	    System.out.println("Revista modificada correctamente.");		
	}
	
	public static void modificarPelicula(ArrayList<Peliculas> arrayPeliculas, Scanner sc) {
		
		System.out.println("Introduce el título de la película a modificar: ");
		String titulo = sc.nextLine();
		ArrayList<Peliculas> peliculasCoincidentes = new ArrayList<>();
		
		for(Peliculas e: arrayPeliculas) {
			if(e.getTitulo().equalsIgnoreCase(titulo)) {
				peliculasCoincidentes.add(e);
			}
		}
		if(peliculasCoincidentes.isEmpty()) {
			System.out.println("No se han encontrado películas con el título "+titulo);
		}
		System.out.println("Se encontraron las siguientes unidades de la película: ");
		for(int i=0; i<peliculasCoincidentes.size(); i++) {
			Peliculas pelicula = peliculasCoincidentes.get(i);
			System.out.println((i+1)+".- ID: "+pelicula.getId()+", título: "+pelicula.getTitulo()
			+", director: "+pelicula.getDirector()+", año: "+pelicula.getAnyo());
		}
		// PREGUNTAR CUAL MODIFICAR
		System.out.println("Introduce el número que deseas modificar: ");
		int opcion = sc.nextInt();
		sc.nextLine(); // LIMPIAR EL BUFFER
		if(opcion<1 || opcion>peliculasCoincidentes.size()) {
			System.out.println("Opción inválida. No se modificó ninguna película.");
			return;
		}
		
		// MODIFICAMOS PELÍCULA
		Peliculas peliculaAModificar = peliculasCoincidentes.get(opcion-1);
		System.out.println("Introduce los nuevos valores (deja en blanco los valor a conservar): ");
		System.out.println("Título actual: " + peliculaAModificar.getTitulo());
	    System.out.print("Nuevo título: ");
	    String nuevoTitulo = sc.nextLine();
	    if (!nuevoTitulo.isBlank()) {
	        peliculaAModificar.setTitulo(nuevoTitulo);
	    }
		System.out.println("Director actual: " + peliculaAModificar.getDirector());
	    System.out.print("Nuevo título: ");
	    String nuevoDirector = sc.nextLine();
	    if (!nuevoDirector.isBlank()) {
	        peliculaAModificar.setDirector(nuevoDirector);
	    }
	    System.out.println("Año actual: " + peliculaAModificar.getAnyo());
	    System.out.print("Nuevo año: ");
	    String nuevoAnyo = sc.nextLine();
	    int nuevoAnyoInt=0;
	    if (!nuevoAnyo.isBlank()) {
	    	try {
	    		nuevoAnyoInt = Integer.parseInt(nuevoAnyo);
	    	}catch(NumberFormatException e) {
	    		System.out.println("Año inválido. No se modificó.");
	    	}
	        peliculaAModificar.setAnyo(nuevoAnyoInt);
	    }
	    System.out.println("Película modificada correctamente.");
	}
	
	// MÉTODOS PARA ELIMINAR ELEMENTOS
	
	public static void eliminarLibro(ArrayList<Libros> arrayLibros, Scanner sc) {
		
		System.out.println("Introduce el título del libro que deseas eliminar: ");
		String titulo = sc.nextLine();
		ArrayList<Libros> librosCoincidentes = new ArrayList<>();
		
		for(Libros e: arrayLibros) {
			if(e.getTitulo().equalsIgnoreCase(titulo)) {
				librosCoincidentes.add(e);
			}
		}
		// CONTROLAMOS CUANDO NO HAY COINCIDENCIAS
		if(librosCoincidentes.isEmpty()) {
			System.out.println("No se encontraron libros con el título "+titulo);
			return;
		}
		// LISTAR LAS UNIDADES COINCIDENTES
		System.out.println("Se encontraron las siguientes unidades del libro:");
		for(int i=0; i<librosCoincidentes.size(); i++) {
			Libros libro = librosCoincidentes.get(i);
			System.out.println((i+1)+".- ID: "+libro.getId()+", título: "+libro.getTitulo()
			+", autor: "+libro.getAutor()+", año: "+libro.getAnyo()+", ISBN: "+libro.getIsbn());
		}
		// PREGUNTAR CUAL ELIMINAR
		System.out.println("Introduce el número que deseas eliminar: ");
		int opcion = sc.nextInt();
		sc.nextLine(); // LIMPIAR EL BUFFER
		if(opcion<1 || opcion>librosCoincidentes.size()) {
			System.out.println("Opción inválida. No se eliminó ningún libro.");
	        return;
		}
		// ELIMINAR LIBRO
		Libros libroAEliminar = librosCoincidentes.get(opcion-1);
		arrayLibros.remove(libroAEliminar);
		System.out.println("Libro eliminado correctamente: ID " + libroAEliminar.getId());
	}
	
	public static void eliminarRevista(ArrayList<Revistas> arrayRevistas, Scanner sc) {
		
		// PEDIMOS LOS DATOS DE LA REVISTA A ELIMINAR
		
		System.out.println("Introduce la revista que deseas eliminar: ");
		String revista = sc.nextLine();
				
		System.out.println("Introduce el año de la revista:");
		int anyo = sc.nextInt();
				
		System.out.println("Introduce el mes de la revista:");
		int mes = sc.nextInt();
				
		System.out.println("Introduce el día de la revista:");
		int dia = sc.nextInt();
				
		sc.nextLine(); // LIMPIAR BUFFER
				
		GregorianCalendar fechaIngresada = new GregorianCalendar(anyo, mes - 1, dia);
	    Date fechaBusqueda = fechaIngresada.getTime();
			    
	    // BUSCAMOS LAS COINCIDENCIAS Y LAS LISTAMOS
			    
	    ArrayList<Revistas> revistasCoincidentes = new ArrayList<>();
	    for(Revistas e: arrayRevistas) {
			if(e.periodico.equalsIgnoreCase(revista) && e.diaRevista.equals(fechaBusqueda)) {
			    revistasCoincidentes.add(e);
			}
		 }
		 if (revistasCoincidentes.isEmpty()) {
			 System.out.println("No se encontraron revistas del periódico '" + revista + "' con la fecha especificada.");
			 return;
		 }
		 System.out.println("Se encontraron las siguientes revistas:");
		 for (int i = 0; i < revistasCoincidentes.size(); i++) {
			 Revistas revista_E = revistasCoincidentes.get(i);
			 System.out.println((i + 1) + ".- ID: " + revista_E.id + ", Periódico: " + revista_E.periodico
			                + ", Fecha: " + revista_E.diaRevista);
		 }
			    
		// PEDIMOS CUAL ELIMINAR
			    
		System.out.println("Introduce el número de la revista que deseas eliminar:");
		int opcion = sc.nextInt();
		sc.nextLine(); // LIMPIAR BUFFER

		if (opcion < 1 || opcion > revistasCoincidentes.size()) {
			System.out.println("Opción inválida. No se eliminó ninguna revista.");
			return;
		 }
		
		// ELIMINAMOS LA REVISTA
		
		Revistas revistaAEliminar = revistasCoincidentes.get(opcion-1);
		arrayRevistas.remove(revistaAEliminar);
		
		System.out.println("Revista eliminada correctamente: ID " + revistaAEliminar.id + ", Periódico: "
	            + revistaAEliminar.periodico + ", Fecha: " + revistaAEliminar.diaRevista);
		
	}
	
	public static void eliminarPelicula(ArrayList<Peliculas> arrayPeliculas, Scanner sc) {
		
		System.out.println("Introduce el título de la películaque deseas elimianr");
		String titulo = sc.nextLine();
		ArrayList<Peliculas> peliculasCoincidentes = new ArrayList<>();
		for(Peliculas e: arrayPeliculas) {
			if(e.titulo.equalsIgnoreCase(titulo)) {
				peliculasCoincidentes.add(e);
			}
		}
		if(peliculasCoincidentes.isEmpty()) {
			System.out.println("No se encontraron coincidencias con la película "+titulo);
			 return;
		}
		System.out.println("Se encontraron las siguientes películas:");
		 for (int i = 0; i < peliculasCoincidentes.size(); i++) {
			 Peliculas pelicula_E = peliculasCoincidentes.get(i);
			 System.out.println((i + 1) + ".- ID: " + pelicula_E.id + ", Director: " + pelicula_E.director
			                + ", año: " + pelicula_E.anyo);
		 }
		 // PEDIMOS CUAL ELIMINAR
		 System.out.println("Introduce el número de la película que deseas eliminar");
		 int opcion = sc.nextInt();
		 sc.nextLine();
		 if(opcion<1 || opcion > peliculasCoincidentes.size()) {
			 System.out.println("Opción inválida. No se eliminó ninguna película.");
			 return;
		 }
		 // ELIMINAMOS LA PELÍCULA
		 Peliculas peliculaAEliminar = peliculasCoincidentes.get(opcion-1);
		 arrayPeliculas.remove(peliculaAEliminar);
		 
		 System.out.println("Película eliminada correctamente: ID " + peliculaAEliminar.id + ", Director: "
		            + peliculaAEliminar.director + ", año: " + peliculaAEliminar.anyo);	
	}
	
	public static void venderRevista(ArrayList<Revistas> arrayRevistas, Scanner sc) {
		
		System.out.println("Introduce el nombre de la revista que se van a comprar: ");
		String entrada = sc.nextLine();
		ArrayList<Revistas> revistasCoincidentes = new ArrayList<>();
		Date diaRevista = null;
		Revistas revistaSeleccionada = null;
				
		for(Revistas a: arrayRevistas) {
			if(a.getPeriodico().equalsIgnoreCase(entrada)) {
				revistasCoincidentes.add(a);
			}
		}
		if(revistasCoincidentes.isEmpty()) {
			System.out.println("No se han encontrado coincidencias.");
			return;
		}
		System.out.println("Introduce el año de la revista: ");
		int anyo = sc.nextInt();
		sc.nextLine(); // clean buffer
		
		System.out.println("Introduce el mes de la revista: ");
		int mes = sc.nextInt();
		sc.nextLine(); // clean buffer
		
		System.out.println("Introduce el día de la revista: ");
		int dia = sc.nextInt();
		sc.nextLine(); // clean buffer
		
		GregorianCalendar d = new GregorianCalendar(anyo, mes-1, dia);
		diaRevista = d.getTime();
		
		for(Revistas a: revistasCoincidentes) {
			if(a.getDiaRevista().equals(diaRevista)) {
				revistaSeleccionada = a;
				break;
			}
		}
		if(revistaSeleccionada == null) {
			System.out.println("No hay unidades con la fecha "+diaRevista);
			return;
		}
		arrayRevistas.remove(revistaSeleccionada);
		System.out.println("La revista " + revistaSeleccionada.getMostrarDetalles()+ " ha sido vendida.");
	}
	
	// MÉTODOS PARA ALQUILAR LIBROS Y PELÍCULAS
	
	public static void alquilarLibro(ArrayList<Libros> arrayLibros, ArrayList<Abonados> arrayAbonados, Scanner sc) {
		
		ArrayList<Abonados> abonadosInscritos = new ArrayList<>();
		
		// Buscamos el abonado que va a alquilar el libro:
		
		for(Abonados a : arrayAbonados) { // Introduzco los inscritos en la lista "abonadosInscritos"
			if(a.isInscrito()) {
				abonadosInscritos.add(a);
			}
		}
		if(abonadosInscritos.isEmpty()) { // Salgo del método al no haber abonados inscritos
			System.out.println("Debe de haber abonados inscritos.");
			return;
		}
		Abonados.listarAbonadosInscritos(arrayAbonados); // Listo los abonados inscritos
		System.out.println("Introduce el nombreo o el ID del abonado:"); // Pido nombre/id
		String entrada = sc.nextLine();
	    Abonados aSeleccionado = null;
		    
		try { // Si es un número es que me ha dado el ID y ya tengo al abonado
			int idBuscado = Integer.parseInt(entrada);
			for(Abonados a: abonadosInscritos) {
				if(a.getId() == idBuscado) {
					aSeleccionado = a;
					break;
				}
			}
		}catch(NumberFormatException e) {  // Si no es un número almaceno a todos coincidentes en "abonadosCoincidentes"
			ArrayList<Abonados> abonadosCoincidentes = new ArrayList<>();
			for(Abonados a: abonadosInscritos) { 
				if(a.getNombre().equalsIgnoreCase(entrada)) {
					abonadosCoincidentes.add(a);
				}
			}
			if(abonadosCoincidentes.isEmpty()) {
				System.out.println("No se encontraron abonados inscritos con el nombre "+entrada+". ");
			}else if(abonadosCoincidentes.size() == 1) {
				aSeleccionado = abonadosCoincidentes.get(0);
			}else if(abonadosCoincidentes.size() > 1) {
				System.out.println("Se encontraron varios abonados con ese nombre:");
				for(int i=0; i<abonadosCoincidentes.size(); i++) {
					Abonados a = abonadosCoincidentes.get(i);
					System.out.println((i+1)+".- "+a.getMostrarDetalles());
				}
				System.out.println("Selecciona el número del abonado: ");
				int seleccion = sc.nextInt();
				sc.nextLine(); // clan buffer
				if(seleccion < 1 || seleccion > abonadosCoincidentes.size()) {
					System.out.println("Opción inválida\n");
					return;
				}
				aSeleccionado = abonadosCoincidentes.get(seleccion-1);
			}
		}
		if(aSeleccionado == null) {
			System.out.println("No se encontró un abonado con ese nombre o ID.");
			return;
		}	    
	    
	    // Buscamos el libro que va a ser alquilado:
	    
	    System.out.println("Introduce el título del libro que va a ser alquilado:");
	    String tituloLibro = sc.nextLine();
	    ArrayList<Libros> librosCoincidentes = new ArrayList<>();
	    for(Libros e: arrayLibros) {
	    	if(e.getTitulo().equalsIgnoreCase(tituloLibro) && !e.isAlquilado()) {
	    		librosCoincidentes.add(e);
	    	}
	    }
	    if(librosCoincidentes.isEmpty()) {
	    	System.out.println("No hay libros disponibles con ese título.");
	        return;
	    }
	    System.out.println("Libros disponibles:");
	    for(int i=0; i<librosCoincidentes.size(); i++) {
	    	System.out.println((i+1)+".- "+librosCoincidentes.get(i).getMostrarDetalles());
	    }
	    System.out.println("Selecciona el número del libro que deseas alquilar:");
	    int opcion = sc.nextInt();
	    sc.nextLine(); // clean buffer
	    
	    if (opcion < 1 || opcion > librosCoincidentes.size()) {
	        System.out.println("Opción inválida.");
	        return;
	    }
	    Libros libroSeleccionado = librosCoincidentes.get(opcion - 1);
	    
	    // ACTUALIZAR ESTADO Y ASIGNAR AL ABONADO
	    
	    libroSeleccionado.setAlquilado(true);
	    aSeleccionado.setAlquilarLibro(libroSeleccionado);
	    // abonado.getArticulosAlquilados().add(libroSeleccionado);
	    System.out.println("El libro '" + libroSeleccionado.getTitulo() 
	    + "' ha sido alquilado por " + aSeleccionado.getNombre());
	}
	
	public static void alquilarPelicula(ArrayList<Peliculas> arrayPeliculas, ArrayList<Abonados> arrayAbonados, Scanner sc) {
		
		ArrayList<Abonados> abonadosInscritos = new ArrayList<>();
		
		// Buscamos el abonado que va a alquilar la película:
		
		for(Abonados a : arrayAbonados) { // Introduzco los inscritos en la lista "abonadosInscritos"
			if(a.isInscrito()) {
				abonadosInscritos.add(a);
			}
		}
		if(abonadosInscritos.isEmpty()) { // Salgo del método al no haber abonados inscritos
			System.out.println("Debe de haber abonados inscritos.");
			return;
		}
		Abonados.listarAbonadosInscritos(arrayAbonados); // Listo los abonados inscritos
		System.out.println("Introduce el nombreo o el ID del abonado:"); // Pido nombre/id
		String entrada = sc.nextLine();
	    Abonados aSeleccionado = null;
		    
		try { // Si es un número es que me ha dado el ID y ya tengo al abonado
			int idBuscado = Integer.parseInt(entrada);
			for(Abonados a: abonadosInscritos) {
				if(a.getId() == idBuscado) {
					aSeleccionado = a;
					break;
				}
			}
		}catch(NumberFormatException e) {  // Si no es un número almaceno a todos coincidentes en "abonadosCoincidentes"
			ArrayList<Abonados> abonadosCoincidentes = new ArrayList<>();
			for(Abonados a: abonadosInscritos) { 
				if(a.getNombre().equalsIgnoreCase(entrada)) {
					abonadosCoincidentes.add(a);
				}
			}
			if(abonadosCoincidentes.isEmpty()) {
				System.out.println("No se encontraron abonados inscritos con el nombre "+entrada+". ");
			}else if(abonadosCoincidentes.size() == 1) {
				aSeleccionado = abonadosCoincidentes.get(0);
			}else if(abonadosCoincidentes.size() > 1) {
				System.out.println("Se encontraron varios abonados con ese nombre:");
				for(int i=0; i<abonadosCoincidentes.size(); i++) {
					Abonados a = abonadosCoincidentes.get(i);
					System.out.println((i+1)+".- "+a.getMostrarDetalles());
				}
				System.out.println("Selecciona el número del abonado: ");
				int seleccion = sc.nextInt();
				sc.nextLine(); // clan buffer
				if(seleccion < 1 || seleccion > abonadosCoincidentes.size()) {
					System.out.println("Opción inválida\n");
					return;
				}
				aSeleccionado = abonadosCoincidentes.get(seleccion-1);
			}
		}
		if(aSeleccionado == null) {
			System.out.println("No se encontró un abonado con ese nombre o ID.");
			return;
		}
		
		// BUSCAR PELÍCULAS DISPONIBLES Y LISTARLAS
	    
	    System.out.println("Introduce el título de la película que va a ser alquilada:");
	    String tituloPelicula = sc.nextLine();
	    ArrayList<Peliculas> peliculasCoincidentes = new ArrayList<>();
	    for(Peliculas e: arrayPeliculas) {
	    	if(e.getTitulo().equalsIgnoreCase(tituloPelicula) && !e.isAlquilada()) {
	    		peliculasCoincidentes.add(e);
	    	}
	    }
	    if(peliculasCoincidentes.isEmpty()) {
	    	System.out.println("No hay libros disponibles con ese título.");
	        return;
	    }
	    System.out.println("Libros disponibles:");
	    for(int i=0; i<peliculasCoincidentes.size(); i++) {
	    	System.out.println((i+1)+".- "+peliculasCoincidentes.get(i).getMostrarDetalles());
	    }
	    System.out.println("Selecciona el número de la película que deseas alquilar:");
	    int opcion = sc.nextInt();
	    sc.nextLine(); // clean buffer
	    
	    if (opcion < 1 || opcion > peliculasCoincidentes.size()) {
	        System.out.println("Opción inválida.");
	        return;
	    }
	    Peliculas peliculaSeleccionada = peliculasCoincidentes.get(opcion - 1);
	    peliculaSeleccionada.setAlquilada(true);
	    aSeleccionado.setAlquilarPelicula(peliculaSeleccionada);
	    System.out.println("La película '" + peliculaSeleccionada.getTitulo() 
	    + "' ha sido alquilado por " + aSeleccionado.getNombre());
	    
	    
	}
	
	public static void mostrarArticulosAbonado(ArrayList<Abonados> arrayAbonados, Scanner sc) {

	    // INTENTAMOS OBTENER EL ABONADO POR NOMBRE O POR ID
		
		System.out.println("Introduce el nombre o ID del abonado para mostrar sus artículos alquilados:");
	    String entrada = sc.nextLine();
	    Abonados aSeleccionado = null;
	    ArrayList<Abonados> abonadosCoincidentes = new ArrayList<>();
	    
	    try {
	        int idBuscado = Integer.parseInt(entrada);
	        for (Abonados a : arrayAbonados) {
	            if (a.getId() == idBuscado) {
	                aSeleccionado = a;
	                break;
	            }
	        }
	    } catch (NumberFormatException e) {
	        for (Abonados a : arrayAbonados) {
	            if (a.getNombre().equalsIgnoreCase(entrada)) {
	                abonadosCoincidentes.add(a);
	            }
	        }
	        if(abonadosCoincidentes.size()==1) {
	        	aSeleccionado = abonadosCoincidentes.get(0);
	        }else if(abonadosCoincidentes.size()>1) {
	        	System.out.println("Se encontraron varios abonados con ese nombre:");
	        	for(int i=0; i<abonadosCoincidentes.size(); i++) {
	        		Abonados a = abonadosCoincidentes.get(i);
	        		System.out.println((i+1)+".- "+a.getMostrarDetalles());
	        	}
	        	System.out.print("Selecciona el número del abonado: ");
	            int seleccion = sc.nextInt();
	            sc.nextLine(); // clean buffer
	            if(seleccion<1 || seleccion>abonadosCoincidentes.size()) {
	            	System.out.println("Opción inválida.");
	            	return;
	            }
	            aSeleccionado = abonadosCoincidentes.get(seleccion-1);
	        }
	    }	    
	    if (aSeleccionado == null) {
	        System.out.println("No se encontró un abonado con ese nombre o ID.");
	        return;
	    }  
	    System.out.println("Mostrando artículos alquilados para: " + aSeleccionado.getMostrarDetalles());
	    if (aSeleccionado.getLibrosAlquilados().isEmpty() && aSeleccionado.getPeliculasAlquiladas().isEmpty()) {
	        System.out.println("Este abonado no tiene ningún artículo alquilado.");
	        return;
	    }

	    // LISTAR LIBROS ALQUILADOS
	    if (!aSeleccionado.getLibrosAlquilados().isEmpty()) {
	        System.out.println("Libros alquilados:");
	        for (Libros l: aSeleccionado.getLibrosAlquilados()) {
	            System.out.println("- " + l.getMostrarDetalles());
	        }
	    }
	    // LISTAR PELÍCULAS ALQUILADAS
	    if (!aSeleccionado.getPeliculasAlquiladas().isEmpty()) {
	        System.out.println("Películas alquiladas:");
	        for (Peliculas p: aSeleccionado.getPeliculasAlquiladas()) {
	            System.out.println("- Título: " + p.getTitulo() + ", Director: " + p.getDirector() +
	                               ", Año: " + p.getAnyo() + ", ID: " + p.getId());
	        }
	    }      
	}
	
	public static void devolverLibro(ArrayList<Libros> arrayLibros, ArrayList<Abonados> arrayAbonados, Scanner sc) {
		
	    System.out.println("Introduce el nombre o ID del abonado que devuelve el libro:");
	    String entrada = sc.nextLine();
	    Abonados aSeleccionado = null;
	    ArrayList<Abonados> abonadosCoincidentes = new ArrayList<>();
		
	    try {
	    	int idBuscado = Integer.parseInt(entrada);
	    	for(Abonados a: arrayAbonados) {
	    		if(a.getId() == idBuscado) {
	    			aSeleccionado = a;
	    			break;
	    		}
	    	}
	    }catch(NumberFormatException e) {
	    	for(Abonados a: arrayAbonados) {
	    		if(a.getNombre().equalsIgnoreCase(entrada)) {
	    			abonadosCoincidentes.add(a);
	    		}
	    	}
	    	if(abonadosCoincidentes.size() == 1) {
	    		aSeleccionado = abonadosCoincidentes.get(0);
	    	}else if(abonadosCoincidentes.size() > 1) {
	    		System.out.println("Se encontraron varios abonados con ese nombre:");
	    		for(int i=0; i<abonadosCoincidentes.size(); i++) {
	    			Abonados a = abonadosCoincidentes.get(i);
	    			System.out.println((i+1)+".- "+a.getMostrarDetalles());
	    		}
	    		System.out.println("Selecciona el número del abonado: ");
	    		int seleccion = sc.nextInt();
	    		sc.nextLine(); // clan buffer
	    		if(seleccion < 1 || seleccion > abonadosCoincidentes.size()) {
	    			System.out.println("Opción inválida\n");
	    			return;
	    		}
	    		aSeleccionado = abonadosCoincidentes.get(seleccion-1);
	    	}
	    }
	    if(aSeleccionado == null) {
	    	System.out.println("No se encontró un abonado con ese nombre o ID.");
	    	return;
	    }
	    if(aSeleccionado.getLibrosAlquilados().isEmpty()) {
	    	System.out.println("Este abonado no tiene libros alquilados.");
	        return;
	    }
	    System.out.println("Libros alquilados por "+aSeleccionado.getNombre()+": ");
	    for(int i=0; i<aSeleccionado.getLibrosAlquilados().size(); i++) {
	    	System.out.println((i+1)+".- "+aSeleccionado.getLibrosAlquilados().get(i));
	    }
	    System.out.print("Selecciona el número del libro a devolver: ");
	    int seleccionLibro = sc.nextInt();
	    sc.nextLine(); // clean buffer

	    if (seleccionLibro < 1 || seleccionLibro > aSeleccionado.getLibrosAlquilados().size()) {
	        System.out.println("Opción inválida.");
	        return;
	    }
	    Libros libroADevolver = aSeleccionado.getLibrosAlquilados().get(seleccionLibro-1);
	    libroADevolver.setAlquilado(false);
	    aSeleccionado.getLibrosAlquilados().remove(libroADevolver);
	    System.out.println("El libro '" + libroADevolver.getTitulo() + "' ha sido devuelto.");	
	}
	
	public static void devolverPelicula(ArrayList<Peliculas> arrayPeliculas, ArrayList<Abonados> arrayAbonados, Scanner sc) {
		
		System.out.println("Introduce el nombre o ID del abonado que devuelve la película:");
	    String entrada = sc.nextLine();
	    Abonados aSeleccionado = null;
	    ArrayList<Abonados> abonadosCoincidentes = new ArrayList<>();
		
	    try {
	    	int idBuscado = Integer.parseInt(entrada);
	    	for(Abonados a: arrayAbonados) {
	    		if(a.getId() == idBuscado) {
	    			aSeleccionado = a;
	    			break;
	    		}
	    	}
	    }catch(NumberFormatException e) {
	    	for(Abonados a: arrayAbonados) {
	    		if(a.getNombre().equalsIgnoreCase(entrada)) {
	    			abonadosCoincidentes.add(a);
	    		}
	    	}
	    	if(abonadosCoincidentes.size() == 1) {
	    		aSeleccionado = abonadosCoincidentes.get(0);
	    	}else if(abonadosCoincidentes.size() > 1) {
	    		System.out.println("Se encontraron varios abonados con ese nombre:");
	    		for(int i=0; i<abonadosCoincidentes.size(); i++) {
	    			Abonados a = abonadosCoincidentes.get(i);
	    			System.out.println((i+1)+".- "+a.getMostrarDetalles());
	    		}
	    		System.out.println("Selecciona el número del abonado: ");
	    		int seleccion = sc.nextInt();
	    		sc.nextLine(); // clan buffer
	    		if(seleccion < 1 || seleccion > abonadosCoincidentes.size()) {
	    			System.out.println("Opción inválida\n");
	    			return;
	    		}
	    		aSeleccionado = abonadosCoincidentes.get(seleccion-1);
	    	}
	    }
	    if(aSeleccionado == null) {
	    	System.out.println("No se encontró un abonado con ese nombre o ID.");
	    	return;
	    }
	    if(aSeleccionado.getPeliculasAlquiladas().isEmpty()) {
	    	System.out.println("Este abonado no tiene libros alquilados.");
	        return;
	    }
	    System.out.println("Películas alquiladas por "+aSeleccionado.getNombre()+": ");
	    for(int i=0; i<aSeleccionado.getPeliculasAlquiladas().size(); i++) {
	    	System.out.println((i+1)+".- "+aSeleccionado.getPeliculasAlquiladas().get(i)); 	
	    }
	    System.out.println("Selecciona el número de la película que se va a devolver: ");
	    int seleccionPelicula = sc.nextInt();
	    sc.nextLine(); // clean buffer
	    if(seleccionPelicula < 1 || seleccionPelicula > aSeleccionado.getPeliculasAlquiladas().size()) {
	    	System.out.println("Opción inválida.");
	    	return;
	    }
	    Peliculas peliculaADevolver = aSeleccionado.getPeliculasAlquiladas().get(seleccionPelicula-1);
	    peliculaADevolver.setAlquilada(false);
	    aSeleccionado.getPeliculasAlquiladas().remove(peliculaADevolver);
	    System.out.println("La película '" + peliculaADevolver.getTitulo() + "' ha sido devuelta.");    
	}
	
	public static void nuevoAbonado(ArrayList<Abonados> arrayAbonados, Scanner sc) {
		
		System.out.print("\nIntroduce el nombre: ");
		String nombre = sc.nextLine();
		
		System.out.print("\nIntroduce los apellidos: ");
		String apellidos = sc.nextLine();
		
		System.out.print("\nIntroduce el teléfono: ");
		int tlf = sc.nextInt();
		sc.nextLine(); // limpiar buffer
		
		System.out.print("\nIntroduce el DNI: ");
		String dni = sc.nextLine();
		
		Abonados nuevoAb = new Abonados(nombre, apellidos, tlf, dni);
		arrayAbonados.add(nuevoAb);
		
		System.out.println("\n"+nuevoAb.getNombre()+" añadido correctamente. ¿Quieres darlo de alta?"
				+"\n  Sí.- (s)"
				+"\n  No.- (n)");
		String alta = sc.next();
		if(alta.equalsIgnoreCase("s")) {
			nuevoAb.setInscrito(true);
			System.out.println("\n"+nuevoAb.getNombre()+" introducido y dado de alta correctamente.");
		}else if(!alta.equalsIgnoreCase("n")) {
			System.out.println("Opción incorrecta. "+nuevoAb.getNombre()+" está en el sistema pero NO inscrito."
					+"\n No podrá alquilar artículos.");
			nuevoAb.setInscrito(false);
		}else if(alta.equalsIgnoreCase("n")) {
			System.out.println(nuevoAb.getNombre()+" está en el sistema pero NO inscrito."
					+"\n No podrá alquilar artículos.");
			nuevoAb.setInscrito(false);
		}
	}
	
	public static void bajaAbonado(ArrayList<Abonados> arrayAbonados, Scanner sc) {
		
		ArrayList<Abonados> abonadosInscritos = new ArrayList<>();
		
		// Buscamos el abonado que va a darse de baja:
		
		for(Abonados a : arrayAbonados) { // Introduzco los inscritos en la lista "abonadosInscritos"
			if(a.isInscrito()) {
				abonadosInscritos.add(a);
			}
		}
		if(abonadosInscritos.isEmpty()) { // Salgo del método al no haber abonados inscritos
			System.out.println("No hay ningún abonado dado de alta actualmente.");
			return;
		}
		Abonados.listarAbonadosInscritos(arrayAbonados); // Listo los abonados inscritos
		System.out.println("Introduce el nombreo o el ID del abonado al que vamos a dar de alta:"); // Pido nombre/id
		String entrada = sc.nextLine();
	    Abonados aSeleccionado = null;
		    
		try { // Si es un número es que me ha dado el ID y ya tengo al abonado
			int idBuscado = Integer.parseInt(entrada);
			for(Abonados a: abonadosInscritos) {
				if(a.getId() == idBuscado) {
					aSeleccionado = a;
					break;
				}
			}
		}catch(NumberFormatException e) {  // Si no es un número almaceno a todos coincidentes en "abonadosCoincidentes"
			ArrayList<Abonados> abonadosCoincidentes = new ArrayList<>();
			for(Abonados a: abonadosInscritos) { 
				if(a.getNombre().equalsIgnoreCase(entrada)) {
					abonadosCoincidentes.add(a);
				}
			}
			if(abonadosCoincidentes.isEmpty()) {
				System.out.println("No se encontraron abonados inscritos con el nombre "+entrada+". ");
			}else if(abonadosCoincidentes.size() == 1) {
				aSeleccionado = abonadosCoincidentes.get(0);
			}else if(abonadosCoincidentes.size() > 1) {
				System.out.println("Se encontraron varios abonados con ese nombre:");
				for(int i=0; i<abonadosCoincidentes.size(); i++) {
					Abonados a = abonadosCoincidentes.get(i);
					System.out.println((i+1)+".- "+a.getMostrarDetalles());
				}
				System.out.println("Selecciona el número del abonado: ");
				int seleccion = sc.nextInt();
				sc.nextLine(); // clan buffer
				if(seleccion < 1 || seleccion > abonadosCoincidentes.size()) {
					System.out.println("Opción inválida\n");
					return;
				}
				aSeleccionado = abonadosCoincidentes.get(seleccion-1);
			}
		}
		if(aSeleccionado == null) {
			System.out.println("No se encontró un abonado con ese nombre o ID.");
			return;
		}
		aSeleccionado.setInscrito(false);
		System.out.println("El abonado seleccionado es "+aSeleccionado.getMostrarDetalles()+". Ha sido dajo de baja correctamente."
				+"\n¿Quieres además eliminarlo del sistema?"
				+"\n   Sí.- (s)"
				+"\n   No.- (n)");
		String eliminar = sc.nextLine();
		if(eliminar.equalsIgnoreCase("s")) {
			System.out.println("El abonado "+aSeleccionado.getMostrarDetalles()+" ha sido eliminado del sistema.");
			arrayAbonados.remove(aSeleccionado);
		}else if(eliminar.equalsIgnoreCase("n")) {
			System.out.println("El abonado "+aSeleccionado.getMostrarDetalles()+" seguirá en el sistema como NO inscrito.");
		}else if(!eliminar.equalsIgnoreCase("n") && !eliminar.equalsIgnoreCase("s")) {
			System.out.println("Opción incorrecta. El abonado "+aSeleccionado.getMostrarDetalles()+" seguira en el sistema como NO inscrito.");
		}
	}
	
	public static void modificarAbonado(ArrayList<Abonados> arrayAbonados, Scanner sc) {
		
		// Buscamos el abonado que va a modificarse:
		
		if(arrayAbonados.isEmpty()) { // Salgo del método al no haber abonados inscritos
			System.out.println("No hay ningún abonado en el sistema.");
			return;
		}
		for(Abonados a: arrayAbonados) {
			System.out.println(a.getMostrarDetalles());
		}

		System.out.println("Introduce el nombreo o el ID del abonado al que vamos a modificar:"); // Pido nombre/id
		String entrada = sc.nextLine();
	    Abonados aSeleccionado = null;
		    
		try { // Si es un número es que me ha dado el ID y ya tengo al abonado
			int idBuscado = Integer.parseInt(entrada);
			for(Abonados a: arrayAbonados) {
				if(a.getId() == idBuscado) {
					aSeleccionado = a;
					break;
				}
			}
		}catch(NumberFormatException e) {  // Si no es un número almaceno a todos coincidentes en "abonadosCoincidentes"
			ArrayList<Abonados> abonadosCoincidentes = new ArrayList<>();
			for(Abonados a: arrayAbonados) { 
				if(a.getNombre().equalsIgnoreCase(entrada)) {
					abonadosCoincidentes.add(a);
				}
			}
			if(abonadosCoincidentes.isEmpty()) {
				System.out.println("No se encontraron abonados con el nombre "+entrada+". ");
			}else if(abonadosCoincidentes.size() == 1) {
				aSeleccionado = abonadosCoincidentes.get(0);
			}else if(abonadosCoincidentes.size() > 1) {
				System.out.println("Se encontraron varios abonados con ese nombre:");
				for(int i=0; i<abonadosCoincidentes.size(); i++) {
					Abonados a = abonadosCoincidentes.get(i);
					System.out.println((i+1)+".- "+a.getMostrarDetalles());
				}
				System.out.println("Selecciona el número del abonado: ");
				int seleccion = sc.nextInt();
				sc.nextLine(); // clan buffer
				if(seleccion < 1 || seleccion > abonadosCoincidentes.size()) {
					System.out.println("Opción inválida\n");
					return;
				}
				aSeleccionado = abonadosCoincidentes.get(seleccion-1);
			}
		}
		if(aSeleccionado == null) {
			System.out.println("No se encontró un abonado con ese nombre o ID.");
			return;
		}
		System.out.println("Ok, vamos a modificar al abonado: "+aSeleccionado.getMostrarDetalles());
		// Modificar los datos del abonado
	    System.out.println("\nIntroduce el nuevo nombre (deja en blanco para mantener '" + aSeleccionado.getNombre() + "'): ");
	    String nuevoNombre = sc.nextLine();
	    if (!nuevoNombre.isBlank()) {
	        aSeleccionado.setNombre(nuevoNombre);
	    }
	    System.out.println("\nIntroduce los nuevos apellidos (deja en blanco para mantener '"+aSeleccionado.getApellidos()+"'): ");
	    String nuevosApellidos = sc.nextLine();
	    if(!nuevosApellidos.isBlank()) {
	    	aSeleccionado.setApellidos(nuevosApellidos);
	    }
	    System.out.println("\nIntroduce el nuevo teléfono (deja en blanco para mantener '"+aSeleccionado.getTlf()+"'): ");
	    String nuevoTlf = sc.nextLine();
	    if(!nuevoTlf.isBlank()) {
	    	try {
	    		int tlf = Integer.parseInt(nuevoTlf);
	    		aSeleccionado.setTlf(tlf);
	    	}catch(NumberFormatException e) {
	    		System.out.println("Teléfono inválido. No se realizó ningún cambio.");
	    	}
	    }
	    System.out.println("\nIntroduce el DNI (deja en blanco para mantener '"+aSeleccionado.getDni()+"'): ");
	    String nuevoDni = sc.nextLine();
	    if(!nuevoDni.isBlank()) {
	    	aSeleccionado.setDni(nuevoDni);
	    }
	    if(!aSeleccionado.isInscrito()) {
	    	String opIns;
	    	do {
		    	System.out.println("\n"+aSeleccionado.getNombre()+" no esta inscrito, ¿Quieres darlo de alta?"
		    			+"\n Sí.- (s)"
		    			+"\n No.- (n)");
		    	opIns = sc.nextLine();
		    	if(opIns.equalsIgnoreCase("s")) {
		    		aSeleccionado.setInscrito(true);
		    		System.out.println("\n"+aSeleccionado.getNombre()+" inscrito correctamente.");
		    	}else if(opIns.equalsIgnoreCase("n")) {
		    		System.out.println("\nEl abonado queda como NO inscrito.");
		    	}else System.out.println("\nOpción inválida. Por favor, introduce 's' o 'n'.");
	    	}while(!opIns.equalsIgnoreCase("s") && !opIns.equalsIgnoreCase("n"));
	    }else if(aSeleccionado.isInscrito()) {
	    	String opIns;
	    	do {
	    		System.out.println("\n"+aSeleccionado.getNombre()+" se encuentra inscrito, ¿Quieres darlo de baja?"
		    			+"\n Sí.- (s)"
		    			+"\n No.- (n)");
		    	opIns = sc.nextLine();
		    	if(opIns.equalsIgnoreCase("s")) {
		    		aSeleccionado.setInscrito(false);
		    		System.out.println("\n"+aSeleccionado.getNombre()+" ha quedado como NO inscrito correctamente.");
		    	}else if(opIns.equalsIgnoreCase("n")) {
		    		System.out.println("\n"+aSeleccionado.getNombre()+" permanece inscrito.");
		    	}else System.out.println("\nOpción inválida. Por favor, introduce 's' o 'n'.");    		
	    	}while(!opIns.equalsIgnoreCase("s") && !opIns.equalsIgnoreCase("n"));
	    }
	}
	
	
	
}
