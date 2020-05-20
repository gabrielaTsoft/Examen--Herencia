package jerarquia;

public class Cabagna extends Hospederia {
	
	protected boolean chimenea;
	
		
	public boolean isChimenea() {
		return chimenea;
	}


	public void setChimenea(boolean chimenea) {
		this.chimenea = chimenea;
	}

	
	
	public Cabagna(DatosCliente cliente, int cant_noches, String tipo_temporada, double valorBaseNoche,
			int capacidad, boolean esFumador, boolean chimenea) {
		super(cliente, cant_noches, tipo_temporada, valorBaseNoche, capacidad, esFumador);
		this.chimenea = chimenea;
	}


	//Método incrementaValorBase
	
	public double ValorBase() {		
		double ValorBase =0;		
		if (this.getCapacidad() > 5) {			
			ValorBase = (this.getValorBaseNoche()*18 )/100;			
		}
		return ValorBase;
	}
	
	/*public int valorACancelar()
	{
		int valorCancelar = 0;
		if(this.bonoDescuento() ==1 || this.bonoDescuento() == 2)
		{
			valorCancelar = (int) (this.calculoSubtotal() - this.bonoDescuento());
			System.out.println("El total con descuentos incluidos es de: " + this.valorACancelar());
			return valorCancelar;
		}
		else
		{
			valorCancelar = (int) this.calculoSubtotal();
			System.out.println("El total a cancelar es de: "+ this.valorACancelar());
			return valorCancelar;
		}
	}*/

	@Override
	public double totalAPagar() {
		double totalAPagar=0;	
		double subtotal =0;
		double bonoDcto =0;
		subtotal = super.calculoSubtotal();
		bonoDcto =super.bonoDescuento();
		totalAPagar = subtotal -bonoDcto ;
		return totalAPagar;
	}
	
	public double incrementaValorBase() {
		
		capacidad = (int) (this.valorBaseNoche)*18/100;
		return capacidad;
		
	}

}
