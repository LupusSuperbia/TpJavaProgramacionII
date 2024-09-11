package utils;

import Classes.AdministradorProveedor;
import Classes.AdministradorServicio;
import Classes.AdministradorUsuario;
import Classes.ProveedorServicio;
import Classes.ServicioDomestico;
import Classes.ServicioSalud;
import Classes.TipoDeServicioDomesticos;
import Classes.TipoDeServicioSalud;
import Classes.Usuario;

public class PrecargaDeMenu {
	
	public void precargarDatos(AdministradorProveedor adminProv , AdministradorUsuario adminClien, AdministradorServicio adminServicio) {
		// Creo usuarios de manera predeterminada
		Usuario usuario1 = new Usuario("Robert", "2543bdcd4");
		Usuario usuario2 = new Usuario("Carla", "2543bdcd45123");
		// Los agrego a mi lista de clientes registrados 
		adminClien.addObject(usuario1);
		adminClien.addObject(usuario2);
		// Creo diferentes servicios para poder crear proveedores de servicio
		ServicioDomestico servicioDomestico = new ServicioDomestico("Limpieza de casa", TipoDeServicioDomesticos.LIMPIEZA);
		ServicioDomestico servicioDomestico2 = new ServicioDomestico("Limpieza de oficina", TipoDeServicioDomesticos.LIMPIEZA);
		ServicioDomestico servicioDomestico3 = new ServicioDomestico("Jardineria", TipoDeServicioDomesticos.JARDINERIA);
		ServicioDomestico servicioDomestico4 = new ServicioDomestico("Niñera", TipoDeServicioDomesticos.NIÑERA);
		
		ServicioSalud servicioSalud = new ServicioSalud("Cuidado de enfermos", TipoDeServicioSalud.CUIDADO_DE_ENFERMOS);
		ServicioSalud servicioSalud1 = new ServicioSalud("Vacunación O inyecciones", TipoDeServicioSalud.INYECCIÓN);
		
		adminServicio.addObject(servicioSalud1);
		adminServicio.addObject(servicioSalud);
		adminServicio.addObject(servicioDomestico);
		adminServicio.addObject(servicioDomestico2);
		adminServicio.addObject(servicioDomestico3);
		adminServicio.addObject(servicioDomestico4);
		
		
		
		
		ProveedorServicio<ServicioDomestico> pServicio1 = new ProveedorServicio<ServicioDomestico>("Juana", "Soy muy proactiva me gusta el trato con los niños, me gusta trabajar con niños de 5 a 8 años ", "000051023053", 2500, servicioDomestico4);
		ProveedorServicio<ServicioDomestico> pServicio2 = new ProveedorServicio<ServicioDomestico>("Martin", "Me encanta la jardineria, llevo en el campo desde que soy chico ya que es un ingreso extra y soy muy detallista", "005123051234", 2500, servicioDomestico3);
		ProveedorServicio<ServicioSalud> pServicio3 = new ProveedorServicio<ServicioSalud>("Luciana", "Estudiante de enfermeria, hice un curso para aplicar inyectables", "051234123", 2500, servicioSalud1);
		ProveedorServicio<ServicioSalud> pServicio4 = new ProveedorServicio<ServicioSalud>("Giuliana", "Estudiante de enfermeria, tengo 2 años de experiencia en cuidado de enfermos", "05123512366", 2500, servicioSalud);
			
		
		// Los agrego a mi lista de proveedores registrados 
		adminProv.addObject(pServicio1);
		adminProv.addObject(pServicio2);
		adminProv.addObject(pServicio3);
		adminProv.addObject(pServicio4);
		
	}
}
