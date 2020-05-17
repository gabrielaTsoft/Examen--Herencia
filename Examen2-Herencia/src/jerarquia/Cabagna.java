package jerarquia;

public class Cabagna extends Hospederia {
	
	protected boolean chimenea;
	
		
	public boolean isChimenea() {
		return chimenea;
	}


	public void setChimenea(boolean chimenea) {
		this.chimenea = chimenea;
	}


	public Cabagna(DatosCliente cliente, int cant_noches, String[] tipo_temporada, double valorBaseNoche, String nombreMedio) {
		super(cliente, cant_noches, tipo_temporada, valorBaseNoche,nombreMedio); //Constructor
		// TODO Auto-generated constructor stub
	}	
	
	//Método incrementaValorBase
	
	public double ValorBase() {
		
		double ValorBase =0;
		
		if (this.getCapacidad() > 5) {
			
			ValorBase = (this.getValorBaseNoche()*18 )/100;
			
		}
		return ValorBase;
	}

}
