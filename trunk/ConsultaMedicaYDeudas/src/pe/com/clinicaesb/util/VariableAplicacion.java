package pe.com.clinicaesb.util;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.Vector;

import pe.com.clinicaesb.domain.Medico;

/**
 * Clase utilitaria que contiene las variables que son usadas entre las vistas,
 * donde unas las actualizan o crean y otras las leen para mostrarlas.
 * 
 * @author Synopsis
 * 
 */
public class VariableAplicacion {

	/**
     * Representa el conjunto de objetos que se muestran en una vista, estos han
     * sido creados del resultado XML despues de ejecutar una operacion.
     */
    private static Hashtable resultado;
    
    public static Hashtable getResultado() {
	    return resultado;
	}
    
    public static void setResultado(Hashtable resultado) {
		 VariableAplicacion.resultado = resultado;
	}
    
    private static String cookie;

	public static String getCookie() {
		return cookie;
	}

	public static void setCookie(String cookie) {
		VariableAplicacion.cookie = cookie;
	}
	
	/**
     * Representa el inputStream que fue retornado en el resultado despues
     * de la ejecucion de la operacion.
     */
	private static InputStream inputStream;

	public static InputStream getInputStream() {
		return inputStream;
	}

	public static void setInputStream(InputStream inputStream) {
		VariableAplicacion.inputStream = inputStream;
	}
	
	/**
     * Representa el identificador del usuario logueado que será almacenado por cada respuesta.
     * de la ejecucion de las operaciones.
     */
    private static String idUsuario;
    
	public static String getIdUsuario() {
		return idUsuario;
	}

	public static void setIdUsuario(String idUsuario) {
		VariableAplicacion.idUsuario = idUsuario;
	}
	
	/**
     * Representa el identificador del la noticia que el usuario selecciono
     * 
     */
	private static String idNoticiaSeleccion;

	public static String getIdNoticiaSeleccion() {
		return idNoticiaSeleccion;
	}

	public static void setIdNoticiaSeleccion(String idNoticiaSeleccion) {
		VariableAplicacion.idNoticiaSeleccion = idNoticiaSeleccion;
	}

	/**
     * Representa la cantidad actualizada de numero de agrados de una noticia
     * 
     */
	private static String numeroAgrados;
	
	public static String getNumeroAgrados() {
		return numeroAgrados;
	}

	public static void setNumeroAgrados(String numeroAgrados) {
		VariableAplicacion.numeroAgrados = numeroAgrados;
	}

	/**
     * Representa el Token que será almacenado por cada respuesta.
     * de la ejecucion de las operaciones.
     */
    private static String token;

	public static String getToken() {
		return token;
	}

	public static void setToken(String token) {
		VariableAplicacion.token = token;
	}
    
	/**
     * Representa la unidad del negocio del usuario. 
     * pe: ECU\synopsis 
     * Unidad Negocio=ECU
     */
    private static String unidadNegocioUsuario;

	public static String getUnidadNegocioUsuario() {
		return unidadNegocioUsuario;
	}

	public static void setUnidadNegocioUsuario(String unidadNegocioUsuario) {
		VariableAplicacion.unidadNegocioUsuario = unidadNegocioUsuario;
	}
	
	/**
     * Representa la unidad del negocio que el usuario selecciona para ver las noticias. 
     * 
     */
    private static String unidadNegocioUsuarioSeleccion;
	
	public static String getUnidadNegocioUsuarioSeleccion() {
		return unidadNegocioUsuarioSeleccion;
	}

	public static void setUnidadNegocioUsuarioSeleccion(
			String unidadNegocioUsuarioSeleccion) {
		VariableAplicacion.unidadNegocioUsuarioSeleccion = unidadNegocioUsuarioSeleccion;
	}

	/**
     * Representa la unidad del negocio que el usuario a seleccionado del resumen de noticias. 
     * 
     */
    private static String unidadNegocioResumenNoticias;
	
	public static String getUnidadNegocioResumenNoticias() {
		return unidadNegocioResumenNoticias;
	}

	public static void setUnidadNegocioResumenNoticias(
			String unidadNegocioResumenNoticias) {
		VariableAplicacion.unidadNegocioResumenNoticias = unidadNegocioResumenNoticias;
	}

	/**
     * Representa la lista de medicos 
     * 
     */
    private static Vector listaMedico;

	public static Vector getListaMedico() {
		return listaMedico;
	}

	public static void setListaMedico(Vector listaMedico) {
		VariableAplicacion.listaMedico = listaMedico;
	}
	
	/**
     * Representa la lista de noticias almacenados en un vector 
     * 
     */
    private static Vector listaNoticias;
	
	public static Vector getListaNoticias() {
		return listaNoticias;
	}

	public static void setListaNoticias(Vector listaNoticias) {
		VariableAplicacion.listaNoticias = listaNoticias;
	}

	/**
     * Representa la pagina de la que se obtendrá la información 
     * 
     */
    private static int pagina;

	public static int getPagina() {
		return pagina;
	}

	public static void setPagina(int pagina) {
		VariableAplicacion.pagina = pagina;
	}
	
	/**
     * Representa la cantidad de paginas para la lista de noticias de la unidad de negocio 
     * 
     */
    private static int totalPaginas;

	public static int getTotalPaginas() {
		return totalPaginas;
	}

	public static void setTotalPaginas(int totalPaginas) {
		VariableAplicacion.totalPaginas = totalPaginas;
	}
	
	
	/**
     * Representa el dni 
     * 
     */
    private static String dni;

	public static String getDni() {
		return dni;
	}

	public static void setDni(String dni) {
		VariableAplicacion.dni = dni;
	}
	
	private static String mensajeError;

	public static String getMensajeError() {
		return mensajeError;
	}

	public static void setMensajeError(String mensajeError) {
		VariableAplicacion.mensajeError = mensajeError;
	}
	
	private static Medico medico;

	public static Medico getMedico() {
		return medico;
	}

	public static void setMedico(Medico medico) {
		VariableAplicacion.medico = medico;
	}
	
    
}
