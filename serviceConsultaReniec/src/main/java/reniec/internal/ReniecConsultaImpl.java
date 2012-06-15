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

		persona = new Persona("41645302", "Felix", "Alfaro", "cayllahua", "26/01/1986", "Av Micaela", "S");
		lstPersona.add(persona);
		persona = new Persona("41645303", "Werner", "Oda", "ApeMat1", "33/01/1995", "Av San Juan", "S");
		lstPersona.add(persona);
		persona = new Persona("41645304", "Walter", "Guzmán", "Zevallos", "28/01/1980", "Av Ramos", "S");
		lstPersona.add(persona);
		persona = new Persona("41645305", "Leoncio", "Prado", "ApeMat", "29/01/1975", "Av Lima", "S");
		lstPersona.add(persona);
		persona = new Persona("41645306", "Paolo", "Guerrero", "Manrique", "30/01/1991", "Av Hamburgo", "S");
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
