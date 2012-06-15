package com.mycompany.rest.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="especialidad")
public class Especialidad {

	private Long CodEspecilidad;
	private String Descripcion;
	private String Estado;
	public Long getCodEspecilidad() {
		return CodEspecilidad;
	}
	public void setCodEspecilidad(Long codEspecilidad) {
		CodEspecilidad = codEspecilidad;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	@Override
	public String toString() {
		return "Especialidad [CodEspecilidad=" + CodEspecilidad
				+ ", Descripcion=" + Descripcion + ", Estado=" + Estado + "]";
	}
	
	
}
