using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml;
using Admision.Models;

namespace Admision
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void logSisof_Authenticate(object sender, AuthenticateEventArgs e)
        {

        }

        protected void LoginButton_Click(object sender, EventArgs e)
        {
            //--------------------------INI----------------------
            //Invocación Servicio Web SOAP Contrat Firts - Reniec
            //---------------------------------------------------

            WSReniec.ReniecService servicio = new WSReniec.ReniecService();

            WSReniec.dniRequest dniRequest = new WSReniec.dniRequest();
            Admision.WSReniec.DniType dniType = new Admision.WSReniec.DniType();
            dniType.dni = "41645302";//Reemplazar por valor en caja de texto

            dniRequest.dni = dniType;

            String strTramaXML = servicio.dni(dniRequest);

            XmlDocument xmlDocumento = new XmlDocument();
            XmlNodeList xmlListaNodoTrama;
            xmlDocumento.LoadXml(strTramaXML);

            xmlListaNodoTrama = xmlDocumento.GetElementsByTagName("Root");

            Persona persona = new Persona();
            XmlNode nodo = xmlListaNodoTrama.Item(0);
            XmlElement xmlSubElement = nodo["Root"];

            persona.Nombre = xmlListaNodoTrama[0]["nombre"].InnerText;
            persona.ApellidoPaterno = xmlListaNodoTrama[0]["apellidoPaterno"].InnerText;
            persona.ApellidoMaterno = xmlListaNodoTrama[0]["apellidoMaterno"].InnerText;
            persona.Dni = xmlListaNodoTrama[0]["dni"].InnerText;
            persona.Direccion = xmlListaNodoTrama[0]["direccion"].InnerText;
            persona.FechaNacimiento = xmlListaNodoTrama[0]["fechaNacimiento"].InnerText;
            persona.EstadoCivil = xmlListaNodoTrama[0]["estadoCivil"].InnerText;
            //--------------------------FIN----------------------


            //--------------------------INI----------------------
            //Invocación Servicio Web SOAP Contrat Last - SBS
            //---------------------------------------------------
            WSSBS.ValidaImplService servicioSBS = new WSSBS.ValidaImplService();
            String empresaAseguradora = servicioSBS.validarSeguroUsuario("41645302");//Reemplazar por valor en caja de texto
            //--------------------------FIN----------------------
                       
            
            Response.Redirect("/");


        }
    }
}