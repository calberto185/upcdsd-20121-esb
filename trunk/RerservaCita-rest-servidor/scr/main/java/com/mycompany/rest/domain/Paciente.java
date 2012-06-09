package com.mycompany.rest.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Paciente")

public class Paciente {

	private Long CodPaciente;
	private String NomPaciente;
	private String ApelPaciente;
	private String CorreoPaciente;
	private String CelularPaciente;
	private String DirPaciente;
	private String FNacPaciente;
	public Long getCodPaciente() {
		return CodPaciente;
	}
	public void setCodPaciente(Long codPaciente) {
		CodPaciente = codPaciente;
	}
	public String getNomPaciente() {
		return NomPaciente;
	}
	public void setNomPaciente(String nomPaciente) {
		NomPaciente = nomPaciente;
	}
	public String getApelPaciente() {
		return ApelPaciente;
	}
	public void setApelPaciente(String apelPaciente) {
		ApelPaciente = apelPaciente;
	}
	public String getCorreoPaciente() {
		return CorreoPaciente;
	}
	public void setCorreoPaciente(String correoPaciente) {
		CorreoPaciente = correoPaciente;
	}
	public String getCelularPaciente() {
		return CelularPaciente;
	}
	public void setCelularPaciente(String celularPaciente) {
		CelularPaciente = celularPaciente;
	}
	public String getDirPaciente() {
		return DirPaciente;
	}
	public void setDirPaciente(String dirPaciente) {
		DirPaciente = dirPaciente;
	}
	public String getFNacPaciente() {
		return FNacPaciente;
	}
	public void setFNacPaciente(String fNacPaciente) {
		FNacPaciente = fNacPaciente;
	}
	@Override
	public String toString() {
		return "Paciente [CodPaciente=" + CodPaciente + ", NomPaciente="
				+ NomPaciente + ", ApelPaciente=" + ApelPaciente
				+ ", CorreoPaciente=" + CorreoPaciente + ", CelularPaciente="
				+ CelularPaciente + ", DirPaciente=" + DirPaciente
				+ ", FNacPaciente=" + FNacPaciente + "]";
	}
	
	
	
}
