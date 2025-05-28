package enero;

public class Persona {

		
		// PARTES A IDENTIFICAR:
		
		// ATRIBUTOS O PROPIEDADES
		
		protected String dni, nombre;
	
		// CONSTRUCTOR O CONSTRUCTORES
		
		public Persona() {
			
		}

		public Persona(String dni) {
			this.dni = dni;
		}

		public Persona(String dni, String nombre) {
			this.dni = dni;
			this.nombre = nombre;
		}
		
		// MÉTODOS
		
		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
					
		
		
		


}


