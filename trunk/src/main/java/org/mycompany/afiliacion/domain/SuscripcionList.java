package org.mycompany.afiliacion.domain;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Suscripciones")
public class SuscripcionList {
	private List<Suscripcion> data;

	public List<Suscripcion> getData() {
		return data;
	}

	public void setData(List<Suscripcion> data) {
		this.data = data;
	}
}
