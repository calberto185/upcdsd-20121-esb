package pe.sbs;

import javax.jws.WebService;

/**
 * 
 * @author faalfaro
 */

@WebService(endpointInterface = "pe.sbs.Valida")
public class ValidaImpl implements Valida {

	public String validarSeguroUsuario(String dni) {
		return "RIMAC";
	}
}
