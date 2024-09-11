package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import Classes.AdministradorProveedor;
import Classes.AdministradorServicio;
import Classes.AdministradorUsuario;
import utils.Utilidades;

public class MenuMain extends Menu{
	private Scanner scanner = new Scanner(System.in);
	private Utilidades utils = new Utilidades();
	private AdministradorUsuario adminUsuarios;
	private AdministradorProveedor adminProveedor;
	private AdministradorServicio adminServicio;
	private MenuUsuario menuUsuario;
	private MenuProveedor menuProveedor;
	private boolean salir = false;
	
	
	public MenuMain(AdministradorUsuario adminUsuarios, AdministradorProveedor adminProveedor, AdministradorServicio adminServicio) {
		this.adminProveedor = adminProveedor;
		this.adminUsuarios = adminUsuarios;
		this.adminServicio = adminServicio;
		this.menuUsuario = new MenuUsuario(this.adminUsuarios, this.adminProveedor);
		this.menuProveedor = new MenuProveedor(this.adminProveedor, this.adminServicio);
	}
	
	
	public void main() {
		while(!salir) {
		try {
				utils.menuDecoracion("Bienvenido A ServiceSP", "Por favor elija una de las opciones para navegar dentro de los distintos menús:", "Menu Usuario 🙍‍♂️🙍", "Menu Proveedor  👷‍♂️👷‍♀", "Salir");
				System.out.println("Ingrese una opción: ");
				int opcion = scanner.nextInt();
				menuElegido(opcion);			
		} catch (InputMismatchException e) {
			System.out.println("Ocurrio un error inesperado " + e.getLocalizedMessage() );
			scanner.next();
		}
		}
		return;
		
		
	}
	
	
	public void menuElegido(int numero) {
		switch (numero) {
		case 1:
			menuUsuario.main();
			break;
		case 2:
			menuProveedor.main();
			break;
		default:
			System.out.println("Ha elegido salir de la aplicación, muchas gracias por utilizar ServiceSP vuelva pronto");
			this.salir = true;
			return;
		}
	}
	
	
	
	
}
