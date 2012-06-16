package org.mycompany.afiliacion.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="suscripcion")
public class Suscripcion {

	private String codigo;
	private String telefono;
	private String estado;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "suscripcion [codigo=" + codigo + ", telefono=" + telefono
				+ ", estado=" + estado + "]";
	}
	
	
}
