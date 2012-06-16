package pe.com.clinicaesb.conexion;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.io.StreamConnection;

import pe.com.clinicaesb.util.VariableAplicacion;

import net.rim.blackberry.api.browser.URLEncodedPostData;

public class ConexionCliente {

	public static String obtenerURL(String urlInicial) {
		TransportDetective td = new TransportDetective();
		URLFactory urlFac = new URLFactory(urlInicial);

		if (td.isCoverageAvailable(TransportDetective.TRANSPORT_TCP_WIFI)) {
			if (testConnection(";interface=wifi") == HttpConnection.HTTP_OK) {
				return urlFac.getHttpTcpWiFiUrl();
			}
		} else {
			if (td.isCoverageAvailable(TransportDetective.TRANSPORT_BIS_B)) {
				return urlFac.getHttpBisUrl();
			}
		}
		return urlFac.getHttpDefaultUrl();
		// return urlInicial + ";deviceside=true;ConnectionType=mds-public";
	}

	private static int testConnection(String parametros) {
		HttpConnection httpConn = null;
		try {
			httpConn = (HttpConnection) Connector.open(ConstantesConexion.URL_TEST + parametros + ConstantesConexion.TIME_OUT_PROBAR_CONEXION, Connector.READ, true);
			int codigo = httpConn.getResponseCode();

			return codigo;
		} catch (IOException e) {
			return -1;
		} catch (Exception e1) {
			return -1;
		} finally {
			try {

				if (httpConn != null) {
					httpConn.close();
				}

			} catch (IOException e) {
				return -1;
			}
		}
	}
	
    public static boolean obtenerDatos(String tramaInicial, String uriService, boolean indicadorCookie) {
		boolean respuesta = false;
		OutputStream os = null;
		HttpConnection httpConn = null;
		StreamConnection streamConn = null;
		try {
				URLEncodedPostData postData = new URLEncodedPostData(ConstantesConexion.ENCODING_UTF8, false);
				postData.setData("");//trama="+tramaInicial);
				//postData.append("formato", "JSON");
				byte [] postDataBytes = postData.getBytes();
				String url =  obtenerURL(uriService);
				//httpConn = (HttpConnection)Connector.open(url);

				streamConn = (StreamConnection)Connector.open(url+ConstantesConexion.TIME_OUT_SERVICIOS);
				httpConn = (HttpConnection)streamConn;
				
				//httpConn.setRequestMethod(HttpConnection.POST);
				httpConn.setRequestMethod(HttpConnection.GET);
				//httpConn.setRequestProperty(ConstantesConexion.CONTENT_TYPE,ConstantesConexion.APPLICATION);
				httpConn.setRequestProperty(ConstantesConexion.ACCEPT,ConstantesConexion.ACCEPT_JSON);
				httpConn.setRequestProperty(ConstantesConexion.CHARSET,ConstantesConexion.ENCODING_UTF8);
				
				if(indicadorCookie) {
					httpConn.setRequestProperty(ConstantesConexion.COOKIE, VariableAplicacion.getCookie());
				}
				os = httpConn.openOutputStream();
				os.write(postDataBytes);
				int status = httpConn.getResponseCode();
				if(status == HttpConnection.HTTP_OK) {
					if(!indicadorCookie) {
					String cookie = httpConn.getHeaderField(ConstantesConexion.SET_COOKIE);
						VariableAplicacion.setCookie(cookie);
					}
					InputStream inputStream = httpConn.openInputStream();
					VariableAplicacion.setInputStream(inputStream);
					//TODO Comentado para ya no crear archivos
					//crearArchivoInput(inputStream, nombreArchivo);
		            
		            respuesta =true;
				}
		} catch (Exception e) 
		 {
			System.out.println("conexion Cliente e.getMessage()" + e.getMessage());
			//respuesta = "conexion Cliente e.getMessage()" + e.getMessage();
	     }finally{
	    	 try {
	    		 if(os != null){
	    			 os.close();
	    		 }
	    		 
	    		 
	    		// if(httpConn != null){
	    		//	 httpConn.close();
	    		 //}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     }
		return respuesta;
	} 


}
