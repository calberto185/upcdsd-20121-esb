package pe.com.clinicaesb.application;

import net.rim.device.api.ui.UiApplication;
import pe.com.clinicaesb.view.LoginAplicacionScreen;

/**
 * @author Synopsis
 * 
 * Esta clase extiende de la clase UiApplication, 
 * provee la interfaz gráfica para el usuario
 */
public class ConsultaMedica extends UiApplication {

	/**
     * Punto de entrada para la aplicación
     */ 
    public static void main(String[] args){
    	//Crea una nueva instancia de la aplicación.
    	ConsultaMedica theApp = new ConsultaMedica();       
        theApp.enterEventDispatcher();
    }
    
    /**
     * Crea un nuevo objeto BancaMovil
     */
    public ConsultaMedica()
    {
    	pushScreen(new LoginAplicacionScreen());
    	//pushScreen(new DemoScreen());
    }
    
}
