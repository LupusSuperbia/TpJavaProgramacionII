package utils;

public class Utilidades {
	
	public void cargaDeDatos() {
		System.out.println("Espere mientras se cargan los datos");
        for (int i = 0; i <= 10; i++) {
        	System.out.print("\r" + (i*10) + "%");
        	try {
            	Thread.sleep(50);
			} catch (Exception e) {
				System.out.print(e);
			}	
		} 
        System.out.println("");
        System.out.println("Ya se cargaron los datos");
	}
	
	public void menuDecoracion(String titulo, String subtitulo, String...strings ) {
		System.out.println("#################################################################################");
		System.out.println("# "+ titulo );
		System.out.println("# "+ subtitulo );
		int i = 1;
		for (String string : strings) {
			System.out.println(i + " - "+ string);
			i++;
		}
		System.out.println("#################################################################################");
	}
	
	public void menuSinDecoracionSubMenus(String...strings ) {
		int i = 1;
		for (String string : strings) {
			System.out.println(i + " - "+ string);
			i++;
		}
	}
	
	
}
