package jerarquia;

public class Cabagna extends Hospederia {
	
	private boolean chimenea;
	
		
	public boolean isChimenea() {
		return chimenea;
	}


	public void setChimenea(boolean chimenea) {
		this.chimenea = chimenea;
	}


	public Cabagna(DatosCliente cliente, int cant_noches, String[] tipo_temporada, double valorBaseNoche) {
		super(cliente, cant_noches, tipo_temporada, valorBaseNoche);
		// TODO Auto-generated constructor stub
	}	

}
