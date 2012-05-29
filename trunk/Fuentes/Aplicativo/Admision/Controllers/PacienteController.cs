using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Admision.Models;

namespace Admision.Controllers
{ 
    public class PacienteController : Controller
    {
        private Clinica db = new Clinica();

        //
        // GET: /Paciente/

        public ViewResult Index()
        {
            return View(db.Pacientes.ToList());
        }

        //
        // GET: /Paciente/Details/5

        public ViewResult Details(string id)
        {
            Paciente paciente = db.Pacientes.Find(id);
            return View(paciente);
        }

        //
        // GET: /Paciente/Create

        public ActionResult Create()
        {
            return View();
        } 

        //
        // POST: /Paciente/Create

        [HttpPost]
        public ActionResult Create(Paciente paciente)
        {
            if (ModelState.IsValid)
            {
                db.Pacientes.Add(paciente);
                db.SaveChanges();
                return RedirectToAction("Index");  
            }

            return View(paciente);
        }
        
        //
        // GET: /Paciente/Edit/5
 
        public ActionResult Edit(string id)
        {
            Paciente paciente = db.Pacientes.Find(id);
            return View(paciente);
        }

        //
        // POST: /Paciente/Edit/5

        [HttpPost]
        public ActionResult Edit(Paciente paciente)
        {
            if (ModelState.IsValid)
            {
                db.Entry(paciente).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(paciente);
        }

        //
        // GET: /Paciente/Delete/5
 
        public ActionResult Delete(string id)
        {
            Paciente paciente = db.Pacientes.Find(id);
            return View(paciente);
        }

        //
        // POST: /Paciente/Delete/5

        [HttpPost, ActionName("Delete")]
        public ActionResult DeleteConfirmed(string id)
        {            
            Paciente paciente = db.Pacientes.Find(id);
            db.Pacientes.Remove(paciente);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            db.Dispose();
            base.Dispose(disposing);
        }
    }
}