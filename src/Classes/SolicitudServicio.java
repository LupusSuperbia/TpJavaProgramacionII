package Classes;

/**
 * 
 */
public class SolicitudServicio {
	private Usuario usuario;
	private ProveedorServicio<? extends Servicio> pdServicio;
	private String estadoDelTrabajo;
	private boolean pagado;
	private double monto;
	private double totalPagado = 0;
	private int diasDeTrabajo;
	
	public SolicitudServicio(Usuario usuario, ProveedorServicio<? extends Servicio> pdServicio) {
		this.usuario = usuario;
		this.pdServicio = pdServicio;
		this.estadoDelTrabajo = "Iniciado";
		this.pagado = false;
		this.monto = pdServicio.getPrecio() * diasDeTrabajo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public ProveedorServicio<? extends Servicio> getPvServicio() {
		return pdServicio;
	}
	public void setPvServicio(ProveedorServicio<? extends Servicio> pvServicio) {
		this.pdServicio = pvServicio;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	public String getEstadoDelTrabajo() {
		return estadoDelTrabajo;
	}
	public void setEstadoDelTrabajo(String estadoDelTrabajo) {
		this.estadoDelTrabajo = estadoDelTrabajo;
	}
	public void completarMonto(int diasDeTrabajo) {
		this.monto = this.pdServicio.getPrecio() * diasDeTrabajo;
	}
	
	public double getTotalPagado() {
		return totalPagado;
	}
	public void setTotalPagado(double totalPagado) {
		this.totalPagado += totalPagado;
	}
	@Override
	public String toString() {
		return "SolicitudServicio [usuario=" + usuario.toString() + ", pvServicio=" + pdServicio + ", estadoDelTrabajo="
				+ estadoDelTrabajo + ", monto=" + monto + "]";
	}
	
	
	
	
	
	
	
}
