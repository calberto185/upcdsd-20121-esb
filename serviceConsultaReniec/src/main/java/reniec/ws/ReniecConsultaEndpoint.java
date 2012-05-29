package reniec.ws;

import org.springframework.util.xml.DomUtils;
import org.springframework.ws.server.endpoint.AbstractDomPayloadEndpoint;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import reniec.Persona;
import reniec.ReniecConsulta;

public class ReniecConsultaEndpoint extends AbstractDomPayloadEndpoint {

	private static final String NAMESPACE_URI = "http://www.springsource.com/reniec";

	private ReniecConsulta reniecConsulta;

	public ReniecConsultaEndpoint(ReniecConsulta reniecConsulta) {
		this.reniecConsulta = reniecConsulta;
	}

	@Override
	protected Element invokeInternal(Element requestElement, Document document) throws Exception {
		Element dniElement = DomUtils.getChildElementByTagName(requestElement, "dni");
		String dniTemp = mapDni(dniElement);
		Persona persona = reniecConsulta.consultaDatos(dniTemp);
		Element responseElement = document.createElementNS(NAMESPACE_URI, "dniResponse");
		responseElement.appendChild(mapPersona(document, persona));
		return responseElement;
	}

	private String mapDni(Element dniElement) {
		String dniT = dniElement.getAttribute("dni");
		return dniT;
	}

	private Element mapPersona(Document document, Persona persona) {
		Element personaElement = document.createElementNS(NAMESPACE_URI, "respuesta");
		personaElement.setAttribute("dni", persona.getDni());
		personaElement.setAttribute("nombre", persona.getNombre());
		personaElement.setAttribute("apellidoPaterno", persona.getApellidoPaterno());
		personaElement.setAttribute("apellidoMaterno", persona.getApellidoMaterno());
		personaElement.setAttribute("fechaNacimiento", persona.getFechaNacimiento());
		personaElement.setAttribute("direccion", persona.getDireccion());
		personaElement.setAttribute("estadoCivil", persona.getEstadoCivil());
		return personaElement;
	}
}