package menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Classes.AdministradorProveedor;
import Classes.AdministradorUsuario;
import Classes.Efectivo;
import Classes.MetodoDePago;
import Classes.ProveedorServicio;
import Classes.Servicio;
import Classes.SolicitudServicio;
import Classes.TarjetaDeCredito;
import Classes.TransferenciaBancaria;
import Classes.Usuario;


public class MenuUsuario extends Menu{
	private AdministradorUsuario adminUsuarios;
	private AdministradorProveedor adminProveedor;
	private Usuario usuario;
	
	// CONSTRUCTOR NECESARIO PARA PODER USAR LAS LISTAS CREADAS
	public MenuUsuario(AdministradorUsuario adminUsuarios, AdministradorProveedor administradorProveedor) {
		this.adminUsuarios = adminUsuarios;
		this.adminProveedor = administradorProveedor;
	}
	
	
	// Menu Main del usuario
	public void main() {
		this.salir = false;
		while(!salir) {
		try {
				utils.menuDecoracion("Bienvenido Al panel de Usuario", "Por favor elija una de las opciones para navegar dentro de los distintos menús:", "Crear Usuario", "Ingresar Como Usuario", "Salir");
				System.out.println("Ingrese una opción: ");
				int opcion = scanner.nextInt();
				menuElegido(opcion);			
		} catch (InputMismatchException e) {
			System.out.println("Ocurrio un error inesperado " + e.getMessage() );
			scanner.nextLine();
		}
		}
		
	}
	// Otra funcion donde nos da un switch para que eliga entre distintas opciones
	public void menuElegido(int numero) {
		switch (numero) {
		case 1:
			crearUsuario();
			break;
			
		case 2: 
			ingresarComoUsuario();
			break;
			
		case 3: 
			this.salir = true;
			return ;
			
		default:
			return;
		}
	}
	
	// crearUsuario es un metodo que nos ayuda a la hora que el usuario o cliente quiera 
	// crear un cuenta, solo necesitamos dos datos importantes el nombre y el cvu
	private void crearUsuario() {
		// TODO : Esto lo dejo porque más adelante voy a hacer alguna función 
		// para que detecte si el cvu ya esta guardado en los usuarios creados
		// así no hay duplicacion de datos
		
		System.out.println("#################################################################################");
		System.out.println("Por favor ingrese el nombre que desea para su cuenta :");
		String nombre = scanner.next();
		System.out.println("Por favor ingrese el cvu que desea para su cuenta :");
		String cvu = scanner.next();
		System.out.println("#################################################################################");
		
		Usuario usuario = new Usuario(nombre, cvu);
		adminUsuarios.addObject(usuario);
	}
	
	// Esta funcion nos permite poder entrar como algun usuario creado o que este guardado 
	
	private void ingresarComoUsuario() {
		 	List<Usuario> usuarios = this.adminUsuarios.getObject();
			System.out.println("#################################################################################");
			System.out.println("                                      POR FAVOR ELIJA CON QUE USUARIO DESEA INGRESAR ");
			int i = 1;
			for (Usuario usuario : usuarios) {
				System.out.println(i + " - " + usuario.getNombre());
				i++;
			}
			System.out.print("Ingrese el numero de indice del usuario que quiere");
			try {
				int index = scanner.nextInt() - 1;
				if (index >= 0 && usuarios.size() >= index ) {
					this.usuario  =  usuarios.get(index);
					menuUsuario();
					
				} else {
					System.out.println("Por favor eliga un numero que este dentro del rango");
				} 
				
			} catch (InputMismatchException e) {
				System.out.println("Error : " + e.getMessage());
				scanner.nextLine();
			}
			
			System.out.println("#################################################################################");
			System.out.println();
		
	}  
	// El menu del usuario donde va a interactuar para llegar a distintas opciones donde va 
	// realizar operaciones que necesite 
	public void menuUsuario() {
		this.menuSalir = true;
		while(menuSalir) {	
			try {
				System.out.println("#################################################################################");
				System.out.println("# Ha ingresado al menu Usuario como el cliente " + this.usuario.getNombre());
				System.out.println("# Elija una de las opciones para que podamos atender lo que necesita nuestro cliente");
				System.out.println("# AVISO PARA CREAR UN NUEVO CONTRATO DE SERVICIO ES NECESARIO QUE HAYA PAGADO EL ULTIMO");
				
				utils.menuSinDecoracionSubMenus("Contratar un servicio", "Ver servicio contratado", "Ver servicios contratados", "Salir");
				int i = scanner.nextInt();
				menuElegirUsuario(i);
				System.out.println("#################################################################################");
				
			} catch (InputMismatchException e) {
				System.out.println("Error: " + e.getMessage());
				scanner.nextLine();
			}
		}
	}
	// Menu para elegir diferentes opciones
	private void menuElegirUsuario(int key) {
		switch (key) {
		case 1:
			contratarServicio();
			break;
		case 2 : 
			mostrarServicioContratado();
			break;
		case 3 :
			mostrarServiciosContratados();
			break;
		case 4 : 
			this.menuSalir = false;
			return;
		default:
			break;
		}
	}
	
