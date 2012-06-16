package org.mycompany.afiliacion.domain;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="solicitudes")
public class SolicitudList {
	private List<Solicitud> data;

	public List<Solicitud> getData() {
		return data;
	}

	public void setData(List<Solicitud> data) {
		this.data = data;
	}
}
