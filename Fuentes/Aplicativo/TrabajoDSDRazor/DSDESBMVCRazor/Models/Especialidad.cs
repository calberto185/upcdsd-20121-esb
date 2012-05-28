using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace DSDESBMVCRazor.Models
{
    public class Especialidad
    {
        [Required]
        [Display(Name = "Codigo")]
        public string Codigo { get; set; }


        [Required]
        [Display(Name = "Descripcion")]
        public string Descripcion { get; set; }

        public char Estado { get; set; }
        public DateTime FechaRegistro { get; set; }
        public string UsuarioRegistro { get; set; }
        public DateTime FechaModificacion { get; set; }
        public string UsuarioModificacion { get; set; }
    }
}