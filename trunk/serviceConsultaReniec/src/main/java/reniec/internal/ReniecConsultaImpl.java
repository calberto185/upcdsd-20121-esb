package reniec.internal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reniec.Persona;
import reniec.ReniecConsulta;

@Service("reniecConsulta")
public class ReniecConsultaImpl implements ReniecConsulta {
	
	@Autowired
	public ReniecConsultaImpl() {
		
	}

	@Transactional
	public Persona consultaDatos(String dni) {
		
		List<Persona> lstPersona =new ArrayList<Persona>();
		Persona persona=null;

		persona = new Persona("41645302", "Felix", "Alfaro", "cayllahua", "26/01/2012", "Av Micaela", "S");
		lstPersona.add(persona);
		persona = new Persona("41645303", "Felix1", "ApePat1", "ApeMat1", "27/01/2012", "Av Micaela", "S");
		lstPersona.add(persona);
		persona = new Persona("41645304", "Felix2", "ApePat2", "ApeMat2", "28/01/2012", "Av Micaela", "S");
		lstPersona.add(persona);
		persona = new Persona("41645305", "Felix3", "ApePat3", "ApeMat3", "29/01/2012", "Av Micaela", "S");
		lstPersona.add(persona);
		persona = new Persona("41645306", "Felix4", "ApePat4", "ApeMat4", "30/01/2012", "Av Micaela", "S");
		lstPersona.add(persona);
		
		persona=null;
		for(int i=0; i<= lstPersona.size();i++){
			if (lstPersona.get(i).getDni().equals(dni)){
				persona=lstPersona.get(i);
				break;
			} 
		}
		return persona;
	}

}
