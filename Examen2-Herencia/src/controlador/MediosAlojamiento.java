package controlador;

import java.util.ArrayList;

import jerarquia.Cabagna;
import jerarquia.Carpa;
import jerarquia.DatosCliente;
import jerarquia.Hotel;
import jerarquia.MedioDeAlojamiento;

public class MediosAlojamiento {
	
	private ArrayList <MedioDeAlojamiento> alojamiento;
	private Hotel hotel;
	public int cantidadNoches;
	
	public MediosAlojamiento(ArrayList<MedioDeAlojamiento> alojamiento) {
		super();
		this.alojamiento = alojamiento;
	}


	public ArrayList<MedioDeAlojamiento> getAlojamiento() {
		return alojamiento;
	}


	public void setAlojamiento(ArrayList<MedioDeAlojamiento> alojamiento) {
		this.alojamiento = alojamiento;
	}


	/*public int buscarMedioAlojamiento (String nombre) {
		
		for (int i=0;i< alojamiento.size();i++) {			
			if(alojamiento.get(i).getNombreMedio().compareToIgnoreCase(nombre)==0) {				
				return i;					
			}			
		}				
		return -1;			
	}*/
		
	public void ingresarCarpa(Carpa carpa){
		if(this.buscarCliente(carpa.getCliente().getRut()) == -1){
			alojamiento.add(carpa);
		}
	}
	
	public void ingresarHotel(Hotel hotel){
		if(this.buscarCliente(hotel.getCliente().getRut()) == -1){
			alojamiento.add(hotel);
		}
	}
	
	public void ingresarCabagna(Cabagna cabagna){
		if(this.buscarCliente(cabagna.getCliente().getRut()) == -1){
			alojamiento.add(cabagna);
		}
	}
	
	public String mostrarMediosAlojamiento(){
		String mensaje = "";		
		for(int i=0;i< alojamiento.size();i++){
			if (alojamiento.get(i) instanceof Carpa) {
				mensaje = mensaje + 
						"\nMedio de Alojamiento de tipo: Carpa, en Temporada: "+ alojamiento.get(i).getTipo_temporada() + " " +
						"\nValor Base: "+alojamiento.get(i).getValorBaseNoche();
			}else if (alojamiento.get(i) instanceof Hotel) {
				mensaje = mensaje + 
						"\nMedio de Alojamiento de tipo: Hotel, en Temporada: "+ alojamiento.get(i).getTipo_temporada() + " " +
						"\nValor Base: "+alojamiento.get(i).getValorBaseNoche();
			}
			else {
				mensaje = mensaje + 
						"\nMedio de Alojamiento de tipo: Cabaña, en Temporada: "+ alojamiento.get(i).getTipo_temporada() + " " +
						"\nValor Base: "+alojamiento.get(i).getValorBaseNoche();
			}
			
				
		}
		
		return mensaje;
	}

	public int buscarCliente(String rut) {	
	
		for (int i=0; i< alojamiento.size(); i++) {			
			if(alojamiento.get(i).getCliente().getRut().compareToIgnoreCase(rut)==0) {				
				return i;					
			}			
		}		
			
		return -1;			
	}
	
	public String mostrarDatosCliente(String rut){
		String mensaje = "";
		Hotel hotel=null;
		Cabagna cabagna=null;
		Carpa carpa= null;
		if (buscarCliente(rut)!=-1) { //Cliente EXiste
			
			for(int i=0;i< alojamiento.size();i++){
				
				mensaje = mensaje + "\nNombre Cliente: "+alojamiento.get(i).getCliente().getNombre()+
						"\nRut Cliente: "+alojamiento.get(i).getCliente().getRut()+ 						
						"\nCantidad de Noches: "+alojamiento.get(i).getCant_noches()+ 
						"\nValorBase: "+alojamiento.get(i).getValorBaseNoche()+
						"\nTipo de Temporada: "+alojamiento.get(i).getTipo_temporada();
				if(alojamiento.get(i) instanceof Hotel){
					hotel = (Hotel) alojamiento.get(i);
					mensaje = mensaje + "\nCapacidad: "+hotel.getCapacidad()+ 
							"\nCon Desayuno: "+hotel.isConDesayuno() + 
							"\nFumador: "+hotel.isEsFumador();
				}
				else if (alojamiento.get(i) instanceof Cabagna) {
					cabagna = (Cabagna) alojamiento.get(i);
					mensaje = mensaje + "\nCapacidad: "+cabagna.getCapacidad()+
							 "\nEs Fumador: "+ cabagna.isEsFumador()+
							 "\nChimenea: "+ cabagna.isChimenea();
				}
				else {
					carpa = (Carpa) alojamiento.get(i);
					mensaje = mensaje + "\nCapacidad: "+carpa.getCantidadPersonas();
				}					
			}			
		}
		else 
			System.out.println("Cliente no existe...");				
		return mensaje;
	}
	
