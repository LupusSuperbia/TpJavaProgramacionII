package Classes;

import java.util.List;

public abstract class Persona{
	// Atributos
	private String nombre;
	private int id;
	private String cvu;
	protected static int maxId;
	private int edad;
	private String rol;
	protected List<SolicitudServicio> solicitudes;


	 public Persona(String nombre, String rol, String cvu) {
	        this.nombre = nombre;
	        this.rol = rol;
	        this.cvu = cvu;
	        Persona.maxId += 1;
	        this.id = Persona.maxId ;

	    }
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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}



	public String getCvu() {
		return cvu;
	}



	public void setCvu(String cvu) {
		this.cvu = cvu;
	}



	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", rol=" + rol + "]";
	}





}

