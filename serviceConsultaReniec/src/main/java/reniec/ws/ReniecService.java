package reniec.ws;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;

import org.springframework.util.xml.DomUtils;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import reniec.Persona;
import reniec.ReniecConsulta;

public class ReniecService extends WebServiceGatewaySupport implements ReniecConsulta {
	
	private static final String NAMESPACE_URI = "http://www.springsource.com/reniec";
	
	public Persona consultaDatos(String dni) {
		Element requestElement = prepareRequest(dni);
		DOMSource source = new DOMSource(requestElement);
		DOMResult result = new DOMResult();
		getWebServiceTemplate().sendSourceAndReceiveToResult(source, result);
		return processResponse(result.getNode());
	}
	
	private Element prepareRequest(String dni) {
		Document document = getDocument();
		Element requestElement = document.createElementNS(NAMESPACE_URI, "dniRequest");
		requestElement.appendChild(mapDni(document, dni));
		return requestElement;
	}
	
	private Element mapDni(Document document, String dni) {
		Element dniElement = document.createElementNS(NAMESPACE_URI, "dni");
		dniElement.setAttribute("dni", dni);
		return dniElement;
	}
	
	private Document getDocument() {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		}
	}

	private Persona processResponse(Node node) {
		Element responseElement = (Element) node.getFirstChild();
		return mapPersona(DomUtils.getChildElementByTagName(responseElement, "resultado"));
	}
	
	private Persona mapPersona(Element respuestaElement) {
		String dni = respuestaElement.getAttribute("dni");
		String nombre = respuestaElement.getAttribute("nombre");
		String apellidoPaterno = respuestaElement.getAttribute("apellidoPaterno");
		String apellidoMaterno = respuestaElement.getAttribute("apellidoMaterno");
		String fechaNacimiento = respuestaElement.getAttribute("fechaNacimiento");
		String direccion = respuestaElement.getAttribute("direccion");
		String estadoCivil = respuestaElement.getAttribute("estadoCivil");

		return new Persona(dni,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,direccion,estadoCivil);
	}
}
