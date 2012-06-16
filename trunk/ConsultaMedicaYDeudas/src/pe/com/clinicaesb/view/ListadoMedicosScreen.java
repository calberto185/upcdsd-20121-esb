package pe.com.clinicaesb.view;

import java.util.Vector;

import net.rim.device.api.collection.ReadableList;
import net.rim.device.api.system.Characters;
import net.rim.device.api.system.DeviceInfo;
import net.rim.device.api.system.KeypadListener;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.DrawStyle;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.KeywordFilterField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.ListField;
import net.rim.device.api.ui.component.ListFieldCallback;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import pe.com.clinicaesb.controller.RunProcess;
import pe.com.clinicaesb.domain.ElementoList;
import pe.com.clinicaesb.domain.Medico;
import pe.com.clinicaesb.util.Constantes;
import pe.com.clinicaesb.util.Util;
import pe.com.clinicaesb.util.VariableAplicacion;
import pe.com.clinicaesb.util.components.PleaseWaitPopupScreen;

public class ListadoMedicosScreen extends MainScreen  implements FieldChangeListener{
	
	private Vector _listaNoticias;
	private ElementoList _listaMedicosControl;
	private KeywordFilterField keywordFilterField;
	private ListCallback listCallback;
	
	public ListadoMedicosScreen(){
		//super(NO_VERTICAL_SCROLL | Constantes.NO_SYSTEM_MENU_ITEMS);
		super(USE_ALL_HEIGHT | NO_HORIZONTAL_SCROLL | USE_ALL_WIDTH);
		_listaNoticias = VariableAplicacion.getListaMedico();
		int tamanioTexto = Util.tamanioTexto();
		LabelField titulo = Util.colocarCabeceraConTitulo("Listado de Médicos");
		setBanner(titulo);
		

        this.add(new SeparatorField());
		
		// Cuerpo
		VerticalFieldManager mainManager = new VerticalFieldManager(Manager.USE_ALL_WIDTH | Manager.VERTICAL_SCROLLBAR  | Manager.VERTICAL_SCROLL){//VerticalFieldManager(Manager.VERTICAL_SCROLL | Manager.VERTICAL_SCROLLBAR | USE_ALL_HEIGHT | USE_ALL_WIDTH | Manager.FIELD_HCENTER | Manager.FIELD_VCENTER) {
			protected void paint(Graphics graphics) {
				graphics.setColor(Constantes.COLOR_LABEL);
				super.paint(graphics);
			}
		};
		
		keywordFilterField = new KeywordFilterField();
		keywordFilterField.setLabel(Constantes.CADENA_VACIA);
		String msgError="";
		if(VariableAplicacion.getMensajeError()!=null){
			msgError= VariableAplicacion.getMensajeError();
		}
		keywordFilterField.setEmptyString(msgError, DrawStyle.HCENTER);
		
		setearListCallBack();
		if(tamanioTexto*3<Constantes.LISTA_ALTURA){
			keywordFilterField.setRowHeight(Constantes.LISTA_ALTURA);
		}else{
			keywordFilterField.setRowHeight((tamanioTexto*3));
		}
		
		VerticalFieldManager v = new VerticalFieldManager(FIELD_HCENTER | Manager.VERTICAL_SCROLL | Manager.VERTICAL_SCROLLBAR | USE_ALL_WIDTH);
		v.setMargin(Constantes.MARGIN_PANTALLA, Constantes.MARGIN_PANTALLA, Constantes.MARGIN_PANTALLA, Constantes.MARGIN_PANTALLA);
		v.add(keywordFilterField);
		mainManager.add(v);
		this.add(mainManager);
		
	}
	
	
	public void fieldChanged(Field field, int context) {
		
		if(field.equals(keywordFilterField)){
			displayInfoScreen();
		}
		
	}
	
