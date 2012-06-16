package org.mycompany.afiliacion.jms.client;

import java.util.List;

import org.mycompany.afiliacion.domain.Suscripcion;


public interface AfiliacionBatchProcessor {


	void processBatch(List<Suscripcion> batch);

}
