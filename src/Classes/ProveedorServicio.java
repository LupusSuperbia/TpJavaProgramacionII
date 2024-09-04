package Classes;

import java.util.ArrayList;

/**
 * 
 */

// Hacemos un <T extends Servicio> para que sea mas generico y se puedan crear diferentes
// proveedores de servicio con distintas subclases que extiendan de servicio
public class ProveedorServicio<T extends Servicio>  extends Persona{
    private int idPdServicio;
    private T servicioPrestado;
    private double precio; 
    private boolean disponibilidad; 
    private String comentarios;
    
    
    
    public ProveedorServicio(String nombre,String comentarios, String cvu, double precio, T servicioPrestado) {
    	super(nombre, "Proveedor", cvu); // Esto llama al constructor del padre de la clase o sea la super clase 
		this.setPdServicio(super.getId());
		this.servicioPrestado = servicioPrestado;
		this.disponibilidad = true;
		this.comentarios = comentarios;
		this.solicitudes = new ArrayList<SolicitudServicio>();
		this.precio = precio;
	}
    
    
    
    public String getComentarios() {
		return comentarios;
	}



	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}



	public void agregarSolicitud(SolicitudServicio servicioProgramado) {
    	solicitudes.add(servicioProgramado);
    }
    
    public void verServicio() {
    	for (SolicitudServicio solicitudServicio : solicitudes) {
			System.out.println(solicitudServicio);
		}
    }
    
    public int getPdServicio() {
        return idPdServicio;
    }

    public T getServicioPrestado() {
        return servicioPrestado;
    }
    

    public void setPdServicio(int pdServicio) {
        this.idPdServicio = pdServicio;
    }

    public void setServicioPrestado(T servicioPrestado) {
        this.servicioPrestado = servicioPrestado;
    }

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
	// Metodo para obtener la categoria del servicio
	public String getTipoServicio() {
		return servicioPrestado.getTipo();
	}

	public String getCvuServicio() {
		return this.getCvu();
	}
	

	@Override
	public String toString() {
		return "ProveedorServicio [servicioPrestado=" + servicioPrestado + ", nombre= "+ this.getNombre() + " precio=" + precio + ", disponibilidad="
				+ disponibilidad + ", comentarios=" + comentarios + "]";
	}




	
    

}

