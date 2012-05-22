package reniec.ws;

import org.springframework.util.xml.DomUtils;
import org.springframework.ws.server.endpoint.AbstractDomPayloadEndpoint;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import reniec.Persona;
import reniec.ReniecConsulta;
import reniec.internal.ReniecConsultaImpl;

public class ReniecConsultaEndpoint extends AbstractDomPayloadEndpoint {

	private static final String NAMESPACE_URI = "http://www.springsource.com/reniec";

	private ReniecConsulta reniecConsulta;

	public ReniecConsultaEndpoint() {
		this.reniecConsulta = new ReniecConsultaImpl();
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
		personaElement.setAttribute("nombre", persona.getNombre());
		personaElement.setAttribute("apellido", persona.getApellido());
		personaElement.setAttribute("ciudad", persona.getCiudad());
		/*for (Distribution distribution : confirmation.getAccountContribution().getDistributions()) {
			Element distributionElement = document.createElementNS(NAMESPACE_URI, "distribution");
			distributionElement.setAttribute("beneficiary", distribution.getBeneficiary());
			distributionElement.setAttribute("amount", distribution.getAmount().toString());
			distributionElement.setAttribute("percentage", distribution.getPercentage().toString());
			distributionElement.setAttribute("totalSavings", distribution.getTotalSavings().toString());
			confirmationElement.appendChild(distributionElement);
		}*/
		return personaElement;
	}
}