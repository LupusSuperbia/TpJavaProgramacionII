package Classes;

import java.util.List;

public class AdministradorServicio extends AdministradorObjetos<Servicio>{

	@Override
	public void addObject(Servicio obj) {
		this.objs.add(obj);

	}

	@Override
	public void removeObject(Servicio obj) {
		this.objs.remove(obj);

	}

	@Override
	public List<Servicio> getObject() {
		return this.objs;
	}

}
