package Classes;

public class ServicioSalud extends Servicio{
	private TipoDeServicioSalud tipo;
	
	
	
	public ServicioSalud(String nombre, TipoDeServicioSalud tipo) {
		super(nombre);
		this.tipo = tipo;
	
	}


	public String getTipo() {
		return tipo.toString();
	}

	public void setTipo(TipoDeServicioSalud tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "ServicioSalud [tipo=" + tipo + ", getNombreServicio()=" + getNombreServicio() + "]";
	}
	
	
}
