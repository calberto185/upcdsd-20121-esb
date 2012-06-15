package com.mycompany.rest.domain;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="medico")
public class Medico {

	
	private Long CodMedico;
	private String NomMedico;
	private String ApelMedico;
	private String TipoDocMedico;
	private String EspecialidadMedico;
	public Long getCodMedico() {
		return CodMedico;
	}
	public void setCodMedico(Long codMedico) {
		CodMedico = codMedico;
	}
	public String getNomMedico() {
		return NomMedico;
	}
	public void setNomMedico(String nomMedico) {
		NomMedico = nomMedico;
	}
	public String getApelMedico() {
		return ApelMedico;
	}
	public void setApelMedico(String apelMedico) {
		ApelMedico = apelMedico;
	}
	public String getTipoDocMedico() {
		return TipoDocMedico;
	}
	public void setTipoDocMedico(String tipoDocMedico) {
		TipoDocMedico = tipoDocMedico;
	}
	public String getEspecialidadMedico() {
		return EspecialidadMedico;
	}
	public void setEspecialidadMedico(String especialidadMedico) {
		EspecialidadMedico = especialidadMedico;
	}
	@Override
	public String toString() {
		return "Medico [CodMedico=" + CodMedico + ", NomMedico=" + NomMedico
				+ ", ApelMedico=" + ApelMedico + ", TipoDocMedico="
				+ TipoDocMedico + ", EspecialidadMedico=" + EspecialidadMedico
				+ "]";
	}

	
}
