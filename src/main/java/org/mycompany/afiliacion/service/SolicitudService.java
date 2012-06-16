package org.mycompany.afiliacion.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import org.mycompany.afiliacion.domain.Solicitud;

@Service("solicitudService")
public class SolicitudService {

	protected static Logger logger = Logger.getLogger("service");

	private List<Solicitud> Solicitudes = new ArrayList<Solicitud>();

	public SolicitudService() {
		logger.debug("Inicializando la BD");
		
		Solicitud solicitud1 = new Solicitud();
		solicitud1.setCodigo("400");
		solicitud1.setTelefono("123456789");
		solicitud1.setComando("ENTRAR");
		
		Solicitud solicitud2 = new Solicitud();
		solicitud2.setCodigo("500");
		solicitud2.setTelefono("123456789");
		solicitud2.setComando("ENTRAR");
	
		Solicitud solicitud3 = new Solicitud();
		solicitud3.setCodigo("400");
		solicitud3.setTelefono("999999999");
		solicitud3.setComando("ENTRAR");
		
		Solicitud solicitud4 = new Solicitud();
		solicitud4.setCodigo("500");
		solicitud4.setTelefono("898989789");
		solicitud4.setComando("ENTRAR");
		
		Solicitudes.add(solicitud1);
		Solicitudes.add(solicitud2);
		Solicitudes.add(solicitud3);
		Solicitudes.add(solicitud4);

	}
	
	public List<Solicitud> getAll() {
		logger.debug("Listando las Solicitudes");
		
		return Solicitudes;
	}
	
	public Solicitud get( String codigo, String telefono ) {
		logger.debug("Buscando con codigo: " + codigo + " y telefono : "+ telefono );
		
		for (Solicitud solicitud:Solicitudes) {
			if ((solicitud.getCodigo().equals(codigo)) && 
			   (solicitud.getTelefono().equals(telefono)) ){
				logger.debug("Solicitud encontrada");
				return solicitud;
			}
		}
		
		logger.debug("No hay registros de solicitudes");
		return null;
	}
	

	public Solicitud add(Solicitud solicitud) {
		logger.debug("Agregando nueva solicitud");
		
		try {
			String newId = null;
			Boolean hasFoundSuitableId = false;
			while(hasFoundSuitableId == false) {
				for (int i=0; i <Solicitudes.size(); i++) {
					if (Solicitudes.get(i).getCodigo().equals(solicitud.getCodigo())) {
						newId=solicitud.getCodigo();
						break;
					}
					
					// Exit while loop
					if(i==Solicitudes.size()-1) {
						logger.debug("Asignando el id: " + newId);
						hasFoundSuitableId = true;
					}
				}
			}
			
			// Assign new id
			solicitud.setCodigo(newId);
			// Add to list
			Solicitudes.add(solicitud);
			
			logger.debug("Se agrego un nueva solicitud");
			return solicitud;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	
	public Boolean delete(String codigo, String telefono) {
		logger.debug("Eliminando la solicitud con codigo: " + codigo + " y telefono : "+ telefono);
		
		try {
			for (Solicitud solicitud:Solicitudes) {
				if ((solicitud.getCodigo().equals(codigo)) && 
				    (solicitud.getTelefono().equals(telefono)) ) {
					logger.debug("Registro de solicitud encontrada");
					Solicitudes.remove(solicitud);
					return true;
				}
			}
			
			logger.debug("No se encontro la solicitud");
			return false;
			
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
	
	public Boolean edit(Solicitud solicitud) {
		logger.debug("Editando la solicitud con id: " + solicitud.getCodigo());
		
		try {
			for (Solicitud p:Solicitudes) {
				if (p.getCodigo().equals(solicitud.getCodigo()) &&
				    p.getTelefono().equals(solicitud.getTelefono())	) {
					logger.debug("Registro de solicitud encontrada");
					Solicitudes.remove(p);
					Solicitudes.add(solicitud);
					return true;
				}
			}
			
			logger.debug("No se encontro la solicitud");
			return false;
			
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
}
