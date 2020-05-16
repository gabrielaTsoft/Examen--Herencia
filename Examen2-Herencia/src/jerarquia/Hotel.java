package jerarquia;

public class Hotel extends Hospederia {
	
	private boolean conDesayuno;
	private int cant_noches;	
	
	public boolean isConDesayuno() {
		return conDesayuno;
	}

	public void setConDesayuno(boolean conDesayuno) {
		this.conDesayuno = conDesayuno;
	}

	public int getCant_noches() {
		return cant_noches;
	}

	public void setCant_noches(int cant_noches) {
		this.cant_noches = cant_noches;
	}

	public Hotel(DatosCliente cliente, int cant_noches, String[] tipo_temporada, double valorBaseNoche) {
		super(cliente, cant_noches, tipo_temporada, valorBaseNoche);
		// TODO Auto-generated constructor stub
	}
	

}
