package com.mycompany.rest.controller;

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

import com.mycompany.rest.domain.Paciente;
import com.mycompany.rest.domain.PacienteList;
import com.mycompany.rest.service.PacienteService;


@Controller
public class PacienteController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name = "pacienteService")
	private PacienteService pacienteService;
	
	@RequestMapping(value = "/codigo/{id}", method = RequestMethod.GET, headers = "Accept=image/jpeg, image/jpg, image/png, image/gif")
	public @ResponseBody
	byte[] getPhoto(@PathVariable("id") Long id) {

		// Call service here
		try {
			// Retrieve image from the classpath
			InputStream is = this.getClass().getResourceAsStream("/bella.jpg");

			// Prepare buffered image
			BufferedImage img = ImageIO.read(is);

			// Create a byte array output stream
			ByteArrayOutputStream bao = new ByteArrayOutputStream();

			// Write to output stream
			ImageIO.write(img, "jpg", bao);

			logger.debug("Retrieving photo as byte array image");
			return bao.toByteArray();

		} catch (IOException e) {
			logger.error(e);
			throw new RuntimeException(e);
		}
	}
	
	@RequestMapping(value = "/codigo/{id}", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody Paciente getPaciente(@PathVariable("id") Long id) {
		logger.debug("Provider has received request to get codigo with id: "
				+ id);

		// Call service here
		return pacienteService.get(id);
	}

	@RequestMapping(value = "/codigo/{id}", method = RequestMethod.GET, headers = "Accept=application/html, application/xhtml+xml")
	public String getPacienteHTML(@PathVariable("id") Long id, Model model) {
		logger.debug("Provider has received request to get codigo with id: "
				+ id);

		// Call service to here
		model.addAttribute("codigo", pacienteService.get(id));

		// This will resolve to /WEB-INF/jsp/getpage.jsp
		return "getpage";
	}
	
	
	@RequestMapping(value = "/codigos", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody PacienteList getCodigo() {
		logger.debug("Provider has received request to get all codigos");

		// Call service here
		PacienteList result = new PacienteList();
		
		result.setData(pacienteService.getAll());

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
