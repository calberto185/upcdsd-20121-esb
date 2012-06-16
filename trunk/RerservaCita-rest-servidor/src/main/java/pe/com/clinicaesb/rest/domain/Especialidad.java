package pe.com.clinicaesb.rest.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="especialidad")
public class Especialidad {

	private Long codEspecilidad;
	private String descripcion;
	private String estado;
	public Long getCodEspecilidad() {
		return codEspecilidad;
	}
	public void setCodEspecilidad(Long codEspecilidad) {
		this.codEspecilidad = codEspecilidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Especialidad [codEspecilidad=" + codEspecilidad
				+ ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
