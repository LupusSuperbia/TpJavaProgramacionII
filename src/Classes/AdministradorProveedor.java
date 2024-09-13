package Classes;

import java.util.List;

public class AdministradorProveedor extends AdministradorObjetos<ProveedorServicio<? extends Servicio>>{

	@Override
	public void addObject(ProveedorServicio<? extends Servicio> obj) {
		this.objs.add(obj);

	}

	@Override
	public void removeObject(ProveedorServicio<? extends Servicio> obj) {
		this.objs.remove(obj);
	}

	@Override
	public List<ProveedorServicio<? extends Servicio>> getObject() {
		return this.objs;
	}


}
