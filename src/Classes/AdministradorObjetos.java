package Classes;

import java.util.ArrayList;
import java.util.List;

public abstract class AdministradorObjetos<T> {
	protected List<T> objs; // CREAR UNA LISTA PARA GUARDAR LOS OBJETOS CREADOS Y PODER INTERACTUAR CON ELLOS

	 public AdministradorObjetos() {
	        this.objs = new ArrayList<>();
	    }

	 public abstract void addObject(T obj);

	 public abstract void removeObject(T obj);

	 public abstract List<T> getObject();

}
