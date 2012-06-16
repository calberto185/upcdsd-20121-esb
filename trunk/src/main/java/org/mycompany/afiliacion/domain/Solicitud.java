package org.mycompany.afiliacion.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="solicitud")
public class Solicitud {

	private String codigo;
	private String telefono;
	private String comando;
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
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	@Override
	public String toString() {
		return "solicitud [codigo=" + codigo + ", telefono=" + telefono
				+ ", comando=" + comando + "]";
	}
	
	
}
