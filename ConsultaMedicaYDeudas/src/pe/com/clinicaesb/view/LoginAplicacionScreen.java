package pe.com.clinicaesb.view;

import net.rim.device.api.system.DeviceInfo;
import net.rim.device.api.system.GIFEncodedImage;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.CheckboxField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import pe.com.clinicaesb.controller.RunProcess;
import pe.com.clinicaesb.util.Constantes;
import pe.com.clinicaesb.util.Util;
import pe.com.clinicaesb.util.VariableAplicacion;
import pe.com.clinicaesb.util.components.AnimatedGIFField;
import pe.com.clinicaesb.util.components.BotonOpcion;
import pe.com.clinicaesb.util.components.PleaseWaitPopupScreen;

public class LoginAplicacionScreen extends MainScreen implements FieldChangeListener {
	private BotonOpcion btnIngresar;
	private EditField dniUsuario;
	private AnimatedGIFField imagenAnimada = null;
	private XYEdges xy;
	
	public LoginAplicacionScreen(){
		super(NO_VERTICAL_SCROLL | Constantes.NO_SYSTEM_MENU_ITEMS);
		int tamanioTexto = Util.tamanioTexto();
		xy = new XYEdges(1, 1, 1, 1);
		
		//Vertical Field para contener los controles
		VerticalFieldManager vImagenLogo = new VerticalFieldManager(FIELD_HCENTER);
		vImagenLogo.setMargin(15, 0, 0, 0);
		
		GIFEncodedImage ourAnimation = (GIFEncodedImage) GIFEncodedImage.getEncodedImageResource("login.gif");
		imagenAnimada = new AnimatedGIFField(ourAnimation, Field.FIELD_HCENTER);
        //this.add(imagenAnimada);
		vImagenLogo.add(imagenAnimada);
		
		LabelField lblUsuario = new LabelField(Constantes.LABEL_USUARIO+Constantes.DOS_PUNTOS, FIELD_LEFT){
			protected void paint(Graphics graphics) {
				graphics.setColor(Color.BLACK);
				super.paint(graphics);
			}
		};
		lblUsuario.setFont(getFont().derive(Font.BOLD, tamanioTexto, Ui.UNITS_px));
		lblUsuario.setMargin(10, 5, 0, 5);
		lblUsuario.setPadding(10, 0, 0, 10);

		dniUsuario = new EditField(Constantes.CADENA_VACIA,Constantes.CADENA_VACIA) {
			protected void displayFieldFullMessage()
			{
				//Este método se deja en blanco para no mostrar el mensaje de "Field Full".
				//En caso se desee ver un mensaje descomentar el código inferior.
				//Status.show("No puede ingresar más de 8 dígitos.");
			}
			protected void paint(Graphics graphics) {
				graphics.setColor(Color.BLACK);
				graphics.drawRoundRect(0, 0, Util.getAnchoPantalla() - 10 * Constantes.MARGIN_PANTALLA, getHeight(), 10, 10);
				super.paint(graphics);

			}
		};
		
		dniUsuario.setMargin(Constantes.MARGIN_PANTALLA, Constantes.MARGIN_PANTALLA, Constantes.MARGIN_PANTALLA, Constantes.MARGIN_PANTALLA);
		dniUsuario.setPadding(0, 10, 0, 10);

		HorizontalFieldManager hNombreUsuario = new HorizontalFieldManager(FIELD_HCENTER | USE_ALL_WIDTH);// {
		hNombreUsuario.add(dniUsuario);
		
		btnIngresar = new BotonOpcion(Constantes.LABEL_INGRESAR, FIELD_HCENTER | USE_ALL_WIDTH); 
		btnIngresar.setAltura(getFont().getHeight()+10);
		btnIngresar.setAncho(Util.getAnchoPantalla() / 2 - 5);
		btnIngresar.setVerticalPadding(5);
		btnIngresar.setBackgroundColorFocused(Constantes.COLOR_BOTON_FOCO_LIMON);
		btnIngresar.setChangeListener(this);
		
		btnIngresar.setMargin(Constantes.MARGEN_BOTONES_TRANSACCIONALES,5,5,5);
		
		this.add(vImagenLogo);
		this.add(lblUsuario);
		this.add(hNombreUsuario);
		this.add(btnIngresar);
		
	}
	
	public void fieldChanged(Field field, int context) {

		if (field == btnIngresar) {

			//Enviar parámetros a validar en servicio
			//Redireccionar a Lector de Noticias
			//Util.mostrarMensaje("La contra es:"+claveUsuario.getText()+"\nLa Encriptada es:"+contrasenia+"\nLa desEncriptada es:"+rpta);
			if(dniUsuario.getText().trim().equalsIgnoreCase(Constantes.CADENA_VACIA)) {
				dniUsuario.setText(Constantes.CADENA_VACIA);
				Util.mostrarMensaje(Constantes.MENSAJE_CAMPOS_VACIOS);
			} else {
				VariableAplicacion.setDni(dniUsuario.getText());
				RunProcess rp = new RunProcess(Constantes.OPERACION_INICIO_SESION, this);
				PleaseWaitPopupScreen.showScreenAndWait(rp, Constantes.TEXTO_PROCESANDO);
			}
		}
	}

}
