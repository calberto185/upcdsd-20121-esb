package pe.com.clinicaesb.rest.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="disponibilidad")
public class Disponibilidad {
	
	private String dia;
	private String fecha;
	private String horario;
	
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}

	
}
