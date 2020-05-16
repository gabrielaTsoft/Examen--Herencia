package jerarquia;

public class DatosCliente {
	private String Nombre;
	private String Rut;
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getRut() {
		return Rut;
	}
	public void setRut(String rut) {
		Rut = rut;
	}
	
	//Constructor
	public DatosCliente(String nombre, String rut) {
		super();
		Nombre = nombre;
		Rut = rut;
	}
	
	

}
