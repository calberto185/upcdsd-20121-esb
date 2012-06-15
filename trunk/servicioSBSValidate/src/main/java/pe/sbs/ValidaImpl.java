package pe.sbs;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import pe.sbs.domain.Asegurado;

/**
 * 
 * @author faalfaro
 */

@WebService(endpointInterface = "pe.sbs.Valida")
public class ValidaImpl implements Valida {
	
	private List<Asegurado> lstDocumentos;
	
	public ValidaImpl(){
		lstDocumentos = new ArrayList<Asegurado>();
		
		Asegurado asegurado = new Asegurado();
		asegurado.setDni("41645302");
		asegurado.setAseguradora("RIMAC");
		lstDocumentos.add(asegurado);
		
		asegurado = new Asegurado();
		asegurado.setDni("41645303");
		asegurado.setAseguradora("PACIFICO");
		lstDocumentos.add(asegurado);
		
		asegurado = new Asegurado();
		asegurado.setDni("41645302");
		asegurado.setAseguradora("MAPFRE");
		lstDocumentos.add(asegurado);
	}

	public String validarSeguroUsuario(String dni) {
		String EmpresaAseguradora="NINGUNO";
		for(Asegurado asegurado: lstDocumentos){
			if(dni.equals(asegurado.getDni())){
				EmpresaAseguradora = asegurado.getAseguradora(); 
				break;
			}
		}
		
		return EmpresaAseguradora;
		
	}
}
