package pe.com.clinicaesb.domain;

import java.util.Vector;

public class Medico {

	private String nombre;
	private String apellido;
	private String especialidad;
	private Vector disponibilidad;
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
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public Vector getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(Vector disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
}
