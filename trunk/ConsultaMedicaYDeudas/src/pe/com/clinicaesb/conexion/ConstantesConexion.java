/**
 * 
 */
package pe.com.clinicaesb.conexion;

/**
 * @author Synopsis
 *
 */
public class ConstantesConexion {
	public static final String ENCODING = "ISO-8859-1";
	public static final String ENCODING_UTF8 = "UTF-8";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String APPLICATION = "application/x-www-form-urlencoded";//"application/xml";
	public static final String ACCEPT = "Accept";
	public static final String ACCEPT_JSON = "application/json";
	public static final String CHARSET = 	"charset";
	public static final String RESPUESTA_SATISFACTORIA = "OK";
	public static final String RESPUESTA_ERRONEA = "ERROR";

	//public static final String SERVICIO_WEB_REST_LOGIN_USUARIO = "http://192.168.1.37:8080/spring-rest-servidor/agenda/artistas";
	//public static final String SERVICIO_WEB_REST_LOGIN_USUARIO = "http://192.168.1.37:18080/RerservaCita-rest-servidor/clinica/consultaMedica";
	public static final String SERVICIO_WEB_REST_LOGIN_USUARIO = "http://190.12.69.8/RerservaCita-rest-servidor/clinica/consultaMedica";

	
    public static final String URL_TEST = "http://192.168.1.37";
	  
	public static final String TIME_OUT_PROBAR_CONEXION = ";ConnectionTimeout=10000";//2000";
	public static final String TIME_OUT_CADENA = ";ConnectionTimeout=";
	public static final String TIME_OUT_SERVICIOS = ";ConnectionTimeout=30000";
	public static final long TIME_OUT_RESPONSE = 60000;
	public static final String COOKIE = "Cookie";
	public static final String SET_COOKIE = "Set-Cookie";
}
