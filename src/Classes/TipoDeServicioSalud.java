package Classes;

import java.util.HashMap;
import java.util.Map;

public enum TipoDeServicioSalud {
	CONSULTA_MEDICA(1),
    EXAMEN_DIAGNOSTICO(2),
    TRATAMIENTO_FISIOTERAPIA(3),
    CIRUGIA(4),
    TERAPIA_PSICOLOGICA(5),
    INYECCIÓN(6),
    CUIDADO_DE_ENFERMOS(7),;

    private int value;
	private static Map<Object, Object> map = new HashMap<>();
	TipoDeServicioSalud(int i) {
		this.value = i;
	}

	static {
		for (TipoDeServicioSalud tipoServicioSalud : TipoDeServicioSalud.values()) {
			map.put(tipoServicioSalud.value, tipoServicioSalud);
		}
	}


	public static TipoDeServicioSalud valueOf(int value) {
		return (TipoDeServicioSalud) map.get(value);
	}

	public int getValue() {
		return value;
	}
}
