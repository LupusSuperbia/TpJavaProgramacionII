package menu;

import java.util.InputMismatchException;
import java.util.List;

import Classes.AdministradorProveedor;
import Classes.AdministradorServicio;
import Classes.ProveedorServicio;
import Classes.Servicio;
import Classes.ServicioDomestico;
import Classes.ServicioSalud;
import Classes.TipoDeServicioDomesticos;
import Classes.TipoDeServicioSalud;


public class MenuProveedor extends Menu{
	private AdministradorProveedor adminProveedor;
	private Servicio servicio;
	private AdministradorServicio adminServicios;
	private ProveedorServicio<? extends Servicio> pdServicio;
	
	
	public MenuProveedor(AdministradorProveedor adminProveedor, AdministradorServicio servicio) {
		this.adminProveedor = adminProveedor;
		this.adminServicios = servicio;
	}
	
	
	@Override
	public void main() {
		this.menuSalir = true;
		while(menuSalir){
			utils.menuDecoracion("Bienvenido Al panel de Proveedor", "Por favor elija una de las opciones para navegar dentro de los distintos menús:", "Crear Proveedor", "Ingresar Como Proveedor", "Salir");
			try {
				int i = scanner.nextInt();
				scanner.nextLine();
				menuElegido(i);
			} catch (InputMismatchException e) {
				System.out.println("Por favor ingrese un numero : Error " + e.getMessage());
				scanner.nextLine();
			} 			
		}
		
		 
		
	}


	@Override
	public void menuElegido(int numero) {
		switch (numero) {
		case 1:
			crearProveedor();
			break;
		case 2 : 
			ingresarProveedor();
			break;
		case 3 :
			this.menuSalir = false;
			return;
		default:
			break;
		}
		
	}


	private void ingresarProveedor() {
		boolean menuProveedor = true;
		while(menuProveedor) {
		List<ProveedorServicio<? extends Servicio>> psdServicio = this.adminProveedor.getObject();
		System.out.println("#################################################################################");
		System.out.println("                                      POR FAVOR ELIJA CON QUE PROVEEDOR DESEA INGRESAR ");
		int i = 1;
		for (ProveedorServicio<? extends Servicio> pvServicio: psdServicio ) {
			System.out.println(i + " - " + pvServicio.getNombre());
			i++;
		}
		System.out.println( (i + 1) + " - si desea salir");
		System.out.print("Ingrese el numero de indice del proveedor que quiere o ingrese ");
		try {
				int index = scanner.nextInt() - 1;
				scanner.nextLine();
				if (index >= 0 && psdServicio.size() >= index ) {
					this.pdServicio  =  psdServicio.get(index);
					System.out.println(pdServicio);
					menuProveedor();
					
				} else if ( i == index ) {
					System.out.println("Ha elegido salir");
					menuProveedor = false;
					this.menuSalir = true;
					return;
				}
				else {
					System.out.println("Por favor eliga un numero que este dentro del rango");
				} 				
			}
			
		 catch (InputMismatchException e) {
			System.out.println("Porfavor ingrese un numero valido" + e.getMessage());
			scanner.nextLine();
		} }
		
		System.out.println("#################################################################################");
		System.out.println();
		return;
		
	}
	
	private void menuProveedor() {
		this.menuSalir = true;
		while(menuSalir) {	
			try {
				System.out.println("#################################################################################");
				System.out.println("# Ha ingresado al menu Proveedor como el proveedor " + this.pdServicio.getNombre());
				System.out.println("# Elija una de las opciones para que podamos atender lo que necesita nuestro proveedor");
				
				
				utils.menuSinDecoracionSubMenus("Cambiar Nombre", "Ver servicio", "Cambiar Precio de servicio", "Cambiar comentario", "Salir");
				int i = scanner.nextInt();
				scanner.nextLine();
				menuElegirProveedor(i);
				System.out.println("#################################################################################");
			} catch (InputMismatchException e) {
				System.out.println("Error: " + e.getMessage());
				scanner.nextLine();
			}
		} 
		return;
		
	}


	private void menuElegirProveedor(int i) {
		switch (i) {
		case 1:
				System.out.println("Por favor ingrese el nombre que desea");
				String nombre = scanner.nextLine();
				this.pdServicio.setNombre(nombre);
				System.out.println("Su nombre se ha cambiado exitosamente");
			return;
		case 2:
			System.out.println("El servicio que ofrece es: " + this.pdServicio.getServicioPrestado() + " Su precio es de : " + this.pdServicio.getPrecio());
			return;
		case 3:
			System.out.println("Por favor ingrese el precio que desea");
			double precio = scanner.nextDouble();
			scanner.nextLine();
			this.pdServicio.setPrecio(precio);;
			System.out.println("Su nombre se ha cambiado exitosamente");
			return;
		case 4 :
			System.out.println("Por favor ingrese el comentario que desea");
			String comentario = scanner.nextLine();
			this.pdServicio.setComentarios(comentario);
			System.out.println("Su nombre se ha cambiado exitosamente");
			return;
		case 5 : 
			System.out.println("Usted ha decidido salir");
			this.menuSalir = false;
			break;
		default:
			System.out.println("Ingreso un numero que no esta en el menu");
			break;
		}
		
	}


