package pe.com.clinicaesb.rest.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.clinicaesb.rest.domain.MedicoList;
import pe.com.clinicaesb.rest.domain.Paciente;
//import pe.com.clinicaesb.rest.domain.PacienteList;
import pe.com.clinicaesb.rest.service.PacienteService;

/**
 * REST service provider
 * 
 * Only GET and POST will return values PUT and DELETE will not.
 */
@Controller
public class PacienteController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name = "pacienteService")
	private PacienteService pacienteService;
	
	@RequestMapping(value = "/consultaMedica", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody MedicoList getDisponibilidadMedica() {
		logger.debug("Consulta de disponibilidad médica");

		// Llamar al servicio
		MedicoList result = new MedicoList();
		
		result.setData(pacienteService.getAllMedics());

		return result;
	}
	
	@RequestMapping(value = "/codigo", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody
	Paciente addPaciente(@RequestBody Paciente codigo) {
		logger.debug("Provider has received request to add new codigo");

		// Call service to here
		return pacienteService.add(codigo);
	}

	@RequestMapping(value = "/codigo/{id}", method = RequestMethod.PUT, headers = "Accept=application/xml, application/json")
	public @ResponseBody
	String updatePaciente(@PathVariable("id") Long id, @RequestBody Paciente codigo) {
		logger.debug("Provider has received request to edit codigo with id: "
				+ id);

		// Call service here
		codigo.setId(id);
		return pacienteService.edit(codigo).toString();
	}

	@RequestMapping(value = "/codigo/{id}", method = RequestMethod.DELETE, headers = "Accept=application/xml, application/json")
	public @ResponseBody
	String deleteEmployee(@PathVariable("id") Long id) {
		logger.debug("Provider has received request to delete codigo with id: "
				+ id);

		// Call service here
		return pacienteService.delete(id).toString();
	}
	
	
}
