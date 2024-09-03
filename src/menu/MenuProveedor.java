package menu;

import Classes.AdministradorProveedor;
import utils.Utilidades;

public class MenuProveedor extends Menu{
	Utilidades utils = new Utilidades();
	private AdministradorProveedor adminProveedor;
	
	public MenuProveedor(AdministradorProveedor adminProveedor) {
		this.adminProveedor = adminProveedor;
	}
	
	
	@Override
	public void main() {
		utils.menuDecoracion("Bienvenido Al panel de Proveedor", "Por favor elija una de las opciones para navegar dentro de los distintos menús:", "Crear Proveedor", "Ingresar Como Proveedor", "Salir");
		
		
	}


	@Override
	public void menuElegido(int numero) {
		// TODO Auto-generated method stub
		
	}


}
