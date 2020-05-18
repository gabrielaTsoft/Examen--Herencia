package jerarquia;

public class Hospederia extends MedioDeAlojamiento{
	
	protected int capacidad;
	protected boolean esFumador;	
	

	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public boolean isEsFumador() {
		return esFumador;
	}

	public void setEsFumador(boolean esFumador) {
		this.esFumador = esFumador;
	}


	public Hospederia(DatosCliente cliente, int cant_noches, String tipo_temporada, double valorBaseNoche,
			int capacidad, boolean esFumador) {
		super(cliente, cant_noches, tipo_temporada, valorBaseNoche);
		this.capacidad = capacidad;
		this.esFumador = esFumador;
	}
	
		
	

}
