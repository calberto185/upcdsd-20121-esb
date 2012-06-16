package pe.com.clinicaesb.controller;

import java.util.Vector;

import javax.microedition.media.Controllable;

import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.UiApplication;
import pe.com.clinicaesb.util.Constantes;
import pe.com.clinicaesb.util.Util;
import pe.com.clinicaesb.util.VariableAplicacion;
//import pe.com.clinicaesb.view.ListadoNoticiasScreen;
import pe.com.clinicaesb.view.DetalleDisponibilidadMedicoScreen;
import pe.com.clinicaesb.view.ListadoMedicosScreen;

public class RunProcess implements Runnable {
	
	private int _proceso;
	private Screen _screenDestino;
	private Vector listaNoticiasServicio = null;
	private Vector listaUnidadNegocioServicio = null;

	public RunProcess(int proceso, Screen screenDestino){
		this._proceso = proceso;
		this._screenDestino = screenDestino;
	}
	
	public void run() {
		switch (_proceso) {
		
        case Constantes.OPERACION_INICIO_SESION:
        	operacionInicioSesion();
        	break;
        case Constantes.OPERACION_DETALLE_MEDICO:
        	operacionDetalleHorarioMedico();
	    	break;
		default:
			break;
		}
	}
	
	private void operacionInicioSesion() {
		
		ConsultaController controller = new ConsultaController();
		
		if(controller.prepararSolicitudNoticiaFavorita()){
			controller.obtenerRespuestaNoticiaFavorita();
		}else{
			error(VariableAplicacion.getMensajeError());
			return;
		}
		
		UiApplication.getUiApplication().invokeAndWait(new Runnable() {
			public void run() {

				UiApplication.getUiApplication().pushScreen(new ListadoMedicosScreen());	

			}
		});
		

	}
	
	private void operacionDetalleHorarioMedico() {
		
		UiApplication.getUiApplication().invokeAndWait(new Runnable() {
			public void run() {

				UiApplication.getUiApplication().pushScreen(new DetalleDisponibilidadMedicoScreen());	

			}
		});
		

	}
	
	private void error(final String messageError){
		UiApplication.getUiApplication().invokeAndWait(new Runnable() {
			public void run() {
	
				Util.mostrarMensaje(messageError);
				
				System.exit(0);	
	
			}
		});
	}
		
	private void operacionDetalleNoticia(){
		
	}
	
	private void errorConexion(){
		UiApplication.getUiApplication().invokeAndWait(new Runnable() {
			public void run() {

				//UiApplication.getUiApplication().pushScreen(new MensajeErrorScreen(Constantes.CADENA_VACIA));

			}
		});
	}

}
