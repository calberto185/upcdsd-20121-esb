<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="Admision.Login" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
     <title>Sistema de Admisión Hospitalaria</title>
    <link href="~/Styles/Site.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
    <script type="text/javascript" src="~/Scripts/home.js"></script>
     <style type="text/css">
         .style1
         {
             height: 25px;
         }
         .style2
         {
             height: 20px;
         }
     </style>
</head>
<body>
    <form id="form1" runat="server">
    <div class="login">
        <div class="leftLogin">
            <div class="separator">
            </div>
            <div class="textBlack" style="margin-top:20px; margin-left:20px; font-size:14pt">
                Bienvenido al<br />
                Sistema de Admisión Hospitalaria
            </div>
            <div style="width: 620px; height: 412px">
                <!-- Animated logo snippet -->
                <!-- inline animated logo snippet -->
                <div class="gx_anim_animationcontainer" style="width: 620px; height: 412px">
                   <%-- <div class="gx_anim_pwcstamp" style="width: 620px">
                        <img alt="" src="Images/pwc_bar.gif" />
                        </div>--%>
                  
                  <div style="position: relative; bottom: 2px; left: -19px; top: 4px;">
                            <img alt="" src="Images/LogIn.jpg" 
                                style="width: 633px; margin-left: 17px; height: 400px;" />
                        </div>
                   <%-- <div class="gx_anim_textcontainer" style="width: 620px" id="textbox">
                        <div class="gx_anim_textheader" id="textheader">
                        </div>
                        <div class="gx_anim_textdesc" id="textdesc">
                        </div>
                        <div style="position: relative; bottom: 2px; left: -19px; top: 4px;">
                            <img alt="" src="Images/LogIn.jpg" />
                        </div>
                    </div>--%>
                </div>
                <!-- /inline animated logo snippet -->
            </div>
        </div>
        <div class="rightLogin">
            <div class="separatorGray">
            </div>
            <div style="margin-top: 10px; margin-bottom: 10px">
                <asp:Login ID="logSisof" runat="server" onauthenticate="logSisof_Authenticate">
                    <LayoutTemplate>
                        <table cellpadding="1" cellspacing="0" style="border-collapse: collapse;">
                            <tr>
                                <td>
                                    <table cellpadding="0">
                                        <tr>
                                            <td style="line-height: 25px; width:230px">
                                                <b>Login</b>
                                            </td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td align="left" style="text-align: justify" class="style1">
                                                <asp:Label ID="UserNameLabel" runat="server" AssociatedControlID="UserName" CssClass="label">Usuario: </asp:Label>
                                            </td>
                                            <td class="style1">
                                                <asp:TextBox ID="UserName" runat="server" CssClass="TextBox" Width="150px"></asp:TextBox>
                                                <asp:RequiredFieldValidator ID="UserNameRequired" runat="server" ControlToValidate="UserName"
                                                    ErrorMessage="El nombre de usuario es obligatorio." ToolTip="El nombre de usuario es obligatorio."
                                                    ValidationGroup="Login1" CssClass="failureNotification">*</asp:RequiredFieldValidator>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="left" class="style2">
                                                <asp:Label ID="PasswordLabel" runat="server" AssociatedControlID="Password" CssClass="label">Password: </asp:Label>
                                            </td>
                                            <td class="style2">
                                                <asp:TextBox ID="Password" runat="server" TextMode="Password" CssClass="TextBox"
                                                    Width="150px"></asp:TextBox>
                                                <asp:RequiredFieldValidator ID="PasswordRequired" runat="server" ControlToValidate="Password"
                                                    ErrorMessage="La contraseña es obligatoria." ToolTip="La contraseña es obligatoria."
                                                    ValidationGroup="Login1" CssClass="failureNotification">*</asp:RequiredFieldValidator>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td>
                                                <asp:Button ID="LoginButton" runat="server" CssClass="button" Text="Ingresar" ValidationGroup="Login1"
                                                    BorderStyle="None" CommandName="Login" onclick="LoginButton_Click" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" style="padding-top: 10px">
                                                <span class="grayTextLogin">Si tiene problemas en el acceso, por favor contáctese con
                                                </span><a href="mailto:GTS PE Help Desk" class="grayTextLogin">HELP DESK</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="center" colspan="2" class="failureNotification" style="padding-top: 10px">
                                                <asp:Literal ID="FailureText" runat="server" EnableViewState="False"></asp:Literal>
                                                <asp:ValidationSummary ID="valSummary" runat="server" ValidationGroup="Login1" />
                                            </td>
                                        </tr>
                                    </table>

                                </td>
                            </tr>
                        </table>
                    </LayoutTemplate>
                </asp:Login>
            </div>
            <div class="separatorGray">
            </div>
        </div>
        <div class="clear separatorGray">
        </div>
        <br />
        <div class="clear separator">
        </div>
        <div class="footer">
            <center>
                 ©
            <%=DateTime.Now.Year%> UPC - Diseño de Sistemas Distribuidos 20121 M1 - Grupo ESB.

            </center>
           
        </div>
    </div>
    </form>
</body>
</html>