	public boolean navigationClick(int status, int time) {
		if ((status & KeypadListener.STATUS_TRACKWHEEL) != KeypadListener.STATUS_TRACKWHEEL) {
           Field focus = UiApplication.getUiApplication().getActiveScreen() .getLeafFieldWithFocus();
            
            if (focus instanceof ListField) {
            	
            	Medico medico = (Medico) keywordFilterField.getSelectedElement();
            	VariableAplicacion.setMedico(medico);
            	verDetalle();
    			return true;

            }
			
		}

		return super.navigationClick(status, time);
	}
	
	private void verDetalle(){
		RunProcess rp = new RunProcess(Constantes.OPERACION_DETALLE_MEDICO, this);
		PleaseWaitPopupScreen.showScreenAndWait(rp, Constantes.TEXTO_PROCESANDO);
	}
	
	/* seccion anterior*/
	private void setearListCallBack() {
		_listaMedicosControl = new ElementoList(_listaNoticias);
		listCallback = new ListCallback();
		keywordFilterField.setCallback(listCallback);
		keywordFilterField.setSourceList(_listaMedicosControl, _listaMedicosControl);
		
		for (int i = 0; i < _listaNoticias.size(); i++) {
			keywordFilterField.insert(i);
			listCallback.insert((Medico) _listaNoticias.elementAt(i), i);
		}
		listCallback.setLista(keywordFilterField.getResultList());
	}
	
	protected boolean keyChar(char key, int status, int time) {
		if (key == Characters.ENTER) {
			displayInfoScreen();
			return true;
		}
		return super.keyChar(key, status, time);
	}
	
	private void displayInfoScreen() {
		Medico noticia = (Medico) keywordFilterField.getSelectedElement();
		if (noticia != null) {
			verDetalle();
		}
	}
	
	private class ListCallback implements ListFieldCallback {
		private Vector listElements = new Vector();
		private ReadableList lista;

		private int tamanioLetra = Util.tamanioTexto();

		public ListCallback() {
		}

		public void drawListRow(ListField list, Graphics g, int index, int y, int w) {
			int altura=0;
			if(tamanioLetra*3<Constantes.LISTA_ALTURA){
				altura = Constantes.LISTA_ALTURA/3 ;
			}else{
				altura = tamanioLetra;
			}
			Medico noticia = (Medico) lista.getAt(index);
			g.setFont((g.getFont().derive(Font.BOLD, tamanioLetra)));
			g.setColor(Constantes.COLOR_BOTON_YANBAL_NARANJA);
			g.drawText(noticia.getEspecialidad(), 4, y, DrawStyle.ELLIPSIS, w);
			
			g.setFont((g.getFont().derive(Font.PLAIN, tamanioLetra)));
			g.setColor(Color.BLACK);
			g.drawText(noticia.getNombre()+", "+noticia.getApellido(), 4, y + (altura), DrawStyle.ELLIPSIS, w);
			
			g.setColor(Constantes.COLOR_AZUL);
			g.drawText("Verificar Detalle de Horario.", 4, y + altura*2, DrawStyle.ELLIPSIS, w);

			g.setColor(Color.GRAY);
			g.setBackgroundColor(Color.GRAY);
			if(DeviceInfo.getDeviceName().equals("9900") || DeviceInfo.getDeviceName().equals("9550")){
				g.drawLine(0, y + (altura*3)-1, Util.getAnchoPantalla(), y + (altura*3)-1);
			}else{
				g.drawLine(0, y + (altura*3), Util.getAnchoPantalla(), y + (altura*3));
			}

		}

		public Object get(ListField list, int index) {
			return listElements.elementAt(index);
		}

		public int indexOfList(ListField list, String p, int s) {
			return listElements.indexOf(p, s);
		}

		public int getPreferredWidth(ListField list) {
			return Util.getAnchoPantalla();
		}

		public void insert(Medico toInsert, int index) {
			listElements.addElement(toInsert);
		}

		public void setLista(ReadableList lista) {
			this.lista = lista;
		}
	}
	
}
