package org.mycompany.afiliacion.jms.client;

import java.util.List;

import org.springframework.jms.core.JmsTemplate;

import org.mycompany.afiliacion.domain.Suscripcion;


public class JmsAfiliacionBatchProcessor implements AfiliacionBatchProcessor {

	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void processBatch(List<Suscripcion> batch) {
		for (Suscripcion suscripcion : batch) {
			jmsTemplate.convertAndSend(suscripcion);
		}
	}
}