	private void elegirServicio() {
		List<Servicio> servicios = this.adminServicios.getObject();
		System.out.println("#################################################################################");
		System.out.println("                                      POR FAVOR ELIJA EL SERVICIO QUE DESEA OFRECER ");
		int i = 1;
		for (Servicio servicio : servicios) {
			System.out.println(i + " - " + servicio.getNombreServicio() + " " + servicio.getTipo());
			i++;
		}
		System.out.print("Ingrese el numero de indice del servicio que desee");
		do {
			try {
				int index = scanner.nextInt() - 1;
				scanner.nextLine();
				if (index >= 0 && servicios.size() >= index ) {
					this.menuSalir = false;
					this.servicio = servicios.get(index);
					this.adminServicios.addObject(this.servicio);
					return;
				} else {	
					System.out.println("Por favor eliga un numero que este dentro del rango");
					scanner.nextLine();
				} 
			} catch (InputMismatchException e) {
				System.out.println("Error : " + e.getMessage());
				scanner.nextLine();
			}
		} while (menuSalir);
		System.out.println("#################################################################################");
		System.out.println();
	
	}
	
	public void crearServicio() {
		utils.menuDecoracion("Crear Servicio", "Elija una de las opciones del servicio que desee crear", "Servicio Domestico" , "Servicio De Salud");
		try {
			int i = scanner.nextInt();
			switch (i) {
			case 1:
				crearServicioDomestico();
				break;
			case 2:
				crearServicioSalud();
				break;
			default:
				break;
			}
			
			
		} catch(InputMismatchException e) {
			System.out.println("Ingreso una opcion no valida porfavor ingrese un numero que sea valido");
			scanner.nextLine();
		}
		
	}
	

	public void crearServicioSalud() {
		
		//ServicioDomestico servicioDomestico = new ServicioDomestico(null, null)
		TipoDeServicioSalud[] tipoServicio = TipoDeServicioSalud.values();
		int index = 1;
		System.out.println("Elija una de las opciones que este dentro del rango : ");
		for (TipoDeServicioSalud tipoDeServicioSalud : tipoServicio) {
			System.out.println(index + " - " + tipoDeServicioSalud);
			index++;
		}
		while(menuSalir)
		try {
			int opcion = scanner.nextInt();
			scanner.nextLine();
			TipoDeServicioSalud tipoElegido = TipoDeServicioSalud.valueOf(opcion);
			System.out.println("Por favor ingrese el nombre de su servicio");
			String nombreServicio = scanner.nextLine();
			ServicioSalud servicioSalud = new ServicioSalud(nombreServicio, tipoElegido);
			this.servicio = servicioSalud;
			adminServicios.addObject(servicioSalud);
			this.menuSalir = false;
		} catch (InputMismatchException e) {
			System.out.println("ERROR DE CARACTER NO VALIDO : Por favor elija una opción correcta ");
		}
		
	}
	
	public void crearServicioDomestico() {
		TipoDeServicioDomesticos[] tipoServicio = TipoDeServicioDomesticos.values();
		int index = 1;
		System.out.println("Elija una de las opciones que este dentro del rango : ");
		for (TipoDeServicioDomesticos tipoDeServicioDomesticos : tipoServicio) {
			System.out.println(index + " - " + tipoDeServicioDomesticos);
			index++;
		}
		while(menuSalir)
		try {
			int opcion = scanner.nextInt();
			scanner.nextLine();
			TipoDeServicioDomesticos tipoElegido = TipoDeServicioDomesticos.valueOf(opcion);
			System.out.println("Por favor ingrese el nombre de su servicio");
			String nombreServicio = scanner.nextLine();
			ServicioDomestico servicioDomestico = new ServicioDomestico(nombreServicio, tipoElegido);
			this.servicio = servicioDomestico;
			adminServicios.addObject(servicioDomestico);
			this.menuSalir = false;
		} catch (InputMismatchException e) {
			System.out.println("ERROR DE CARACTER NO VALIDO : Por favor elija una opción correcta ");
		}
		
		
		
		
	}
	

	private void crearProveedor() {
		/*
		ProveedorServicio<Servicio> usuario = new ProveedorServicio<Servicio>(nombre, cvu);
		adminProveedor.addObject(usuario); */ 
		System.out.println("Primero necesitamos elegir un servicio existente o crear uno para el proveedor");
		System.out.println("1 - Elegir servicio");
		System.out.println("2 - Crear Un Servicio");
		int option = scanner.nextInt();
		scanner.nextLine();
		switch (option) {
		case 1:
			elegirServicio();
			break;
		case 2: 
			crearServicio();
			break;
		default:
			break;
		}
		System.out.println("#################################################################################");
		System.out.println("Por favor ingrese el nombre que desea para su cuenta de proveedor :");
		String nombre = scanner.nextLine();
		System.out.println("Por favor ingrese el cvu que desea para su cuenta :");
		String cvu = scanner.nextLine();
		System.out.println("Por favor ingrese algun comentario para su cuenta :");
		String comentarios = scanner.nextLine();
		System.out.println("Por favor ingrese el precio por su servicio :");
		double precio = scanner.nextDouble();
		System.out.println("#################################################################################");
		System.out.println(servicio);
		ProveedorServicio<? extends Servicio> pvServicio = new ProveedorServicio<>(nombre, comentarios, cvu, precio, this.servicio);
		adminProveedor.addObject(pvServicio);
	}


	public Servicio getServicio() {
		return servicio;
	}


	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}


}
