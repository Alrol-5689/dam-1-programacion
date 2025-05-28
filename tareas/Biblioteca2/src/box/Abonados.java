package box;

import java.util.*;

public class Abonados {
	
	// ATRIBUTOS
	
	protected String nombre, apellidos, dni;
	protected boolean inscrito; // POR DEFECTO ES FALSE 
	protected static int IdSiguiente; // static PARA QUE NO PERTENEZCA A LOS OBJETOS
	protected int id, tlf;
	protected ArrayList<Libros> librosAlquilados = new ArrayList<>();
	protected ArrayList<Peliculas> peliculasAlquiladas = new ArrayList<>();
	
	// CONSTRUCTORES
	
	public Abonados(String nombre, String apellidos, int tlf, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tlf = tlf;
		this.dni = dni;
		this.librosAlquilados = new ArrayList<>();  
	    this.peliculasAlquiladas = new ArrayList<>();  
		this.id = ++IdSiguiente;
	}
	
	public Abonados(String nombre) {
		this.nombre = nombre;
		this.librosAlquilados = new ArrayList<>();  
	    this.peliculasAlquiladas = new ArrayList<>(); 
		this.id = ++IdSiguiente;
	}
	
	public Abonados() {
		this.librosAlquilados = new ArrayList<>();  
	    this.peliculasAlquiladas = new ArrayList<>(); 
		this.id = ++IdSiguiente;
	}
	
	// MÉTODOS
	
	public String getMostrarDetalles() {
		if(inscrito) {
			return "Id; "+id+", Nombre: "+nombre+", apellidos: "+apellidos+", tlf: "+tlf+", DNI: "+dni+". INSCRITO.";
		}else return "Id; "+id+", Nombre: "+nombre+", apellidos: "+apellidos+", tlf: "+tlf+", DNI: "+dni+". NO INSCRITO.";
	}
	
	public static void listarAbonadosInscritos(ArrayList<Abonados> arrayAbonados) {
		
		boolean hayInscritos = false;
		for(Abonados a: arrayAbonados) {
			if(a.isInscrito()) {
				if(!hayInscritos) {
					System.out.println("Lista de abonados inscritos: ");
					hayInscritos = true;
				}
				System.out.println(a.getMostrarDetalles());
			}
		}
		if(!hayInscritos) System.out.println("Aún no se ha inscrito ningún abonado.");
	}
	
	public ArrayList<Peliculas> getPeliculasAlquiladas() {
	    return peliculasAlquiladas;
	}
	
	public ArrayList<Libros> getLibrosAlquilados() {
	    return librosAlquilados;
	}
	
	public void setAlquilarPelicula(Peliculas pelicula) {
		pelicula.setAlquilada(true);
	    this.peliculasAlquiladas.add(pelicula);
	}
	
	public void setAlquilarLibro(Libros libro) {
		libro.setAlquilado(true);
	    this.librosAlquilados.add(libro);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTlf() {
		return tlf;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isInscrito() {
		return inscrito;
	}

	public void setInscrito(boolean inscrito) {
		this.inscrito = inscrito;
	}

}
