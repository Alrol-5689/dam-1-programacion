package box;

import java.util.*;

public class Libros {
	
	// ATRIBUTOS
	
	protected String titulo, autor, isbn;
	protected boolean alquilado; // FALSE POR DEFECTO
	private static int IdSiguiente; // static PARA QUE NO PERTENEZCA A LOS OBJETOS
	protected int id, anyo;
	
	// CONSTRUCTORES
	
	public Libros(String titulo, String autor, int anyo, String isbn) {
		this.titulo = titulo;
		this.autor = autor;
		this.anyo = anyo;
		this.isbn = isbn;
		this.id = ++IdSiguiente;
	}
	
	public Libros(String titulo) {
		this.titulo = titulo;
		this.id = ++IdSiguiente;
	}
	
	public Libros() {
		this.id = ++IdSiguiente;
	}
	
	// MÉTODOS
		
	public String getMostrarDetalles() {
		return "Id: " + id + ", título: " + titulo + ", autor: " + autor + ", año: " + anyo + ", ISBN: " + isbn;
    }
	
	public static void mostrarLibrosAlquilados(ArrayList<Abonados> abonados) { // METEMOS EN EL PARÉNTESIS arrayAbonados 
	    System.out.println("Listado de libros alquilados:");
	    boolean hayLibrosAlquilados = false;

	    for (Abonados a : abonados) {
	        for (Libros l : a.getLibrosAlquilados()) {
	            hayLibrosAlquilados = true;
	            System.out.println("Libro: " + l.getMostrarDetalles() + " | Abonado: " + a.getMostrarDetalles());
	        }
	    }

	    if (!hayLibrosAlquilados) {
	        System.out.println("No hay libros alquilados actualmente.");
	    }
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getAnyo() {
		return anyo;
	}
	
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public boolean isAlquilado() {
		return alquilado;
	}
	
	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}
	
}
