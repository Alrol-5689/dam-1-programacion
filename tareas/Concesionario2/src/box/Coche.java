package box;

public abstract class Coche {
	
	// ATRIBUTOS
	
	protected String matricula, marca, modelo, color;
	protected int id, anyo;
	protected final int ANYO_POR_DEFECTO = 1961;
	protected final String MARCA_POR_DEFECTO = "Genérica", MODELO_POR_DEFECTO = "Estandar", COLOR_POR_DEFECTO = "blanco";
	protected static int idSiguiente;
	
	// CONSTRUCTORES

	protected Coche(String matricula) {
		this.matricula = matricula;
		this.marca = MARCA_POR_DEFECTO;
		this.modelo = MODELO_POR_DEFECTO;
		this.color = COLOR_POR_DEFECTO;
		this.anyo = ANYO_POR_DEFECTO;
		this.id =++ idSiguiente;
	}

	protected Coche(String matricula, String marca, String modelo, String color, int anyo) {
		this.matricula = matricula;		
		if(!marca.isBlank()){
			this.marca = marca;
		}else this.marca = MARCA_POR_DEFECTO;	
		if(!modelo.isBlank()){
			this.modelo = modelo;
		}else this.modelo = MODELO_POR_DEFECTO;		
		if(!color.isBlank()){
			this.color = color;
		}else this.color = COLOR_POR_DEFECTO;
		if(anyo == 0) {
			anyo = ANYO_POR_DEFECTO;
		}else this.anyo = anyo;
		this.id =++ idSiguiente;
	}
	
	// MÉTODOS

	@Override
	public String toString() {
		return "[id: "+ id + "]" + marca + modelo + " ( " + color + " ) [año: " + anyo + " ] --> " + matricula + "";
	}
	
	protected int getAnyo() {
		return anyo;
	}

	protected void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	
	protected String getMatricula() {
		return matricula;
	}

	protected void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	protected String getMarca() {
		return marca;
	}

	protected void setMarca(String marca) {
		this.marca = marca;
	}

	protected String getModelo() {
		return modelo;
	}

	protected void setModelo(String modelo) {
		this.modelo = modelo;
	}

	protected String getColor() {
		return color;
	}

	protected void setColor(String color) {
		this.color = color;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}
	

	
	

}
