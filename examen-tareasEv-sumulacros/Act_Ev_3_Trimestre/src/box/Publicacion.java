package box;

import java.time.LocalDate;

public class Publicacion {
	
	// Atributos
	
	private String mensaje;
	private LocalDate fecha;
	private CuentaUsuario autor;
	private int id;
	
	public static int idSiguiente;
	
	// Constructores
	
	public Publicacion() {
	}
	public Publicacion(String mensaje, LocalDate fecha, CuentaUsuario autor) {
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.autor = autor;
		this.autor.getLista_publicaciones().add(this);
		this.id =++idSiguiente;
	}
	
	
	@Override
	public String toString() {
		return "ID: "+id+", autorID: "+autor.getId()+", fecha: "+fecha+". PUBLICACIÓN: "+mensaje;
	}
	protected String getMensaje() {
		return mensaje;
	}
	protected void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	protected LocalDate getFecha() {
		return fecha;
	}
	protected void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	protected CuentaUsuario getAutor() {
		return autor;
	}
	protected void setAutor(CuentaUsuario autor) {
		this.autor = autor;
	}
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected static int getIdSiguiente() {
		return idSiguiente;
	}
	protected static void setIdSiguiente(int idSiguiente) {
		Publicacion.idSiguiente = idSiguiente;
	}
	
	
	

}
