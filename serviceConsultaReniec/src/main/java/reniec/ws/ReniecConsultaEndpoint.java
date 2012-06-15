package reniec.ws;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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
		System.out.println("---------------------->SE INVOCO EL SERVICIO");
		Element dniElement = DomUtils.getChildElementByTagName(requestElement, "dni");
		String dniTemp = mapDni(dniElement);
		System.out.println("Se invocó con dni-->"+dniTemp);
		Persona persona = reniecConsulta.consultaDatos(dniTemp);
		Element responseElement = document.createElementNS(NAMESPACE_URI, "dniResponse");
		/*Element respuesta = document.createElement("respuesta");
		respuesta.appendChild(document.createTextNode(persona.getNombre()));
		requestElement.appendChild(respuesta);*/
		responseElement.appendChild(mapPersona(document, persona));
		System.out.println("---------------------->RESPUESTA DEL SERVICIO");
		return responseElement;
	}

	private String mapDni(Element dniElement) {
		String dniT = dniElement.getAttribute("dni");
		return dniT;
	}

	private static Element mapPersona(Document document, Persona persona) {
		Element personaElement = document.createElement("respuesta");
		
		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder=null;
        String xmlString = "";
		try {
			docBuilder = dbfac.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			//e.printStackTrace();
			xmlString = "Error en el servicio";
			personaElement.appendChild(document.createTextNode(xmlString));
			return personaElement;
		}
        Document documentTemp = docBuilder.newDocument();
        
		Element personaRoot = documentTemp.createElement("Root");
		
		Element element = documentTemp.createElement("dni");
		element.appendChild(documentTemp.createTextNode(persona.getDni()));
		personaRoot.appendChild(element);
		
		element = documentTemp.createElement("nombre");
		element.appendChild(documentTemp.createTextNode(persona.getNombre()));
		personaRoot.appendChild(element);
		
		element = documentTemp.createElement("apellidoPaterno");
		element.appendChild(documentTemp.createTextNode(persona.getApellidoPaterno()));
		personaRoot.appendChild(element);
		
		element = documentTemp.createElement("apellidoMaterno");
		element.appendChild(documentTemp.createTextNode(persona.getApellidoMaterno()));
		personaRoot.appendChild(element);
		
		element = documentTemp.createElement("fechaNacimiento");
		element.appendChild(documentTemp.createTextNode(persona.getFechaNacimiento()));
		personaRoot.appendChild(element);
		
		element = documentTemp.createElement("direccion");
		element.appendChild(documentTemp.createTextNode(persona.getDireccion()));
		personaRoot.appendChild(element);
		
		element = documentTemp.createElement("estadoCivil");
		element.appendChild(documentTemp.createTextNode(persona.getEstadoCivil()));
		personaRoot.appendChild(element);
		
		documentTemp.appendChild(personaRoot);
		
		//Output the XML
		//set up a transformer
        TransformerFactory transfac = TransformerFactory.newInstance();
        Transformer trans;
        
		try {
			trans = transfac.newTransformer();
		
	        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
	        trans.setOutputProperty(OutputKeys.INDENT, "no");
	
	        //create string from xml tree
	        StringWriter sw = new StringWriter();
	        StreamResult result = new StreamResult(sw);
	        DOMSource source = new DOMSource(documentTemp);
	        trans.transform(source, result);
	        xmlString = sw.toString();
		} catch (TransformerConfigurationException tce) {
			tce.printStackTrace();
		} catch (TransformerException te) {
			te.printStackTrace();
		}
        
		personaElement.appendChild(document.createTextNode(xmlString));
		return personaElement;
	}
}