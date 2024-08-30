package Classes;

public class ProveedorServicio  extends Persona{
	// Servicio 
    private int pdServicio;
    private Servicio servicioPrestado;

    public int getPdServicio() {
        return pdServicio;
    }

    public Servicio getServicioPrestado() {
        return servicioPrestado;
    }

    public void setPdServicio(int pdServicio) {
        this.pdServicio = pdServicio;
    }

    public void setServicioPrestado(Servicio servicioPrestado) {
        this.servicioPrestado = servicioPrestado;
    }


}

