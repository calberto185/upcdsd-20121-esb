package pe.com.clinicaesb.rest.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import pe.com.clinicaesb.rest.domain.Disponibilidad;
import pe.com.clinicaesb.rest.domain.Medico;
import pe.com.clinicaesb.rest.domain.Paciente;


	@Service("pacienteService")
	public class PacienteService {

		protected static Logger logger = Logger.getLogger("service");
		
		// In-memory list
		public List<Medico> medicos = new ArrayList<Medico>();
		
		public PacienteService(){
			logger.debug("Init database");
			
			// Create in-memory list
			Medico medico1 = new Medico();
			medico1.setCodMedico(1L);
			medico1.setNomMedico("Jose Luis");
			medico1.setApelMedico("Perez");
			medico1.setEspecialidadMedico("Medicina Natura");
			medico1.setTipoDocMedico("...");
			medico1.setLstDisponibilidad(generarDisponibilidad());
			
			Medico medico2 = new Medico();
			medico2.setCodMedico(2L);
			medico2.setNomMedico("Marco");
			medico2.setApelMedico("Lazo");
			medico2.setEspecialidadMedico("Medicina general");
			medico2.setTipoDocMedico("...");
			medico2.setLstDisponibilidad(generarDisponibilidad());

			Medico medico3 = new Medico();
			medico3.setCodMedico(3L);
			medico3.setNomMedico("Pablo");
			medico3.setApelMedico("Salda");
			medico3.setEspecialidadMedico("Otorrino");
			medico3.setTipoDocMedico("...");
			medico3.setLstDisponibilidad(generarDisponibilidad());
			
			Medico medico4 = new Medico();
			medico4.setCodMedico(4L);
			medico4.setNomMedico("Manolo");
			medico4.setApelMedico("Rojas");
			medico4.setEspecialidadMedico("Odontologia");
			medico4.setTipoDocMedico("...");
			medico4.setLstDisponibilidad(generarDisponibilidad());
			
			Medico medico5 = new Medico();
			medico5.setCodMedico(5L);
			medico5.setNomMedico("Roberto");
			medico5.setApelMedico("Osorio");
			medico5.setEspecialidadMedico("Medicina general");
			medico5.setTipoDocMedico("...");
			medico5.setLstDisponibilidad(generarDisponibilidad());
			
			Medico medico6 = new Medico();
			medico6.setCodMedico(6L);
			medico6.setNomMedico("Edgard");
			medico6.setApelMedico("Rojas");
			medico6.setEspecialidadMedico("Medicina Natura");
			medico6.setTipoDocMedico("...");
			medico6.setLstDisponibilidad(generarDisponibilidad());
			
			Medico medico7 = new Medico();
			medico7.setCodMedico(7L);
			medico7.setNomMedico("Renzo");
			medico7.setApelMedico("rebolledo");
			medico7.setEspecialidadMedico("Oftalmologia");
			medico7.setTipoDocMedico("...");
			medico7.setLstDisponibilidad(generarDisponibilidad());
			
			Medico medico8 = new Medico();
			medico8.setCodMedico(8L);
			medico8.setNomMedico("Luis");
			medico8.setApelMedico("Bueno");
			medico8.setEspecialidadMedico("Otorrino");
			medico8.setTipoDocMedico("...");
			medico8.setLstDisponibilidad(generarDisponibilidad());
			
			medicos.add(medico1);
			medicos.add(medico2);
			medicos.add(medico3);
			medicos.add(medico4);
			medicos.add(medico5);
			medicos.add(medico6);
			medicos.add(medico7);
			medicos.add(medico8);
			
		}
			
		/**
		 * Retrieves all codigos
		 */
		
		public List<Paciente> getAll() {
			logger.debug("Retrieving all codigos");
			
			return null;
		}
		
		/**
		 * Retrieves all codigos
		 */
		
		public List<Medico> getAllMedics() {
			logger.debug("Recupera todos los medicos");
			
			return medicos;
		}
		
		/**
		 * Retrieves a single codigo
		 */
		public Paciente get( Long id ) {
			logger.debug("Retrieving codigo with id: " + id);
			
			/*for (Paciente paciente:codigos) {
				if (paciente.getId().longValue() == id.longValue()) {
					logger.debug("Found record");
					return paciente;
				}
			}*/
			
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
				/*while(hasFoundSuitableId == false) {
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
				codigos.add(codigo);*/
				
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
				/*for (Paciente codigo:codigos) {
					if (codigo.getId().longValue() == id.longValue()) {
						logger.debug("Found record");
						codigos.remove(codigo);
						return true;
					}
				}*/
				
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
				/*for (Paciente p:codigos) {
					if (p.getId().longValue() == codigo.getId().longValue()) {
						logger.debug("Found record");
						codigos.remove(p);
						codigos.add(codigo);
						return true;
					}
				}*/
				
				logger.debug("No records found");
				return false;
				
			} catch (Exception e) {
				logger.error(e);
				return false;
			}
		}
		
		private List<Disponibilidad> generarDisponibilidad(){
			List<Disponibilidad> lista = new ArrayList<Disponibilidad>();
			
			Random variable = new Random();
			int numeroGenerado = variable.nextInt(25);
			
			for(int i=0; i<numeroGenerado; i++){
				Disponibilidad dispo = new Disponibilidad();
				int dia = variable.nextInt(6)+1;
				
				dispo.setDia(generarDia(dia));
				dispo.setFecha((i+1)+"/07/2012");
				int horario = variable.nextInt(4)+1;
				dispo.setHorario(generarHorario(horario));
				
				lista.add(dispo);
			}
			
			return lista;
		}
		
		private String generarHorario(int numero){
			String horario="";
			switch (numero) {
			case 1:
				horario="09:00 - 11:00";
				break;
			case 2:
				horario="10:00 - 12:00";
				break;
			case 3:
				horario="11:00 - 13:00";
				break;
			case 4:
				horario="14:00 - 16:00";
				break;
			case 5:
				horario="16:00 - 18:00";
				break;
			default:
				horario="No Asignado";
				break;
			}
			return horario;
		}
		
		private String generarDia(int numero){
			String rpta="Si dia";
			switch (numero) {
			case 1:
				rpta = "Domingo";
				break;
			case 2:
				rpta = "Lunes";
				break;
			case 3:
				rpta = "Martes";
				break;
			case 4:
				rpta = "Miercoles";
				break;
			case 5:
				rpta = "Jueves";
				break;
			case 6:
				rpta = "Viernes";
				break;
			case 7:
				rpta = "Sábado";
				break;
			default:
				break;
			}
			
			return rpta;
		}
	}
	
	
