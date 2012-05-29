using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;
using Admision.Models;

namespace Admision.Models
{
    public class Clinica :DbContext
    {
        public DbSet<Especialidad> Especialidads { get; set; }
        public DbSet<Paciente> Pacientes { get; set; }
        public DbSet<PersonalMedico> PersonalMedicos { get; set; }

        
    }
}