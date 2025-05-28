package box;

import java.util.*;

public class Peliculas {
	
	// ATRIBUTOS
	
	protected String  titulo, director;
	protected boolean alquilada; // FALSE POR DEFECTO
	protected static int IdSiguiente; // static PARA QUE NO PERTENEZCA A LOS OBJETOS
	protected int anyo, id;
	
	// CONSTRUCTORES
	
	public Peliculas(String titulo, String director, int anyo) {
		this.titulo = titulo;
		this.director = director;
		this.anyo = anyo;
		this.id = ++IdSiguiente;
	}
	
	public Peliculas(String titulo) {
		this.titulo=titulo;
		this.id = ++IdSiguiente;
	}
	
	public Peliculas() {
		this.id = ++IdSiguiente;
	}
	
	// MÉTODOS
	
	public String getMostrarDetalles() {
		return "ID: "+id+", título: "+titulo+", director: "+director+", año: "+anyo;
	}
	
	public static void mostrarPeliculasAlquiladas(ArrayList<Abonados> abonados) { // METEMOS EN EL PARÉNTESIS arrayAbonados 
	    System.out.println("Listado de películas alquiladas:");
	    boolean hayPeliculasAlquiladas = false;

	    for (Abonados a : abonados) {
	        for (Peliculas p : a.getPeliculasAlquiladas()) {
	        	hayPeliculasAlquiladas = true;
	            System.out.println("Película: " + p.getMostrarDetalles() + " | Abonado: " + a.getMostrarDetalles());
	        }
	    }

	    if (!hayPeliculasAlquiladas) {
	        System.out.println("No hay películas alquiladas actualmente.");
	    }
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public boolean isAlquilada() {
		return alquilada;
	}

	public void setAlquilada(boolean alquilada) {
		this.alquilada = alquilada;
	}
	

}
