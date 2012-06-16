package pe.com.clinicaesb.rest.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="medico")
public class Medico {

	
	private Long CodMedico;
	private String nomMedico;
	private String apelMedico;
	private String tipoDocMedico;
	private String especialidadMedico;
	private List<Disponibilidad> lstDisponibilidad;
	public Long getCodMedico() {
		return CodMedico;
	}
	public void setCodMedico(Long codMedico) {
		CodMedico = codMedico;
	}
	public String getNomMedico() {
		return nomMedico;
	}
	public void setNomMedico(String nomMedico) {
		this.nomMedico = nomMedico;
	}
	public String getApelMedico() {
		return apelMedico;
	}
	public void setApelMedico(String apelMedico) {
		this.apelMedico = apelMedico;
	}
	public String getTipoDocMedico() {
		return tipoDocMedico;
	}
	public void setTipoDocMedico(String tipoDocMedico) {
		this.tipoDocMedico = tipoDocMedico;
	}
	public String getEspecialidadMedico() {
		return especialidadMedico;
	}
	public void setEspecialidadMedico(String especialidadMedico) {
		this.especialidadMedico = especialidadMedico;
	}
	public List<Disponibilidad> getLstDisponibilidad() {
		return lstDisponibilidad;
	}
	public void setLstDisponibilidad(List<Disponibilidad> lstDisponibilidad) {
		this.lstDisponibilidad = lstDisponibilidad;
	}
	
}
