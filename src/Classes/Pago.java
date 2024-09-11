package Classes;

public class Pago {
  private int id; 
  private double monto;
  private boolean status;
  private Usuario cliente; 
  private ProveedorServicio<? extends Servicio> pdServicio;
  private MetodoDePago metodoDePago;
  private static int maxId;

  
  public Pago(Usuario cliente, ProveedorServicio<? extends Servicio> pdServicio, MetodoDePago metodoDePago,  double monto) {
	this.cliente = cliente; 
	this.pdServicio = pdServicio;
	this.monto = monto;
	this.status = false; 
	this.metodoDePago = metodoDePago;
	this.id = ++Pago.maxId ;
}
  
  public int getMaxId() {
	  return Pago.maxId;
  }
  
  
  public void verPago() {
	  System.out.println("El estado del pago del usuario " +this.cliente.getNombre() + " hacia el proveedor de servicio " + this.pdServicio.getNombre() + " es de un total de " + monto + " por lo tanto queda un total de  " + (cliente.obtenerSolicitudCreada().getMonto()) + " a pagar y se encuentra en estado " + (this.status ? "PAGADO" : "NO PAGADO"));
  } 
  
  public void pagarMontoSolicitud(String estadoTrabajo, boolean pagado, double totalPagado, double monto) {
	  cliente.obtenerSolicitudCreada().setEstadoDelTrabajo(estadoTrabajo);
	  cliente.obtenerSolicitudCreada().setPagado(pagado);
	  cliente.obtenerSolicitudCreada().setTotalPagado(totalPagado);
	  cliente.obtenerSolicitudCreada().setMonto(monto);
  }
  
  
  public boolean confirmarPago(double monto) {
	  
	  if(metodoDePago instanceof TarjetaDeCredito) {
		  System.out.println("El pago con la tarjeta de credito a sido efectivo");
	  } else if (metodoDePago instanceof TransferenciaBancaria) {
		System.out.println("La transferencia de la cuenta del cliente " + this.cliente.getCvu() + " hacia la cuenta del proveedor de servicio " + this.pdServicio.getCvu() + " ha sido exitosa ");
	} else {
		System.out.println("El pago ha sido en efectivo");
	}
	  if(cliente.obtenerSolicitudCreada().getMonto() == monto) {
		  pagarMontoSolicitud("Terminado", true, monto, 0);
		  
		  return true; 
	  } else {
		  System.out.println("El pago no se ha realizado pero se desconto " + monto + " del total del servicio que era: $" + cliente.obtenerSolicitudCreada().getMonto());
		  pagarMontoSolicitud("Falta completar pago", false, monto, (cliente.obtenerSolicitudCreada().getMonto() - monto));
		  return false;
	  } 
	  
  }
  
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public double getMonto() {
	return monto;
}

public void setMonto(double monto) {
	this.monto = monto;
}

public Usuario getCliente() {
	return cliente;
}

public void setCliente(Usuario cliente) {
	this.cliente = cliente;
}

public ProveedorServicio<? extends Servicio> getPdServicio() {
	return pdServicio;
}

public void setPdServicio(ProveedorServicio<? extends Servicio> pdServicio) {
	this.pdServicio = pdServicio;
}

public MetodoDePago getMetodoDePago() {
	return metodoDePago;
}

public void setMetodoDePago(MetodoDePago metodoDePago) {
	this.metodoDePago = metodoDePago;
}

public boolean isStatus() {
	return status;
}

public static void setMaxId(int maxId) {
	Pago.maxId = maxId;
}

public void setStatus(boolean b) {
	this.status = b;
	
}
}
