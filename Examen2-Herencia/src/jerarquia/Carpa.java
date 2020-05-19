package jerarquia;

public class Carpa extends MedioDeAlojamiento {
	
	protected int cantidadPersonas;	
	
	
	public int getCantidadPersonas() {
		return cantidadPersonas;
	}


	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public Carpa(DatosCliente cliente, int cant_noches, String tipo_temporada, double valorBaseNoche,
			int cantidadPersonas) {
		super(cliente, cant_noches, tipo_temporada, valorBaseNoche);
		this.cantidadPersonas = cantidadPersonas;
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
		totalAPagar = super.calculoSubtotal() - super.bonoDescuento();
		return totalAPagar;
	}

	
	

}
