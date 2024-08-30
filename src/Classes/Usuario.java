package Classes;

public class Usuario extends Persona {
	
	
	// public Servicio servicio;
	
	
	public Usuario(String nombre){
		super(); // Esto llama al constructor de mi padre o sea de mi super clase 
		this.setNombre(nombre);
		this.setId(super.getMaxId() + 1);
		Persona.maxId += 1;
	}
	
	
	
	
	
	
}
