package Classes;

import java.util.HashMap;
import java.util.Map;

public enum TipoDeServicioDomesticos {
	MANTENIMIENTO(1),
	REPARACION(2),
	INSTALACION(3),
	CONSULTA(4),
	NIÑERA(5),
	LIMPIEZA(6),
	JARDINERIA(7),
	PLOMERO(8),;

	private int value;
	private static Map<Object, Object> map = new HashMap<>();
	TipoDeServicioDomesticos(int i) {
		this.value = i;
	}

	static {
		for (TipoDeServicioDomesticos tipoServicioDomesticos : TipoDeServicioDomesticos.values()) {
			map.put(tipoServicioDomesticos.value, tipoServicioDomesticos);
		}
	}


	public static TipoDeServicioDomesticos valueOf(int value) {
		return (TipoDeServicioDomesticos) map.get(value);
	}

	public int getValue() {
		return value;
	}

}
