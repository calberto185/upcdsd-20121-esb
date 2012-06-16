package pe.com.clinicaesb.controller;

import pe.com.clinicaesb.conexion.ConexionCliente;
import pe.com.clinicaesb.conexion.ConstantesConexion;
import pe.com.clinicaesb.util.ParseadorJSON;

public class ConsultaController {

	public boolean prepararSolicitudNoticiaFavorita(){
		return ConexionCliente.obtenerDatos("", ConstantesConexion.SERVICIO_WEB_REST_LOGIN_USUARIO, false);
	}
	
	public void obtenerRespuestaNoticiaFavorita(){
		ParseadorJSON.obtenerRespuestaConsultaMedica();
	}
	
}
