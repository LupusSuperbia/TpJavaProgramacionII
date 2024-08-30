package Classes;

import java.math.BigDecimal;
import java.sql.Date;

public class Servicio {
	private int idServicio; 
	private String nombreServicio;
	private BigDecimal precio;
	private Date turno;
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public String getNombreServicio() {
		return nombreServicio;
	}
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Date getTurno() {
		return turno;
	}
	public void setTurno(Date turno) {
		this.turno = turno;
	}
	
	
	
}
