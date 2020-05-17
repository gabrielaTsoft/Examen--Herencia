package controlador;

import java.util.ArrayList;
import jerarquia.MedioDeAlojamiento;

public class MediosAlojamiento {
	
	private ArrayList <MedioDeAlojamiento> Alojamiento;
	

	public ArrayList<MedioDeAlojamiento> getAlojamiento() {
		return Alojamiento;
	}

	public void setAlojamiento(ArrayList<MedioDeAlojamiento> alojamiento) {
		Alojamiento = alojamiento;
	}
	
	
	
	public MediosAlojamiento(ArrayList<MedioDeAlojamiento> alojamiento) {
		super();
		Alojamiento = alojamiento;
	}

	public int buscarMedioAlojamiento (String alojamiento) {
		
		for (int i=0; i< Alojamiento.size(); i++) {			
			if(Alojamiento.get(i).getNombreMedio().compareToIgnoreCase(alojamiento)==0) {				
				return i;					
			}			
		}		
			
		return -1;							
	}
	
	
	
	
}
