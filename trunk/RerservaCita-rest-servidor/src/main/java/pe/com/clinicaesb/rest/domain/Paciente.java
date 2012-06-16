package pe.com.clinicaesb.rest.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="paciente")

public class Paciente {

	private Long Id;
	private String nomPaciente;
	private String apelPaciente;
	private String correoPaciente;
	private String celularPaciente;
	private String dirPaciente;
	private String fechaNacPaciente;
	private String dni;
	private String telefonoFijo;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNomPaciente() {
		return nomPaciente;
	}
	public void setNomPaciente(String nomPaciente) {
		this.nomPaciente = nomPaciente;
	}
	public String getApelPaciente() {
		return apelPaciente;
	}
	public void setApelPaciente(String apelPaciente) {
		this.apelPaciente = apelPaciente;
	}
	public String getCorreoPaciente() {
		return correoPaciente;
	}
	public void setCorreoPaciente(String correoPaciente) {
		this.correoPaciente = correoPaciente;
	}
	public String getCelularPaciente() {
		return celularPaciente;
	}
	public void setCelularPaciente(String celularPaciente) {
		this.celularPaciente = celularPaciente;
	}
	public String getDirPaciente() {
		return dirPaciente;
	}
	public void setDirPaciente(String dirPaciente) {
		this.dirPaciente = dirPaciente;
	}
	public String getFechaNacPaciente() {
		return fechaNacPaciente;
	}
	public void setFechaNacPaciente(String fechaNacPaciente) {
		this.fechaNacPaciente = fechaNacPaciente;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefonoFijo() {
		return telefonoFijo;
	}
	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	@Override
	public String toString() {
		return "Paciente [Id=" + Id + ", nomPaciente=" + nomPaciente
				+ ", apelPaciente=" + apelPaciente + ", correoPaciente="
				+ correoPaciente + ", celularPaciente=" + celularPaciente
				+ ", dirPaciente=" + dirPaciente + ", fechaNacPaciente="
				+ fechaNacPaciente + ", dni=" + dni + ", telefonoFijo="
				+ telefonoFijo + "]";
	}
	
}