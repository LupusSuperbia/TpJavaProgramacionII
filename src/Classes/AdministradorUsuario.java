package Classes;

import java.util.List;

public class AdministradorUsuario extends AdministradorObjetos<Usuario> {

	@Override
	public void addObject(Usuario obj) {
		this.objs.add(obj);
	}

	@Override
	public void removeObject(Usuario obj) {
		this.objs.remove(obj);

	}

	@Override
	public List<Usuario> getObject() {
		return this.objs;
	}


}
