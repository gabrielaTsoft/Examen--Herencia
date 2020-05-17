package presentacion;

import java.util.ArrayList;

import org.w3c.dom.CDATASection;
import controlador.MediosAlojamiento;



public class App {

	public static int menu() {
		System.out.println("\nMedios de Alojamiento");
		System.out.println("1) Ingresar Medios de Alojamiento");
		System.out.println("2) Mostrar medios de Alojamiento");
		/*System.out.println("3) Obtener valor Venta de un calzado");
		System.out.println("4) Cantidad de calzados TOP (calzados con valor venta mayor a 80.000");
		System.out.println("5) Total de impuestos especificos (calzados formal hombre y mujer");
		System.out.println("6) Total de descuentos (calzados formal hombre y mujer");
		System.out.println("7) Salir");*/
		System.out.println("Ingrese una opción para comenzar...");

		return Leer.datoInt();

	}

	public static String pideMedioAlojamiento() {
		System.out.println("\nMedio de Alojamiento?");
		return Leer.dato();
	}

	public static void main(String[] args) {

		int opcion;
		String nombreMedioAlojamiento;
	    String [] temporada =  new String[3];

		// TiendaCalzado tienda = new TiendaCalzado(); //contructro vacio
		MediosAlojamiento medios = new MediosAlojamiento(new ArrayList<>()); 

		do {
			opcion = menu(); // almacenar un entero

			switch (opcion) {
			case 1:
				nombreMedioAlojamiento = pideMedioAlojamiento();
				if (medios.buscarMedioAlojamiento(nombreMedioAlojamiento) == -1) {
					System.out.println("¿valorBaseNoche?");
					int valorBase = Leer.datoInt();
					
					System.out.println("¿Cantidad de Noches?");
					int cant_noches = Leer.datoInt();
					
					System.out.println("¿Nombre Cliente?");
					String nombre_Cliente= Leer.dato();
					
					System.out.println("¿Rut Cliente?");
					String rut_Cliente= Leer.dato();
					
					
					for (int i=0; i< temporada.length;i++) {
						System.out.println("¿TipoTemporada?");
						String tem = Leer.dato();
						temporada[i]= tem;
					}
						
					
				}
				break;
			case 2:
				//System.out.println(tienda.calzadosMujer());
				break;
			
			}

		} while (opcion != 3); // Para salirnos el valor debe ser false

	}

}
