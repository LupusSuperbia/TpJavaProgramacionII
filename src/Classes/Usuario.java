package Classes;

import java.util.ArrayList;
import java.util.List;

// Nuestra clase usuario extiende de persona
public class Usuario extends Persona {
	private SolicitudServicio solicitud;
	private List<SolicitudServicio> solicitudes;
	
	public Usuario(String nombre, String cvu){
		super(nombre, "Cliente", cvu); // Esto llama al constructor del padre de la clase o sea la super clase 
		this.setId(super.getId());
		this.solicitudes = new ArrayList<SolicitudServicio>();
	}
	// Metodo para obtener el index del objeto
	public int getIndex(List<Usuario> usuarios) {
		return usuarios.indexOf(this);
	}
	
	// Metodo para crear una solicitud del usuario hacia un proveedor de servicio
	public void crearSolicitudDeServicio(ProveedorServicio<? extends Servicio> proveedorServicio) {
		if (!tieneSolicitudesPendiente()) {
			SolicitudServicio solicitud = new SolicitudServicio(this, proveedorServicio);
			this.solicitud = solicitud;
			solicitud.getPvServicio().agregarSolicitud(this.solicitud);
			this.solicitudes.add(solicitud);
			System.out.println("Su solicitud se a creado efectivamente");
			
		}else { 
			System.out.println("Tiene un servicio que contrato sin pagar");
		}
		
		
	}
	// Metodo para asegurar que el cliente o usuario haya pagado el servicio que contrato
	// y no pueda contratar otro servicio hasta que lo pague
	public boolean tieneSolicitudesPendiente() {
		for (SolicitudServicio solicitudServicio : solicitudes) {
			if(!solicitudServicio.isPagado()) {
				return true;
			} 
		}
		return false;
	}
	
	// Metodo para ver las solicitudes que el usuario pidio
	public void verSolicitudes() {
		for (SolicitudServicio solicitudServicio : solicitudes) {
			System.out.println(solicitudServicio);
		}
	}
	// Metodo para ver la ultima solicitud que creo el usuario
	public SolicitudServicio obtenerSolicitudCreada() {
		return this.solicitud;
	}
	// Getter para obtener las solicitudes que hizo el usuario
	public List<SolicitudServicio> getSolicitudes() {
		return this.solicitudes;
	}
	
	// Metodo para confirmar que el proveedor termino la tarea y cuanto dias se demoro 
	// Para después calcular cuanto es lo que tiene que pagar el usuario
	public void confirmarTareaTerminada(int diasTrabajo) {
		solicitud.completarMonto(diasTrabajo);
	}
	
	public String getCvuCliente() {
		return this.getCvu();
	} 

	// Metodo para realizar el pago del servicio hacia el proveedor
	public void realizarPago(MetodoDePago metodoDePago, double monto) {
		Pago pago = new Pago(this, solicitud.getPvServicio(), metodoDePago, monto);
		if (pago.confirmarPago(monto)) {
			pago.setStatus(true);
		} else {
			pago.setStatus(false);
		}
		pago.verPago();
		
	}
	
	
	
	
	
	
	
	
	
}
