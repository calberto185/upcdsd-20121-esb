package com.mycompany.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mycompany.rest.domain.Paciente;


	@Service("pacienteService")
		public class PacienteService {

		protected static Logger logger = Logger.getLogger("service");
		
		// In-memory list
		public List<Paciente> codigos = new ArrayList<Paciente>();
		
		public PacienteService(){
			logger.debug("Init database");
			
			// Create in-memory list
			Paciente paciente1 = new Paciente();
			
			paciente1.setId(0L);
			paciente1.setNomPaciente("juan");
			paciente1.setApelPaciente("Perez");
			paciente1.setCorreoPaciente("xxxxxx");
			paciente1.setCelularPaciente("1234567");
			paciente1.setDNI("12345678");
			paciente1.setDirPaciente("calle 1");
			
			
			Paciente paciente2 = new Paciente();
			
			paciente2.setId(0L);
			paciente2.setNomPaciente("mario");
			paciente2.setApelPaciente("Gomez");
			paciente2.setCorreoPaciente("yyyyyyyxxxxxx");
			paciente2.setCelularPaciente("765489");
			paciente2.setDNI("09875123");
			paciente2.setDirPaciente("calle 2");
			
			
			codigos.add(paciente1);
			codigos.add(paciente2);		
			
		}
			
		/**
		 * Retrieves all codigos
		 */
		
		public List<Paciente> getAll() {
			logger.debug("Retrieving all codigos");
			
			return codigos;
		}
		
		/**
		 * Retrieves a single codigo
		 */
		public Paciente get( Long id ) {
			logger.debug("Retrieving codigo with id: " + id);
			
			for (Paciente paciente:codigos) {
				if (paciente.getId().longValue() == id.longValue()) {
					logger.debug("Found record");
					return paciente;
				}
			}
			
			logger.debug("No records found");
			return null;
		}
		
		/**
		 * Adds a new codigo
		 */
		public Paciente add(Paciente codigo) {
			logger.debug("Adding new codigo");
			
			try {
				// Find suitable id
				Long newId = 0L;
				Boolean hasFoundSuitableId = false;
				while(hasFoundSuitableId == false) {
					for (int i=0; i <codigos.size(); i++) {
						if (codigos.get(i).getId().longValue() == newId.longValue()) {
							newId++;
							break;
						}
						
						// Exit while loop
						if(i==codigos.size()-1) {
							logger.debug("Assigning id: " + newId);
							hasFoundSuitableId = true;
						}
					}
				}
				
				// Assign new id
				codigo.setId(newId);
				// Add to list
				codigos.add(codigo);
				
				logger.debug("Added new codigo");
				return codigo;
			} catch (Exception e) {
				logger.error(e);
				return null;
			}
		}
		
		/**
		 * Deletes an existing person
		 */
		public Boolean delete(Long id) {
			logger.debug("Deleting codigo with id: " + id);
			
			try {
				for (Paciente codigo:codigos) {
					if (codigo.getId().longValue() == id.longValue()) {
						logger.debug("Found record");
						codigos.remove(codigo);
						return true;
					}
				}
				
				logger.debug("No records found");
				return false;
				
			} catch (Exception e) {
				logger.error(e);
				return false;
			}
		}
		
		
		/**
		 * Edits an existing codigo
		 */
		public Boolean edit(Paciente codigo) {
			logger.debug("Editing codigo with id: " + codigo.getId());
			
			try {
				for (Paciente p:codigos) {
					if (p.getId().longValue() == codigo.getId().longValue()) {
						logger.debug("Found record");
						codigos.remove(p);
						codigos.add(codigo);
						return true;
					}
				}
				
				logger.debug("No records found");
				return false;
				
			} catch (Exception e) {
				logger.error(e);
				return false;
			}
		}
		
		
	}

}
