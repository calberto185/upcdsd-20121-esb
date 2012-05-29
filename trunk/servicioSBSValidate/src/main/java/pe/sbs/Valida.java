package pe.sbs;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Interface del WebService SOAP. Utiliza las anotaciones de JAX-WS. La
 * configuraci—n de Apache CXF se encuentra en el applicationContext.xml dentro
 * del WEB-INF.
 * 
 * @author faalfaro
 */
@WebService
public interface Valida {

	/**
	 * Operacion del Web Service
	 * 
	 * @param dni
	 * @return String con el dni del paciente asegurado
	 */
	public String validarSeguroUsuario(@WebParam(name = "dni") String dni);
	
}
