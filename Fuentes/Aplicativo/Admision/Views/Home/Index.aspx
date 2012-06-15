<%@ Page Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage" %>

<%@ Register Assembly="DevExpress.Web.ASPxEditors.v10.1" Namespace="DevExpress.Web.ASPxEditors"
    TagPrefix="dx" %>

<%@ Register Assembly="DevExpress.Web.v10.1" Namespace="DevExpress.Web.ASPxRoundPanel"
    TagPrefix="dx" %>


    
<%@ Register assembly="DevExpress.Web.v10.1" namespace="DevExpress.Web.ASPxPanel" tagprefix="dx" %>
<script runat="server">

    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btbBuscarSeguro_Click(object sender, EventArgs e)
    {

    }

    protected void btnBuscarSeguro_Click(object sender, EventArgs e)
    {

    }

    protected void txtApellidoMaterno_TextChanged(object sender, EventArgs e)
    {

    }


    protected void ASPxButton1_Click(object sender, EventArgs e)
    {
        Admision.WSReniec.ReniecService servicio = new Admision.WSReniec.ReniecService();

        Admision.WSReniec.dniRequest dniRequest = new Admision.WSReniec.dniRequest();
        Admision.WSReniec.DniType dniType = new Admision.WSReniec.DniType();
        dniType.dni = txtdni.Text;

        dniRequest.dni = dniType;

        String strTramaXML = servicio.dni(dniRequest);

        System.Xml.XmlDocument xmlDocumento = new System.Xml.XmlDocument();
        System.Xml.XmlNodeList xmlListaNodoTrama;
        xmlDocumento.LoadXml(strTramaXML);

        xmlListaNodoTrama = xmlDocumento.GetElementsByTagName("Root");

        Admision.Models.Persona persona = new Admision.Models.Persona();
        System.Xml.XmlNode nodo = xmlListaNodoTrama.Item(0);
        System.Xml.XmlElement xmlSubElement = nodo["Root"];

        persona.Nombre = xmlListaNodoTrama[0]["nombre"].InnerText;
        persona.ApellidoPaterno = xmlListaNodoTrama[0]["apellidoPaterno"].InnerText;
        persona.ApellidoMaterno = xmlListaNodoTrama[0]["apellidoMaterno"].InnerText;
        persona.Dni = xmlListaNodoTrama[0]["dni"].InnerText;
        persona.Direccion = xmlListaNodoTrama[0]["direccion"].InnerText;
        persona.FechaNacimiento = xmlListaNodoTrama[0]["fechaNacimiento"].InnerText;
        persona.EstadoCivil = xmlListaNodoTrama[0]["estadoCivil"].InnerText;

        this.txtdni.Text = persona.Dni;
        this.txtAPellidoPaterno.Text = persona.ApellidoPaterno;
        this.txtApellidoMaterno.Text = persona.ApellidoMaterno;
        this.txtDireccion.Text = persona.Direccion;
        this.txtFechaNacimiento.Text = persona.FechaNacimiento;
        
    }
</script>
<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
   
    <style type="text/css">
        .style18
        {
            width: 605px;
        }
        .style20
        {
            width: 611px;
        }
        .style23
        {
            width: 80px;
            text-align: right;
        }
        .style24
        {
            width: 150px;
        }
        .style26
        {
            width: 150px;
        }
        .style31
        {
            width: 670px;
        }
        .style32
        {
            width: 100px;
        }
        .style33
        {
            width: 200px;
        }
        .style34
        {
            width: 115px;
        }
        .style35
        {
            width: 80px;
        }
        .style36
        {
            width: 150px;
        }
        .style39
        {
            width: 200px;
        }
        .style40
        {
            width: 395px;
        }
    </style>
   
</asp:Content>


<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    
    <div>
         <dx:ASPxRoundPanel ID="ASPxRoundPanel1" runat="server" Width="700px" HeaderText="Datos del Cliente"
              
            ShowHeader="True" HeaderStyle-Font-Names="Giorgia"
            HeaderStyle-Font-Size="14px" HeaderStyle-ForeColor="#602320" HeaderStyle-Font-Italic="true"
            HeaderStyle-Font-Bold="true" Height="226px">
          
         
