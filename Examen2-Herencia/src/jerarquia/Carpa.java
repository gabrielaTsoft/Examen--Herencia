package jerarquia;

public class Carpa extends MedioDeAlojamiento {
	
	protected int cantidadPersonas;	
	
	
	public int getCantidadPersonas() {
		return cantidadPersonas;
	}


	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}


	public Carpa(DatosCliente cliente, int cant_noches, String[] tipo_temporada, double valorBaseNoche) {
		super(cliente, cant_noches, tipo_temporada, valorBaseNoche);//Constructor
		// TODO Auto-generated constructor stub
	}

	

}
