package presentacion;

import java.util.ArrayList;

import org.w3c.dom.CDATASection;
import controlador.MediosAlojamiento;
import jerarquia.Cabagna;
import jerarquia.Carpa;
import jerarquia.DatosCliente;
import jerarquia.Hotel;
import jerarquia.MedioDeAlojamiento;



public class App {

	public static int menu() {
		System.out.println("\nMedios de Alojamiento");
		System.out.println("1) Ingresar Medios de Alojamiento");
		System.out.println("2) Mostrar Medios de Alojamiento");
		System.out.println("3) Mostrar Datos de un Cliente");
		System.out.println("4) Total Adicional");
		System.out.println("5) Total bono descuento");
		System.out.println("6) Cantidad medios de alojamiento ");
		System.out.println("7) Valor a cancelar por un cliente");
		System.out.println("8) Incremento del valor base");
		System.out.println("\nIngrese una opci�n para comenzar...");

		return Leer.datoInt();

	}

	public static String pideMedioAlojamiento() {
		System.out.println("\nIngrese el Medio de Alojamiento...");
		return Leer.dato();
	}
	public static String pideRutCliente() {
		System.out.println("\nIngrese el rut del cliente...");
		return Leer.dato();
	}

	public static void main(String[] args) {

		int opcion;
		String nombreMedioAlojamiento;
		String rutCliente;
	    	
		MediosAlojamiento medios = new MediosAlojamiento(new ArrayList<>()); 
		ArrayList<MedioDeAlojamiento> listaMedios = medios.getAlojamiento();
		
		

		do {
			opcion = menu(); // almacenar un entero

			switch (opcion) {
			case 1:				
				
				rutCliente = pideRutCliente();
				if (medios.buscarCliente(rutCliente) == -1) {					
					 					
					System.out.println("�Nombre Cliente?");
					String nombre_Cliente= Leer.dato();
					
					System.out.println("�valorBaseNoche?");
					int valorBase = Leer.datoInt();
					
					System.out.println("�Cantidad de Noches?");
					int cant_noches = Leer.datoInt();	
					
					
					System.out.println("�TipoTemporada?");
					String tem = Leer.dato();	
					
					int respuesta;
					String nombreMedio;
					
					do {
						System.out.println("\n�El Medio de Alojamiento es:  1) Carpa   2)Hotel    3) Caba�a?");
						System.out.println("Ingrese una de las opciones para continuar...");
						respuesta = Leer.datoInt(); // 1
					} while (respuesta < 1 || respuesta > 3); 
					
					if (respuesta == 1) {					
					
						System.out.println("�Cantidad de Personas?");
						int cant_personas = Leer.datoInt();
						medios.ingresarCarpa(new Carpa(new DatosCliente(nombre_Cliente, rutCliente), cant_noches, tem,valorBase,cant_personas));
						nombreMedio="Carpa";
					}
					
					else if (respuesta == 2) {
						
						System.out.println("�Capacidad");
						int capacidad = Leer.datoInt();						
						System.out.println("�Es Fumador? true/false");
						boolean esfumador = Leer.datoBoolean();
						System.out.println("�Con Desayuno? true/false");
						boolean desayuno = Leer.datoBoolean();
						medios.ingresarHotel(new Hotel(new DatosCliente(nombre_Cliente, rutCliente), cant_noches, tem, valorBase,capacidad, esfumador,desayuno));
						nombreMedio="Hotel";
					}
					else{
						System.out.println("�Capacidad");
						int capacidad = Leer.datoInt();						
						System.out.println("�Es Fumador? true/false");
						boolean esfumador = Leer.datoBoolean();
						System.out.println("�Con Chimenea? true/false");
						boolean chimenea = Leer.datoBoolean();
						medios.ingresarCabagna(new Cabagna(new DatosCliente(nombre_Cliente, rutCliente), cant_noches, tem, valorBase,capacidad, esfumador, chimenea));
						nombreMedio="Caba�a";
					}																
				}
				else {
					System.out.println("Medio de Alojamiento ya existe para este cliente");
				}
				break;
			case 2:						
				System.out.println(medios.mostrarMediosAlojamiento());
				break;				
			case 3:
				System.out.println("\n Ingrese el Rut del cliente: ");
				String rut= Leer.dato();
				System.out.println(medios.mostrarDatosCliente(rut));
				break;
			case 4:				
				System.out.println("\n Total Adicional: " + medios.calcularAdicional());				
				break;	
			case 5:				
				System.out.println(" "+ medios.totalBonoDescuento());
				break;
			case 6:						
				int respuesta;				
				System.out.println("\n�ingrese Medio de Alojamiento a buscar:   1) Carpa   2)Hotel    3) Caba�a?");					
				respuesta = Leer.datoInt(); // 1				
				System.out.println("\nLa Cant es: " + medios.cantMediosAlojamiento(respuesta));					
				break;	
			case 7:		
				System.out.println("\n Ingrese el Rut del cliente: ");
				String rut_cliente= Leer.dato();
				System.out.println("\nValor a cancelar : " + medios.ValorCancelarPorCliente(rut_cliente));
				break;
			case 8:		
				System.out.println("\n Incremento del Valor Base: " +medios.incrementaValorBase());				
				break;
			}
			
			
		} while (opcion != 9); // Para salirnos el valor debe ser false

	}

}