	public double calcularAdicional() {		
		
		double adicional=0;
		double adicionalPorNoche=0;
			//fijarse en el metodo stock del calzado.... se deben sumar el costo de las dos noches al subtotal.
		for(int i=0; i< alojamiento.size();i++) {
			if (alojamiento.get(i) instanceof Hotel){
				hotel = (Hotel) alojamiento.get(i);			
				if (hotel.isEsFumador() && hotel.isConDesayuno()==true) {					
					adicional =  hotel.ValorAdicional();// Almacena el valor del 30% del subtotal
					hotel.setCant_noches(hotel.getCant_noches() +2);
					//cantidadNoches= hotel.getCant_noches() +2;
					adicionalPorNoche = hotel.getCant_noches()*hotel.getValorBaseNoche();
				}		
			}	
		}
					
		return adicional + adicionalPorNoche;		
	}
	
	public int totalBonoDescuento()
	{	int total = 0;
		Carpa c = null;
		Cabagna cg = null;
		Hotel h = null;
	
		for(int i=0;i < alojamiento.size(); i++){
			if(alojamiento.get(i) instanceof Carpa){
			c = (Carpa) alojamiento.get(i);
			total =(int) (c.calculoSubtotal() - c.bonoDescuento());   
			}
			else if(alojamiento.get(i) instanceof Hotel)
			{
				h = (Hotel) alojamiento.get(i);
				total = (int) (h.calculoSubtotal() - h.bonoDescuento());
			}
			else
			 {
				cg = (Cabagna) alojamiento.get(i);
				total =(int) (cg.calculoSubtotal() - cg.bonoDescuento());
			 }			
	}
	return total;
	}
	
	
	public int cantMediosAlojamiento(int tipo) {
		
		int contador=0;
		
		if (tipo ==1) {
			for (int i=0; i< alojamiento.size();i++) {
				if (alojamiento.get(i) instanceof Carpa) {				
					contador = contador +1;
				}
			}
		}
			
		else if (tipo==2) {
			for (int j=0; j< alojamiento.size();j++) {
				if (alojamiento.get(j) instanceof Hotel) {
				
					contador = contador +1;
				}
			}
		}
		else {
			for (int k=0; k< alojamiento.size();k++) {
				if (alojamiento.get(k) instanceof Cabagna) {
				
					contador = contador +1;
				}
			}			
		}

		return contador;
		
	}
	
	//validar
	public int ValorCancelarPorCliente(String rut)
	{	int valorCancelar;
		Hotel hotel=null;
		Cabagna cabagna=null;
		Carpa carpa= null;
		MedioDeAlojamiento ma =null;
		
		if(buscarCliente(rut)!=-1)
		{
			/*for(int i =0; i< alojamiento.size(); i++)
			{
				if(alojamiento.add(hotel) )
				{	valorCancelar = hotel.valorACancelar();
					System.out.println("El valor a cancelar por cliente es de: " +valorCancelar);
					
					if(alojamiento.add(carpa))
					{	valorCancelar = carpa.valorACancelar();
						System.out.println("El valor a cancelar por cliente es de: " +valorCancelar);
						
						if(alojamiento.add(cabagna))
						{	valorCancelar = cabagna.valorACancelar();
							System.out.println("El valor a cancelar por cliente es de: " +valorCancelar);
						}
					}
				}
				else
				{
					System.out.println("El cliente no existe");
				}*/
			}
		
		return valorCancelar=0;
	}
	
}
