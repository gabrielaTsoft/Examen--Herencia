package jerarquia;

public class Hotel extends Hospederia {
	
	protected boolean conDesayuno;		
		
	// Método adicional 	

		public boolean isConDesayuno() {
		return conDesayuno;
	}

	public void setConDesayuno(boolean conDesayuno) {
		this.conDesayuno = conDesayuno;
	}


		public double ValorAdicional () {		
				
			double adicional;				
			adicional= super.calculoSubtotal()*30/100;	
			return adicional;
		}

	
	public Hotel(DatosCliente cliente, int cant_noches, String tipo_temporada, double valorBaseNoche,
			 int capacidad, boolean esFumador, boolean conDesayuno) {
		super(cliente, cant_noches, tipo_temporada, valorBaseNoche, capacidad, esFumador);
		this.conDesayuno = conDesayuno;
	}

	//Validar este metodo
	public int valorACancelar()
	{
		int valorCancelar = 0;
		if(this.bonoDescuento() ==1 || this.bonoDescuento() == 2)
		{
			if(this.ValorAdicional()>1)
			{
				valorCancelar = (int) (this.calculoSubtotal() - this.bonoDescuento());
				System.out.println("El total con descuentos incluidos es de: " + this.valorACancelar());
				return valorCancelar;
			}
		}
		else
		{
			valorCancelar = (int) this.calculoSubtotal();
			System.out.println("El total a cancelar es de: "+ this.valorACancelar());
			return valorCancelar;
		}
		return valorCancelar;
	}		
	

}
