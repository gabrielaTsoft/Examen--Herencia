package jerarquia;

public abstract class MedioDeAlojamiento {
	
	protected DatosCliente cliente;
	protected int cant_noches;
	protected String tipo_temporada ;
	protected double valorBaseNoche;
	
	
	public DatosCliente getCliente() {
		return cliente;
	}

	public void setCliente(DatosCliente cliente) {
		this.cliente = cliente;
	}

	public int getCant_noches() {
		return cant_noches;
	}

	public void setCant_noches(int cant_noches) {
		this.cant_noches = cant_noches;
	}

	public String getTipo_temporada() {
		return tipo_temporada;
	}

	public void setTipo_temporada(String tipo_temporada) {
		this.tipo_temporada = tipo_temporada;
	}

	public double getValorBaseNoche() {
		return valorBaseNoche;
	}

	public void setValorBaseNoche(double valorBaseNoche) {
		this.valorBaseNoche = valorBaseNoche;
	}

	//Constructor
	public MedioDeAlojamiento(DatosCliente cliente, int cant_noches, String tipo_temporada, double valorBaseNoche) {
		
		this.cliente = cliente;
		this.cant_noches = cant_noches;
		this.tipo_temporada = tipo_temporada;
		this.valorBaseNoche = valorBaseNoche;
		
	}
	
	//Método SubTotal el cual devuelve el subtotal a cancelar
	
	public double calculoSubtotal () {	

		double subtotal=0;
		subtotal = this.valorBaseNoche * this.cant_noches;
		return subtotal	;	
		
	}
		
	public double bonoDescuento() {		
		
		double bonoDescuento = 0;			
		if(this.tipo_temporada.equalsIgnoreCase("baja"))
		{
			bonoDescuento = this.calculoSubtotal()*25/100;
		}
		else if (this.tipo_temporada.equalsIgnoreCase("media"))
		{
				bonoDescuento = this.calculoSubtotal()*12.5/100;
		}
		else bonoDescuento = 0;	
		
		return bonoDescuento; 		
	}

	public abstract double totalAPagar();	

}
