package Classes;

public class MetodoDePago {
	private int idMetodoDePago;
	private Usuario cliente;
	private ProveedorServicio proveedor;
	private MetodoDePago tipoDeMetodo;
	private String detalles;


	public int getIdMetodoDePago() {
		return idMetodoDePago;
	}

	public void setIdMetodoDePago(int idMetodoDePago) {
		this.idMetodoDePago = idMetodoDePago;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public ProveedorServicio getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorServicio proveedor) {
		this.proveedor = proveedor;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public Classes.MetodoDePago getTipoDeMetodo() {
		return tipoDeMetodo;
	}

	public void setTipoDeMetodo(Classes.MetodoDePago tipoDeMetodo) {
		this.tipoDeMetodo = tipoDeMetodo;
	}
}
