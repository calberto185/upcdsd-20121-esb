package pe.com.clinicaesb.util;

import java.util.Vector;

import org.json.me.JSONArray;
import org.json.me.JSONObject;

import pe.com.clinicaesb.conexion.ConstantesConexion;
import pe.com.clinicaesb.domain.Disponibilidad;
import pe.com.clinicaesb.domain.Medico;
import net.rim.device.api.io.IOUtilities;

public class ParseadorJSON {

	
	public static void obtenerRespuestaConsultaMedica(){
		
		JSONObject jsonCabecera = null;
		JSONObject jsonDetalle = null;
		JSONObject jsonRespuesta = null;
		JSONObject jsonDatos = null;
		JSONObject jsonMedico = null;
		JSONObject jsonDisponibilidad = null;
		
		String idTransaccion = "";
		String codigoRespuesta = "";
		String mensajeRespuesta  = "";
		String flagValidacion = "";
		String id = "";
		String token = "";
		String unidadNegocio ="";
		
		String mensajeError="";
		try{
			
            JSONObject jsonIntegracionWSResp = new JSONObject(recuperarTramaJSON());
            
            Vector listaMedicosServicio = new Vector();
            
            if(jsonIntegracionWSResp!=null){
            	
            	JSONArray jsonArrayData = jsonIntegracionWSResp.optJSONArray("data");
            	
            	if(jsonArrayData!=null){
            		for (int i=0 ; i < jsonArrayData.length() ; i++) {
            			
            			Vector listaDisponibilidad = new Vector();
            			
						jsonMedico = (JSONObject) jsonArrayData.get(i);
							
						Medico medicoTemp = new Medico();
						medicoTemp.setNombre(jsonMedico.getString("nomMedico"));
						medicoTemp.setApellido(jsonMedico.getString("apelMedico"));
						medicoTemp.setEspecialidad(jsonMedico.getString("especialidadMedico"));
						
						JSONArray jsonArrayDisponibilidad = jsonMedico.optJSONArray("lstDisponibilidad");
						
						for(int x=0;x<jsonArrayDisponibilidad.length();x++){
							jsonDisponibilidad = (JSONObject) jsonArrayDisponibilidad.get(x);
							
							Disponibilidad disponibilidad= new Disponibilidad();
							
							disponibilidad.setDia(jsonDisponibilidad.getString("dia"));
							disponibilidad.setFecha(jsonDisponibilidad.getString("fecha"));
							disponibilidad.setHorario(jsonDisponibilidad.getString("horario"));
							
							listaDisponibilidad.addElement(disponibilidad);
						}
						
						medicoTemp.setDisponibilidad(listaDisponibilidad);
						

						listaMedicosServicio.addElement(medicoTemp);
					}
            	}

            }
            
            VariableAplicacion.setListaMedico(listaMedicosServicio);
                       
		}catch (Exception e) {
			mensajeError = "";
		} finally {
			VariableAplicacion.setMensajeError(mensajeError);
		}
	}
	

	private static String recuperarTramaJSON() {
		String tramaInicial = Constantes.CADENA_VACIA;
		try{
			tramaInicial = new String(IOUtilities.streamToBytes(VariableAplicacion.getInputStream()), ConstantesConexion.ENCODING_UTF8);
		}catch(Exception e){
			return Constantes.CADENA_VACIA;
		}
		System.out.println("Response Getting from Server is ================" + tramaInicial);
		return tramaInicial;
	}
}
