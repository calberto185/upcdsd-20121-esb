package org.mycompany.afiliacion.controller;

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

import org.mycompany.afiliacion.domain.Suscripcion;
import org.mycompany.afiliacion.domain.SuscripcionList;
import org.mycompany.afiliacion.service.SuscripcionService;

@Controller
public class SuscripcionController {

protected static Logger logger = Logger.getLogger("controller");

	
	@Resource(name = "suscripcionService")
	private SuscripcionService suscripcionService;

	@RequestMapping(value = "/suscripciones", method = RequestMethod.GET, 
			headers = "Accept=application/xml, application/json")
	public @ResponseBody SuscripcionList getSuscripcion() {
		logger.debug("Lista todas las suscripciones");

		// Call service here
		SuscripcionList result = new SuscripcionList();
		
		result.setData(suscripcionService.getAll());

		return result;
	}
	
	@RequestMapping(value = "/suscripcion/{codigo},{telefono}", method = RequestMethod.GET, 
			headers = "Accept=application/xml, application/json")
	public @ResponseBody Suscripcion getSuscripcion(@PathVariable("codigo") String codigo, 
			                                    @PathVariable("telefono") String telefono) {
		return suscripcionService.get(codigo,telefono);
	}

	/*
	@RequestMapping(value = "/solicitud/{id}", method = RequestMethod.GET, 
	              headers = "Accept=application/html, application/xhtml+xml")
	public String getSolicitudHTML(@PathVariable("id") Long id, Model model) {
		logger.debug("Provider has received request to get person with id: "
				+ id);

		// Call service to here
		model.addAttribute("chiste", chisteService.get(id));

		// This will resolve to /WEB-INF/jsp/getpage.jsp
		return "getpage";
	}
*/


	@RequestMapping(value = "/suscripcion", method = RequestMethod.POST, 
			headers = "Accept=application/xml, application/json")
	public @ResponseBody
	Suscripcion addSuscripcion(@RequestBody Suscripcion suscripcion) {
		logger.debug("Sirve para añadir una suscripcion");

		// Call service to here
		return suscripcionService.add(suscripcion);
	}

	@RequestMapping(value = "/suscripcion/{codigo},{telefono}", method = RequestMethod.PUT, 
			headers = "Accept=application/xml, application/json")
	public @ResponseBody
	String updateSuscripcion(@PathVariable("codigo") String codigo, 
			@PathVariable("telefono") String telefono, 
			@RequestBody Suscripcion suscripcion) {
		logger.debug("Devuelve la suscripcion con codigo: "+ codigo+ " y telefono , "+telefono);

		suscripcion.setCodigo(codigo);
		suscripcion.setTelefono(telefono);
		return suscripcionService.edit(suscripcion).toString();
	}

	@RequestMapping(value = "/suscripcion/{codigo},{telefono}", method = RequestMethod.DELETE, 
			headers = "Accept=application/xml, application/json")
	public @ResponseBody
	String deleteSuscripcion(@PathVariable("codigo") String codigo, 
			@PathVariable("telefono") String telefono, 
			@RequestBody Suscripcion suscripcion) {
		logger.debug("Elimina la suscripcion con codigo: "+ codigo+ " y telefono , "+telefono);

		return suscripcionService.delete(codigo,telefono).toString();
	}
}
