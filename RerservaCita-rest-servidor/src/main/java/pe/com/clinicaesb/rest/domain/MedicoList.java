package pe.com.clinicaesb.rest.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

	
	@XmlRootElement(name="medicos")
	public class MedicoList {

		private List<Medico> data;

		public List<Medico> getData() {
			return data;
		}

		public void setData(List<Medico> data) {
			this.data = data;
		}
}
