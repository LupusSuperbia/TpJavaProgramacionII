package Classes; 

public class Persona{
	// Atributos
	private String nombre; 
	private int id; 
	protected static int maxId; 
	private int edad; 
	// Metodo 
	public String getNombre() {
		return nombre;
	}

	public int getMaxId() {
		return Persona.maxId;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
}

