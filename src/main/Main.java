package main;

import java.util.List;

import Classes.AdministradorProveedor;
import Classes.AdministradorServicio;
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
        AdministradorServicio adminServicio = new AdministradorServicio();
        
        PrecargaDeMenu precarga = new PrecargaDeMenu();
        Utilidades utilidades = new Utilidades();
        MenuMain menuMain = new MenuMain(adminUsuarios, adminProveedor, adminServicio);
        
        precarga.precargarDatos(adminProveedor, adminUsuarios, adminServicio);
        
        //utilidades.cargaDeDatos();
        
        List<Servicio> servicios = adminServicio.getObject();
        
        for (Servicio servicio : servicios) {
			System.out.println(servicio);
		}
        
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