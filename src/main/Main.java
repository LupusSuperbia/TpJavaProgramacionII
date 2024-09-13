package main;


import Classes.AdministradorProveedor;
import Classes.AdministradorServicio;
import Classes.AdministradorUsuario;
import menu.MenuMain;
import utils.PrecargaDeMenu;

public class Main {
    public static void main(String[] args) {
    	// Creo todas las listas que voy a utilizar
    	AdministradorUsuario adminUsuarios = new AdministradorUsuario();
        AdministradorProveedor adminProveedor = new AdministradorProveedor();
        AdministradorServicio adminServicio = new AdministradorServicio();

        PrecargaDeMenu precarga = new PrecargaDeMenu();
        MenuMain menuMain = new MenuMain(adminUsuarios, adminProveedor, adminServicio);

        precarga.precargarDatos(adminProveedor, adminUsuarios, adminServicio);

        
        menuMain.main();


    }
}