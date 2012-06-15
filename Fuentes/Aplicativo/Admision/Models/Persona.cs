using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Globalization;
using System.Web.Mvc;
using System.Web.Security;

namespace Admision.Models
{

    public class Persona
    {
        private String dni;

        public String Dni
        {
            get { return dni; }
            set { dni = value; }
        }
        private String nombre;

        public String Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }
        private String apellidoPaterno;

        public String ApellidoPaterno
        {
            get { return apellidoPaterno; }
            set { apellidoPaterno = value; }
        }
        private String apellidoMaterno;

        public String ApellidoMaterno
        {
            get { return apellidoMaterno; }
            set { apellidoMaterno = value; }
        }
        private String fechaNacimiento;

        public String FechaNacimiento
        {
            get { return fechaNacimiento; }
            set { fechaNacimiento = value; }
        }
        private String direccion;

        public String Direccion
        {
            get { return direccion; }
            set { direccion = value; }
        }
        private String estadoCivil;

        public String EstadoCivil
        {
            get { return estadoCivil; }
            set { estadoCivil = value; }
        }

    }

    
}
