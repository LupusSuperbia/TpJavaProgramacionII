package menu;

import java.util.Scanner;

import utils.Utilidades;

public abstract class Menu {
	protected Scanner scanner = new Scanner(System.in);
	protected Utilidades utils = new Utilidades();
	protected boolean salir = false;
	protected boolean menuSalir = true;
	
	
	public abstract void main();
	
	public abstract void menuElegido(int numero);
		
	
	
	}
