package org.mycompany.afiliacion.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import org.mycompany.afiliacion.domain.Suscripcion;

@Service("suscripcionService")
public class SuscripcionService {

	protected static Logger logger = Logger.getLogger("service");

	private List<Suscripcion> Suscripciones = new ArrayList<Suscripcion>();

	public SuscripcionService() {
		logger.debug("Inicializando la BD");
		
		Suscripcion suscripcion1 = new Suscripcion();
		suscripcion1.setCodigo("400");
		suscripcion1.setTelefono("123456789");
		suscripcion1.setEstado("ACTIVO");
		
		Suscripcion suscripcion2 = new Suscripcion();
		suscripcion2.setCodigo("400");
		suscripcion2.setTelefono("827392729");
		suscripcion2.setEstado("ACTIVO");
		
		Suscripcion suscripcion3 = new Suscripcion();
		suscripcion3.setCodigo("500");
		suscripcion3.setTelefono("989288229");
		suscripcion3.setEstado("ACTIVO");
		
		Suscripcion suscripcion4 = new Suscripcion();
		suscripcion4.setCodigo("500");
		suscripcion4.setTelefono("989898989");
		suscripcion4.setEstado("ACTIVO");
		
		Suscripciones.add(suscripcion1);
		Suscripciones.add(suscripcion2);
		Suscripciones.add(suscripcion3);
		Suscripciones.add(suscripcion4);

	}
	
	public List<Suscripcion> getAll() {
		logger.debug("Listando las Suscripciones");
		
		return Suscripciones;
	}
	
	public Suscripcion get( String codigo, String telefono ) {
		logger.debug("Buscando la Suscripcion con codigo: " + codigo + " y telefono : "+ telefono );
		
		for (Suscripcion suscripcion:Suscripciones) {
			if ((suscripcion.getCodigo().equals(codigo)) && 
			   (suscripcion.getTelefono().equals(telefono)) ){
				logger.debug("Suscripcion encontrada");
				return suscripcion;
			}
		}
		
		logger.debug("No hay registros de Suscripciones");
		return null;
	}
	

	public Suscripcion add(Suscripcion suscripcion) {
		logger.debug("Agregando nueva Suscripcion");
		
		try {
			String newId = null;
			Boolean hasFoundSuitableId = false;
			while(hasFoundSuitableId == false) {
				for (int i=0; i <Suscripciones.size(); i++) {
					if (Suscripciones.get(i).getCodigo().equals(suscripcion.getCodigo())) {
						newId=suscripcion.getCodigo();
						break;
					}
					
					// Exit while loop
					if(i==Suscripciones.size()-1) {
						logger.debug("Asignando el id: " + newId);
						hasFoundSuitableId = true;
					}
				}
			}
			
			// Assign new id
			suscripcion.setCodigo(newId);
			// Add to list
			Suscripciones.add(suscripcion);
			
			logger.debug("Se agrego un nueva Suscripcion");
			return suscripcion;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	public Boolean delete(String codigo, String telefono) {
		logger.debug("Eliminando la Suscripcion con codigo: " + codigo + " y telefono : "+ telefono);
		
		try {
			for (Suscripcion suscripcion:Suscripciones) {
				if ((suscripcion.getCodigo().equals(codigo)) && 
				    (suscripcion.getTelefono().equals(telefono)) ) {
					logger.debug("Registro de Suscripcion encontrada");
					Suscripciones.remove(suscripcion);
					return true;
				}
			}
			
			logger.debug("No se encontro la Suscripcion");
			return false;
			
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
	
	public Boolean edit(Suscripcion suscripcion) {
		logger.debug("Editando la Suscripcion con id: " + suscripcion.getCodigo());
		
		try {
			for (Suscripcion p:Suscripciones) {
				if (p.getCodigo().equals(suscripcion.getCodigo()) &&
				    p.getTelefono().equals(suscripcion.getTelefono())	) {
					logger.debug("Registro de Suscripcion encontrada");
					Suscripciones.remove(p);
					Suscripciones.add(suscripcion);
					return true;
				}
			}
			
			logger.debug("No se encontro la Suscripcion");
			return false;
			
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
}
