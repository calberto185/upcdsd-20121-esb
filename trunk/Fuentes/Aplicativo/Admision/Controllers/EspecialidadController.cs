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
    public class EspecialidadController : Controller
    {
        private Clinica db = new Clinica();

        //
        // GET: /Especialidad/

        public ViewResult Index()
        {
            return View(db.Especialidads.ToList());
        }

        //
        // GET: /Especialidad/Details/5

        public ViewResult Details(string id)
        {
            Especialidad especialidad = db.Especialidads.Find(id);
            return View(especialidad);
        }

        //
        // GET: /Especialidad/Create

        public ActionResult Create()
        {
            return View();
        } 

        //
        // POST: /Especialidad/Create

        [HttpPost]
        public ActionResult Create(Especialidad especialidad)
        {
            if (ModelState.IsValid)
            {
                db.Especialidads.Add(especialidad);
                db.SaveChanges();
                return RedirectToAction("Index");  
            }

            return View(especialidad);
        }
        
        //
        // GET: /Especialidad/Edit/5
 
        public ActionResult Edit(string id)
        {
            Especialidad especialidad = db.Especialidads.Find(id);
            return View(especialidad);
        }

        //
        // POST: /Especialidad/Edit/5

        [HttpPost]
        public ActionResult Edit(Especialidad especialidad)
        {
            if (ModelState.IsValid)
            {
                db.Entry(especialidad).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(especialidad);
        }

        //
        // GET: /Especialidad/Delete/5
 
        public ActionResult Delete(string id)
        {
            Especialidad especialidad = db.Especialidads.Find(id);
            return View(especialidad);
        }

        //
        // POST: /Especialidad/Delete/5

        [HttpPost, ActionName("Delete")]
        public ActionResult DeleteConfirmed(string id)
        {            
            Especialidad especialidad = db.Especialidads.Find(id);
            db.Especialidads.Remove(especialidad);
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