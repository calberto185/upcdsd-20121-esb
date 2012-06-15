package com.mycompany.rest.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
	
	@XmlRootElement(name="persons")
	public class PacienteList {

		private List<Paciente> data;

		public List<Paciente> getData() {
			return data;
		}

		public void setData(List<Paciente> data) {
			this.data = data;
		}
		
}
