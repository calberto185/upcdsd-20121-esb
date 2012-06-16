package pe.com.clinicaesb.view;

import java.util.Vector;

import pe.com.clinicaesb.domain.Disponibilidad;
import pe.com.clinicaesb.util.Util;
import pe.com.clinicaesb.util.VariableAplicacion;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.MainScreen;

public class DetalleDisponibilidadMedicoScreen  extends MainScreen {
	
	public DetalleDisponibilidadMedicoScreen(){
		super(USE_ALL_HEIGHT | NO_HORIZONTAL_SCROLL | USE_ALL_WIDTH);
		int tamanioTexto = Util.tamanioTexto();
		LabelField titulo = Util.colocarCabeceraConTitulo("Disponibilidad: "+VariableAplicacion.getMedico().getNombre()+" "+VariableAplicacion.getMedico().getApellido());
		setBanner(titulo);
		
		Vector listaDisponibilidad = VariableAplicacion.getMedico().getDisponibilidad();
		this.add(new SeparatorField());
		
		for(int i=0;i<listaDisponibilidad.size();i++){
			Disponibilidad disponibilidad = (Disponibilidad) listaDisponibilidad.elementAt(i);
			
			LabelField lblDia = new LabelField();
			lblDia.setText("Día: "+disponibilidad.getDia()+"   Fecha: "+disponibilidad.getFecha());

			LabelField lblHorario = new LabelField();
			lblHorario.setText("Horario: "+disponibilidad.getHorario());
			//Separador
			
			this.add(lblDia);
			this.add(lblHorario);
			this.add(new SeparatorField());
			EditField txtEditable = new EditField(READONLY);
			this.add(txtEditable);
		}
		
		this.add(new SeparatorField());
	}

}
