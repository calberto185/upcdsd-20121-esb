package pe.com.clinicaesb.util;

import net.rim.device.api.ui.Font;


/**
 * 
 * @author Synopsis
 * Clase que contiene los datos que serán contantes para la aplicación.
 * 
 */

public class Constantes {

	public static final String MENSAJE_COMPARAR_LISTA = "Los valores son incomparables";
	
	public static final int COLOR_AZUL = 0x0157A0;
	public static final int COLOR_SUBTITULO = 0x0095D1;
		
	// IMAGENES
	public static final String IMAGEN_LUPA = "lupa.png";
	public static final String IMAGEN_LOGO_TITULO = "logo_95x25px.png";
	public static final String BACKGROUND_HEADER_SINGLE = "icono45x48.png";//"icono25x27.png";//"icono25x27.png";
	
	//Imagen de procesando o cargando
	public static final String IMAGEN_PROCESANDO = "loading.gif";
	public static final String TEXTO_PROCESANDO = "Procesando";
	public static final String TEXTO_CERRANDO_SESION = "Cerrando Sesión";
	
	// para presentacion de pantallas
	public static final int MARGIN_PANTALLA = 5;

	public static final int COLOR_CABECERA = 0xD67B19;//naranja
	
	public static final int COLOR_FONDO_YANBAL = 0xFFFFFF;
	public static final int COLOR_BOTON_YANBAL_NARANJA = 0xD67B19;
	public static final int COLOR_BOTON_YANBAL_LIMON = 0xCAD229;
	public static final int COLOR_BOTON_YANBAL_PLOMO = 0x5F5E56;
	public static final int COLOR_BOTON_SINFOCO = 0xD67B19;//NARANJA
	//public static final int COLOR_BOTON_CONFOCO = ;
	public static final int COLOR_LABEL_CONFOCO = 0x1664b1;
	public static final int COLOR_LETRA_BOTON = 0xFFFFFF;
	public static final int COLOR_LETRA_BOTON_SINFOCO = 0xFFFFFF;
	public static final int COLOR_BOTON_FOCO_GRIS = 0x5f6673;
	public static final int COLOR_BOTON_FOCO_NARANJA = 0xD67B19;
	public static final int COLOR_BOTON_FOCO_LIMON = 0xCAD229;
	public static final int COLOR_BOTON_FOCO_PLOMO = 0x5F5E56;
	public static final int COLOR_BOTON_CONFOCO = 0x1664b1;//VERIFICAR
	
	// textos
	public static final int TEXTO_LISTAS_TAMANIO = 17;
	public static final int TEXTO_NAVEGADOR_TAMANIO = 18;
	public static final int TEXTO_NORMAL_TAMANIO = Font.getDefault().getHeight();
	
	// textos width < 250
	public static final int TEXTO_LISTAS_TAMANIO_1 = 15;
	public static final int TEXTO_NAVEGADOR_TAMANIO_1 = 14;
	public static final int TAMANIO_PANTALLA = 250;
	public static final int TEXTO_NORMAL_TAMANIO_1 = TEXTO_NORMAL_TAMANIO - 5;
	
	// Atributos para la primera carga del aplicativo
	public static final String DOS_PUNTOS = ":";
	public static final String ESPACIO_BLANCO = " ";

	public static final String CADENA_VACIA = "";
	
	// para presentacion de pantallas
	public static final int LISTA_ALTURA = 55;
	
	//Numero que indica que los screen no muestren los items de menu de sistema
    public static final int NO_SYSTEM_MENU_ITEMS = 262144;
    
    //Colores de labels
	public static final int COLOR_LABEL = 0x4D4D4D;
    
    //Pantalla InicioSesionScreen
	public static final String LABEL_USUARIO = "DNI del Usuario";
	public static final String LABEL_CLAVE = "Contraseña";
	public static final String LABEL_RECUERDAME = "Recuerdame";
	
	public static final String RECUERDAME_TRUE = "1";
	public static final String RECUERDAME_FALSE = "0";
	
	//Listado
	public static final String LABEL_ME_GUSTA = "Me Gusta";
	
	//Pantallas Genericas o constantes comunes
	public static final String LABEL_INGRESAR = "Ingresar";
	public static final String LABEL_SEPARADOR_UNIDAD_NEGOCIO = "\\";
	
	//Margenes de botones Transaccionales
	public static final int MARGEN_BOTONES_TRANSACCIONALES = 15;
	
	//MENSAJES
	public static final String MENSAJE_CAMPOS_VACIOS = "Ingreso del DNI es obligatorio";
	public static final String MENSAJE_ERROR_GENERICO = "ocurrio un error inesperado, por favor vuelva a intentar.";
	
	//MENSAJES
	public static final String TITULO_YANBAL_NOTICIAS = "Noticias";
	
	//Operaciones 
	public static final int OPERACION_INICIO_SESION = 10;
	public static final int OPERACION_LISTA_MEDICOS = 11;
	public static final int OPERACION_DETALLE_MEDICO = 12;
	
	public static final String VALOR_FAGYN = "1";
	
	public  static final int TAMANIO_M4 = 18;
	
	public static final String PROTOCOLO_HTTP = "http://";
	
	
	//Constantes de Envio
	
	public static final String TAG_CODIGO_INTERFAZ="CVALUSUYAN";
	public static final String TAG_USUARIO_APLICACION="";
	public static final String TAG_CODIGO_APLICACION="LECNOT_BB";
	
	public static final String SERV_CODIGO_RESPUESTA_OK = "0000";
	
	
	public static final String REST_SERVICIO_LOGIN = "1";
	public static final String REST_SERVICIO_UNINEG = "2";
	public static final String REST_SERVICIO_RESUMEN = "3";
	public static final String REST_SERVICIO_AGRADO = "4";
	

}