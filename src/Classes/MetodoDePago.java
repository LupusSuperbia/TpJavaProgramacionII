package Classes;

public interface MetodoDePago {
	Usuario getCliente();
    void setCliente(Usuario cliente);
	
    ProveedorServicio<? extends Servicio> getProveedor();

	void setProveedor(ProveedorServicio<? extends Servicio> proveedor);

	String getDetalles();
	
	void setDetalles(String detalles);
	
}
