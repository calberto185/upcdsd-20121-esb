package reniec.internal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reniec.Persona;
import reniec.ReniecConsulta;;

@Service("reniecConsulta")
public class ReniecConsultaImpl implements ReniecConsulta {

	@Transactional
	public Persona consultaDatos(String dni) {

		Persona person = new Persona("Juan","Camaney","Tangamandapio");
		return person;
	}

}
