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

import org.mycompany.afiliacion.domain.Solicitud;
import org.mycompany.afiliacion.domain.SolicitudList;
import org.mycompany.afiliacion.service.SolicitudService;

@Controller
public class SolicitudController {

protected static Logger logger = Logger.getLogger("controller");

	
	@Resource(name = "solicitudService")
	private SolicitudService solicitudService;

	@RequestMapping(value = "/solicitudes", method = RequestMethod.GET, 
			headers = "Accept=application/xml, application/json")
	public @ResponseBody SolicitudList getSolicitud() {
		logger.debug("Lista todas las solicitudes");

		// Call service here
		SolicitudList result = new SolicitudList();
		
		result.setData(solicitudService.getAll());

		return result;
	}
	
	@RequestMapping(value = "/solicitud/{codigo},{telefono}", method = RequestMethod.GET, 
			headers = "Accept=application/xml, application/json")
	public @ResponseBody Solicitud getSolicitud(@PathVariable("codigo") String codigo, 
			                                    @PathVariable("telefono") String telefono) {
		return solicitudService.get(codigo,telefono);
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


	@RequestMapping(value = "/solicitud", method = RequestMethod.POST, 
			headers = "Accept=application/xml, application/json")
	public @ResponseBody
	Solicitud addSolicitud(@RequestBody Solicitud solicitud) {
		logger.debug("Sirve para añadir una solicitud");

		// Call service to here
		return solicitudService.add(solicitud);
	}

	@RequestMapping(value = "/solicitud/{codigo},{telefono}", method = RequestMethod.PUT, 
			headers = "Accept=application/xml, application/json")
	public @ResponseBody
	String updateSolicitud(@PathVariable("codigo") String codigo, 
			@PathVariable("telefono") String telefono, 
			@RequestBody Solicitud solicitud) {
		logger.debug("Devuelve la solicitud con codigo: "+ codigo+ " y telefono , "+telefono);

		solicitud.setCodigo(codigo);
		solicitud.setTelefono(telefono);
		return solicitudService.edit(solicitud).toString();
	}

	@RequestMapping(value = "/solicitud/{codigo},{telefono}", method = RequestMethod.DELETE, 
			headers = "Accept=application/xml, application/json")
	public @ResponseBody
	String deleteSolicitud(@PathVariable("codigo") String codigo, 
			@PathVariable("telefono") String telefono, 
			@RequestBody Solicitud solicitud) {
		logger.debug("Elimina la solicitud con codigo: "+ codigo+ " y telefono , "+telefono);

		return solicitudService.delete(codigo,telefono).toString();
	}
}