<HeaderStyle Font-Bold="True" Font-Italic="True" Font-Names="Giorgia" Font-Size="14px" ForeColor="#602320"></HeaderStyle>
          
         
              <PanelCollection>
                        <dx:PanelContent runat="server">
                            
                            <table class="style31"> 
                                  <tr>
                                      <td colspan="5">
                                          <dx:ASPxLabel ID="ASPxLabel1" runat="server" ClientIDMode="AutoID" 
                                              CssClass="tableHeader" Text="Datos Personales" Width="670px">
                                          </dx:ASPxLabel>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td class="style32">
                                          <dx:ASPxLabel ID="lblDni" runat="server" ClientIDMode="AutoID" Text="DNI: ">
                                          </dx:ASPxLabel>
                                      </td>
                                      <td class="style39">
                                          <dx:ASPxTextBox ID="txtdni" runat="server" ClientIDMode="AutoID" MaxLength="8" 
                                              Width="80px">
                                          </dx:ASPxTextBox>
                                           
                                      </td>
                                      <td class="style34"><dx:ASPxButton ID="ASPxButton1" runat="server" Text="Buscar" 
                                              ToolTip="Buscar DNI ..." CssClass="button" Width="60px" Height="10px" 
                                              OnClick="ASPxButton1_Click"></dx:ASPxButton></td>
                                      <td class="style36">
                                          <dx:ASPxLabel ID="lblFechaNacimiento" runat="server" ClientIDMode="AutoID" 
                                              Text="Fecha Nacimiento:">
                                          </dx:ASPxLabel>
                                      </td>
                                      <td class="style35">
                                          <dx:ASPxTextBox ID="txtFechaNacimiento" runat="server" ClientIDMode="AutoID" 
                                              MaxLength="10" ReadOnly="True" Width="80px">
                                          </dx:ASPxTextBox>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td class="style32">
                                          <dx:ASPxLabel ID="lblApellidoPaterno" runat="server" ClientIDMode="AutoID" 
                                              Text="Apellido Paterno: " Width="100px">
                                          </dx:ASPxLabel>
                                      </td>
                                      <td class="style39" >
                                          <dx:ASPxTextBox ID="txtAPellidoPaterno" runat="server" ClientIDMode="AutoID" 
                                              MaxLength="50" Width="200px">
                                          </dx:ASPxTextBox>
                                      </td>
                                      <td class="style34" colspan="2" >
                                          <dx:ASPxLabel ID="lblAperllidoMaterno" runat="server" ClientIDMode="AutoID" 
                                              Text="Apellido Materno: ">
                                          </dx:ASPxLabel>
                                      </td>
                                      <td class="style33">
                                          <dx:ASPxTextBox ID="txtApellidoMaterno" runat="server" ClientIDMode="AutoID" 
                                              MaxLength="50" Width="200px" 
                                              OnTextChanged="txtApellidoMaterno_TextChanged">
                                          </dx:ASPxTextBox>
                                      </td>
                                      
                                  </tr>
                                  <tr>
                                      <td class="style32">
                                          <dx:ASPxLabel ID="lblDireccion" runat="server" ClientIDMode="AutoID" 
                                              Text="Dirección: ">
                                          </dx:ASPxLabel>
                                      </td>
                                      <td colspan="4">
                                          <dx:ASPxTextBox ID="txtDireccion" runat="server" ClientIDMode="AutoID" 
                                              MaxLength="100" Width="570px">
                                          </dx:ASPxTextBox>
                                      </td>
                                      
                                  </tr>

                            </table>                               
                            <table  class="style20">
                                <tr>
                                    <td colspan="5">
                                        <dx:ASPxLabel ID="lblSeguro" runat="server" ClientIDMode="AutoID" 
                                            CssClass="tableHeader" Text="Seguro" Width="670px">
                                        </dx:ASPxLabel>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <dx:ASPxLabel ID="lblNumeroSeguro" runat="server" ClientIDMode="AutoID" 
                                            Text="N° Seguro: " Width="100px">
                                        </dx:ASPxLabel>
                                    </td>
                                    <td  class="style39">
                                        <dx:ASPxTextBox ID="txtNumeroSeguro" runat="server" ClientIDMode="AutoID" Width="80px">
                                        </dx:ASPxTextBox>
                                    </td>
                                    <td class="style40" colspan="3">
                                       <dx:ASPxButton ID="btnBuscarSeguro" runat="server" Text="Buscar" 
                                            ToolTip="Buscar seguro ..." CssClass="button" OnClick="btnBuscarSeguro_Click" Width="60px"></dx:ASPxButton></td>
                                            
                                       
                                </tr>
                                
                                <tr>
                                    <td><dx:ASPxLabel ID="lblNombreSeguro" runat="server" Text="Empresa: "/> </td>
                                    <td class="style18" colspan="4" ><dx:ASPxTextBox ID="txtNombreSeguro" runat="server" Width="570px"></dx:ASPxTextBox></td>

                                </tr>
                            </table>
                            <table class="style20">
                                 <tr>
                                    <td colspan="5">
                                        <dx:ASPxLabel ID="lblDatosAdicionales" runat="server" ClientIDMode="AutoID" 
                                            CssClass="tableHeader" Text="Datos Adicionales" Width="670px">
                                        </dx:ASPxLabel>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td><dx:ASPxLabel ID="lblEstadoCivil" runat="server" Text="Estado civil: " Width="70px"/></td>
                                    <td class="style26"><dx:ASPxComboBox ID="cbxEstadoCivil" runat="server" 
                                            SelectedIndex="0">
                                        <Items>
                                            <dx:ListEditItem Selected="True" Text="ListEditItem" />
                                            <dx:ListEditItem Text="Casado(a)" Value="C" />
                                            <dx:ListEditItem Text="Soltero(a)" Value="S" />
                                            <dx:ListEditItem Text="Viudo(a)" Value="V" />
                                            <dx:ListEditItem Text="Divorviado(a)" Value="D" />
                                        </Items>
                                        </dx:ASPxComboBox></td>
                                    <td class="style23"><dx:ASPxLabel  ID ="lblTelefonofijo" runat="server" Text="Teléfono fijo: " Width="80px"/></td>
                                    <td class="style24"><dx:ASPxTextBox  ID ="txtTelefonoFijo" runat="server" MaxLength="15" Width="153px"></dx:ASPxTextBox></td>
                                </tr>
                                
                                 <tr>
                                    <td><dx:ASPxLabel ID="lblMovistar" runat="server" Text="Movistar: " 
                                            Width="55px" Height="16px"/></td>
                                    <td class="style26"><dx:ASPxTextBox ID="txtMovistar" runat="server" Height="16px" Width="153px"></dx:ASPxTextBox></td>
                                    <td class="style23"><dx:ASPxLabel ID="lblRpm" runat="server" Text ="RPM:"/></td>
                                    <td><dx:ASPxTextBox ID="txtRpm" runat="server" Width="153px"></dx:ASPxTextBox></td>
                                </tr>
                                
                               <tr>
                                    <td><dx:ASPxLabel ID="lblClaro" runat="server" Text="Claro: " /></td>
                                    <td class="style26"><dx:ASPxTextBox ID="txtClaro" runat="server" Width="153px"></dx:ASPxTextBox></td>
                                    <td class="style23"><dx:ASPxLabel ID="lblRpc" runat="server" Text="RPC: " Width="50px"/></td>
                                    <td><dx:ASPxTextBox ID="txtRpc" runat="server" Width="153px"></dx:ASPxTextBox></td>
                                    
                                    </tr>
                                    <tr>
                                  <td><dx:ASPxLabel ID="lblNextel" runat="server" Text="Nextel: " /></td>
                                    <td class="style26"><dx:ASPxTextBox ID="txtNextel" runat="server" Width="153px"></dx:ASPxTextBox></td>
                                    <td colspan="2">&nbsp;</td>
                                </tr>
                            </table>

                        </dx:PanelContent>
             </PanelCollection>
            
            </dx:ASPxRoundPanel>            

    </div>
        
               
        
        

    

</asp:Content>
