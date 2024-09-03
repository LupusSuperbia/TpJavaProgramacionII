package Classes;

/**
 * 
 */
public class ServicioDomestico extends Servicio{
	private TipoDeServicioDomesticos tipo;
	
	public ServicioDomestico(String nombre, TipoDeServicioDomesticos tipo) {
		super(nombre);
		this.tipo = tipo;
	}
	
	
	public String getTipo() {
		return tipo.toString();
	}

	public void setTipo(TipoDeServicioDomesticos tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "ServicioDomestico [tipo=" + tipo + ", nombre=" + this.getNombreServicio() + "]";
	}
	
	
	
}
