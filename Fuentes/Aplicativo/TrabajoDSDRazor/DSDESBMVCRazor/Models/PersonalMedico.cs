using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
namespace DSDESBMVCRazor.Models
{
    public class PersonalMedico
    {
        public string Codigo { get; set; }
        public string ApellidoPaterno { get; set; }
        public string ApellidoMAterno { get; set; }
        public string Nombres { get; set; }
        public char TIPODOCUMENTOID { get; set; }
        public string NumeroDocumentoID { get; set; }
        public string EspecialidadID { get; set; }
        public string NumeroCMP { get; set; }
        public string FechaNacimiento { get; set; }
        public char EstadoCivil { get; set; }
        public string Direccion { get; set; }
        public string TelefonoFijo { get; set; }
        public string MovilMovistar { get; set; }
        public string RPM { get; set; }
        public string MovilClaro { get; set; }
        public string RPC { get; set; }
        public char Estado { get; set; }
        public DateTime FechaRegistro { get; set; }
        public string UsuarioRegistro { get; set; }
        public DateTime FechaModificacion { get; set; }
        public string UsuarioModificacion { get; set; }
    }
}