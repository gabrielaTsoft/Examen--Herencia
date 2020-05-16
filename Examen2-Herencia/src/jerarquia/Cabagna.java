package jerarquia;

public class Cabagna extends Hospederia {
	
	protected boolean chimenea;
	
		
	public boolean isChimenea() {
		return chimenea;
	}


	public void setChimenea(boolean chimenea) {
		this.chimenea = chimenea;
	}


	public Cabagna(DatosCliente cliente, int cant_noches, String[] tipo_temporada, double valorBaseNoche) {
		super(cliente, cant_noches, tipo_temporada, valorBaseNoche); //Constructor
		// TODO Auto-generated constructor stub
	}	

}
