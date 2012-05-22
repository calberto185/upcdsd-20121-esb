package reniec;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String ciudad;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public Persona(String nomb, String ape, String ciu) {
		this.nombre=nomb;
		this.apellido=ape;
		this.ciudad=ciu;
		
	}
	
}