	// A través de un for each mostramos todos los servicios que pidio nuestro usuario 
	private void mostrarServiciosContratados() {
		List<SolicitudServicio> servicios = this.usuario.getSolicitudes();
		int i = 1;
		if(!servicios.isEmpty()) {
			System.out.println("Los servicios contratados son los siguiente :");
			
			for (SolicitudServicio servicio : servicios) {
				
				System.out.println(i + " - Nombre del proveedor :" + servicio.getPvServicio().getNombre() +
						"\n El precio por día es de : $" + servicio.getPvServicio().getPrecio() + 
						" \n El estado del trabajo es : " + servicio.getEstadoDelTrabajo() + 
						"\n El total pagado: $"+ servicio.getTotalPagado());
				i++;
			} 			
		} else {
			System.out.println("No hay servicios que haya contratado");
		}
	}
	
	// Muestra el servicio que contrato el usuario
	private void mostrarServicioContratado() {
		SolicitudServicio servicio = this.usuario.obtenerSolicitudCreada();
		
		if(servicio != null && !servicio.isPagado() ) {
			System.out.println("El servicio contratado es el siguiente :");
			System.out.println("Nombre del proveedor :" + servicio.getPvServicio().getNombre() +
					"\n El tipo de categoria : " + servicio.getPvServicio().getTipoServicio() + " El precio por día es de :" + servicio.getPvServicio().getPrecio() + 
					" \n El estado del trabajo es : " + servicio.getEstadoDelTrabajo() + 
					"\n ");
			System.out.println("Elija una de las dos opciones ");
			System.out.println("1- Pagar Servicio");
			System.out.println("2- Salir");
			int index = scanner.nextInt();
			switch (index) {
			case 1:
				pagarServicio(servicio);
				break;
			case 2 : 
				return;
			default:
				System.out.println("Por favor ingrese un numero valido");
				break;
			}
		} else {
			System.out.println("No hay ningun servicio contratado");
		}
	}
	
	// Este metodo sirve para poder elegir un metodo de pago y lo retornamos para poder efectuar
	// el pago
	private MetodoDePago elegirMetodo() {
		boolean metodoBool = false;
		while (!metodoBool) {	
		int opcion = scanner.nextInt();
		switch (opcion) {
		case 1:
			metodoBool = true;
			return new Efectivo();
		case 2:
			metodoBool = true;
			return new TarjetaDeCredito();
		case 3:
			metodoBool = true;
			return new TransferenciaBancaria();
		default:
			System.out.println("Por favor elija una de las opciones correspondiente");
			break;
		}
		}
		return null;
	}
	// Separe las distintas partes de realizarElPago para que sea mas modular esto nos ayuda
	// entender más como funciona el codigo en sí 
	private void funcionPagar(SolicitudServicio servicio, MetodoDePago metodoDePago) {
		int totalDias;
		double monto = 0;
		double montoAPagar;
		
		if(servicio.getMonto() == 0) {
			do {
				System.out.println("Ingrese la cantidad de dia que se demoro el proveedor en terminar su trabajo (1 como minimo)");
				totalDias = scanner.nextInt();
				if(totalDias == 0) {
					System.out.println("Ingrese el total de dias tiene que ser minimo 1");
				}
			}				
			while (totalDias == 0);
			usuario.confirmarTareaTerminada(totalDias);	
		}
		monto = servicio.getMonto();
		System.out.println("El monto total a pagar es de: $" + monto);
		System.out.println("Ingrese la cantidad que desea pagar");
		montoAPagar = scanner.nextDouble();
		this.usuario.realizarPago(metodoDePago, montoAPagar);
	}
	// Metodo para pagar el servicio que el usuario contrato
	private void pagarServicio(SolicitudServicio servicio) {
		MetodoDePago metodoDePago = null;
		
		utils.menuDecoracion("Por favor eliga que metodo de pago va a utilizar", "Opciones", "Efectivo", "Tarjeta de credito", "Transferencia");	
		metodoDePago = elegirMetodo();
		funcionPagar(servicio, metodoDePago);
		
		
	}
	// Metodo para que el usuario pueda contratar algun servicio que ya esta guardado en el 
	// ArrayList de los proveedores de servicio
	private void contratarServicio() {
		System.out.println("#################################################################################");
		System.out.println("                               Contratar servicio");
		List<ProveedorServicio<? extends Servicio>> proveedores = adminProveedor.getObject();
		int i = 1;
		for (ProveedorServicio<? extends Servicio> proveedorServicio : proveedores) {
			System.out.println(i + " -Nombre:" + proveedorServicio.getNombre() + "\n "
					+ "  Servicio:" + proveedorServicio.getServicioPrestado().getNombreServicio() + 
					"\n  Tipo:" + proveedorServicio.getTipoServicio());
			i++;
		}
		try {
			System.out.println("Por favor ingrese un numero que este dentro del indice");
			int index = scanner.nextInt() - 1;
			if(index >= 0 && proveedores.size() >= index) {
				ProveedorServicio<? extends Servicio> proveedor = proveedores.get(index);
				this.usuario.crearSolicitudDeServicio(proveedor);
			} else {
				System.out.println("Por favor ingrese un numero que este en el rango");
			}
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}

