package com.mycompany.rest.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

	@XmlRootElement(name="especialidads")
	public class EspecialidadList {

		private List<Especialidad> data;

		public List<Especialidad> getData() {
			return data;
		}

		public void setData(List<Especialidad> data) {
			this.data = data;
		}
}
