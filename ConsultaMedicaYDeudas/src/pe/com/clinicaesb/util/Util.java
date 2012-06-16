package pe.com.clinicaesb.util;

import pe.com.clinicaesb.util.Constantes;
import net.rim.blackberry.api.browser.Browser;
import net.rim.blackberry.api.browser.BrowserSession;
import net.rim.device.api.system.Display;
import net.rim.device.api.system.EncodedImage;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.SeparatorField;

public class Util {
	
	private static final int TAMANIO_M1 = 14;
	
	private static final int TAMANIO_M2 = 16;
	
	private static final int TAMANIO_M3 = 18;
	
	private static final int TAMANIO_M4 = 17;
	
	private static final int TAMANIO_M5 = 18;
	
	private static int    a = 0;
	
	/**
	 * Metodo que devuelve el alto de la pantalla
	 * 
	 * @return
	 */
	public static int getAltoPantalla() {
		return Display.getHeight();
	}

	/**
	 * Metodo que devuelve el ancho de la pantalla
	 * 
	 * @return
	 */
	public static int getAnchoPantalla() {
		return Display.getWidth();
	}
	
	/**
	 * Metodo que pinta los mensajes de alerta de la aplicacion
	 * 
	 * @param mensaje
	 */
	public static void mostrarMensaje(final String mensaje) {
			Dialog.alert(mensaje);
	}	
	
	public static void mostrarMensajeAsincrono(final String mensaje) {
		UiApplication.getUiApplication().invokeLater(new Runnable() {
			public void run() {
				Dialog.alert(mensaje);
			}
		});
	}
	
	/**
	 * Metodo que retorna los tamaños de los textos segun las resoluciones de 
	 * los dispositivos
	 * 
	 * @return
	 */
	public static int tamanioTexto(){
			
		if(getAnchoPantalla() == 320 && getAltoPantalla() == 240){
			return TAMANIO_M1;
		}else{
			
			if(getAnchoPantalla() == 360 && getAltoPantalla() == 400){
				return TAMANIO_M2;
			}else{
				
				if(getAnchoPantalla() == 360 && getAltoPantalla() == 480){
					return TAMANIO_M3;
				}else{
					
					if(getAnchoPantalla() == 480 && getAltoPantalla() == 320){
						return TAMANIO_M4;
					}else{
						
						if(getAnchoPantalla() == 480 && getAltoPantalla() == 360){
							return TAMANIO_M5;
						}
						
					}
				}
			}
			
		}
		
		//Casos fuera de la propuesta
		return Font.getDefault().getHeight();
		
	}
	
	/**
	 * Metodo que pinta la seccion de titulo del aplicativo con un texto personalizado
	 * 
	 * @param texto: Es la cadena que aparecera en el titulo
	 * @return
	 */
	public static LabelField colocarCabeceraConTitulo(final String texto) {
		final EncodedImage image;
		image = EncodedImage.getEncodedImageResource("clinica-logo.PNG");
		LabelField backgroundHeader = new LabelField(){
			protected void paint(Graphics graphics) {
				//graphics.setColor(Color.BLACK);
				int tamano = 0;
				graphics.setColor(Color.WHITE);
				graphics.setBackgroundColor(Constantes.COLOR_CABECERA);
				graphics.clear();
				//graphics.setFont(getFont().derive(Font.BOLD, tamanioTexto()+2, Ui.UNITS_px));
				graphics.setFont(getFont().derive(Font.PLAIN, tamanioTexto()+8, Ui.UNITS_px));
				if (image != null) {
					graphics.drawImage(7, 3, image.getWidth(), image.getHeight(), image, 0, 0, 0);
					tamano = image.getWidth()+5;
				}
	            graphics.drawText(texto, tamano, 10);
	            super.paint(graphics);
			}
			protected void layout(int width, int height) {
				if (image != null) {
					super.layout(width, height+6);
					setExtent(width, image.getHeight()+6);
				}
			}
		};
		return backgroundHeader;
	}

	/**
	 * Asigna el protocolo http a una url
	 * 
	 * @param url
	 * @return
	 */
	public static String ponerProtocolo(String url) {
		if (url != null && !url.startsWith(Constantes.PROTOCOLO_HTTP)) {
			url = Constantes.PROTOCOLO_HTTP + url;
		}
		return url;
	}
	
	public static void irWeb(String rutaWeb) {
		BrowserSession browser = Browser.getDefaultSession();
		browser.displayPage(rutaWeb);
	}
	
}
