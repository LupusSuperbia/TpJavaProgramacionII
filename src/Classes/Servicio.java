package Classes;


public abstract class Servicio {
	private int idServicio;
	private String nombreServicio;
	private String duracionServicio;
	private static int maxIdServicio;
	public abstract String getTipo();

	public Servicio(String nombre) {
		this.nombreServicio = nombre;
		Servicio.maxIdServicio += 1;
		this.idServicio = Servicio.maxIdServicio;
	}

	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public String getNombreServicio() {
		return nombreServicio;
	}
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}





	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + ", duracionServicio="
				+ duracionServicio + "]";
	}




}
