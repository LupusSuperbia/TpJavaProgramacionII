package main;

import Classes.AdministradorProveedor;
import Classes.AdministradorUsuario;
import Classes.Efectivo;
import Classes.MetodoDePago;
import Classes.ProveedorServicio;
import Classes.Servicio;
import Classes.ServicioDomestico;
import Classes.TipoDeServicioDomesticos;
import Classes.TransferenciaBancaria;
import Classes.Usuario;
import menu.MenuMain;
import utils.PrecargaDeMenu;
import utils.Utilidades;

public class Main {
    public static void main(String[] args) {
    	AdministradorUsuario adminUsuarios = new AdministradorUsuario();
        AdministradorProveedor adminProveedor = new AdministradorProveedor();
        
        PrecargaDeMenu precarga = new PrecargaDeMenu();
        Utilidades utilidades = new Utilidades();
        MenuMain menuMain = new MenuMain(adminUsuarios, adminProveedor);
        
        precarga.precargarDatos(adminProveedor, adminUsuarios);
        
        //utilidades.cargaDeDatos();
        
        
        
        menuMain.main();
        
        /*
        for (Usuario  usuario : adminUsuarios.getObject()) {
			System.out.println(usuario);
			System.out.println();
		}
        
        for (ProveedorServicio  pdServicio : adminProveedor.getObject() ) {
			System.out.println(pdServicio + "\n");
		}
        */
        
    }
}