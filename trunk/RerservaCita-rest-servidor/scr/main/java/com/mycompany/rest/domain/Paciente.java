package com.mycompany.rest.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="paciente")

public class Paciente {

	private Long Id;
	private String NomPaciente;
	private String ApelPaciente;
	private String CorreoPaciente;
	private String CelularPaciente;
	private String DirPaciente;
	private String FNacPaciente;
	private String DNI;
	private String TelefonoFijo;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getTelefonoFijo() {
		return TelefonoFijo;
	}
	public void setTelefonoFijo(String telefonoFijo) {
		TelefonoFijo = telefonoFijo;
	}
	@Override
	public String toString() {
		return "Paciente [Id=" + Id + ", NomPaciente=" + NomPaciente
				+ ", ApelPaciente=" + ApelPaciente + ", CorreoPaciente="
				+ CorreoPaciente + ", CelularPaciente=" + CelularPaciente
				+ ", DirPaciente=" + DirPaciente + ", FNacPaciente="
				+ FNacPaciente + ", DNI=" + DNI + ", TelefonoFijo="
				+ TelefonoFijo + "]";
	}
	
	
	
}