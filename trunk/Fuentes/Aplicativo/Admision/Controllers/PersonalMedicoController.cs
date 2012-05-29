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
    public class PersonalMedicoController : Controller
    {
        private Clinica db = new Clinica();

        //
        // GET: /PersonalMedico/

        public ViewResult Index()
        {
            return View(db.PersonalMedicos.ToList());
        }

        //
        // GET: /PersonalMedico/Details/5

        public ViewResult Details(string id)
        {
            PersonalMedico personalmedico = db.PersonalMedicos.Find(id);
            return View(personalmedico);
        }

        //
        // GET: /PersonalMedico/Create

        public ActionResult Create()
        {
            return View();
        } 

        //
        // POST: /PersonalMedico/Create

        [HttpPost]
        public ActionResult Create(PersonalMedico personalmedico)
        {
            if (ModelState.IsValid)
            {
                db.PersonalMedicos.Add(personalmedico);
                db.SaveChanges();
                return RedirectToAction("Index");  
            }

            return View(personalmedico);
        }
        
        //
        // GET: /PersonalMedico/Edit/5
 
        public ActionResult Edit(string id)
        {
            PersonalMedico personalmedico = db.PersonalMedicos.Find(id);
            return View(personalmedico);
        }

        //
        // POST: /PersonalMedico/Edit/5

        [HttpPost]
        public ActionResult Edit(PersonalMedico personalmedico)
        {
            if (ModelState.IsValid)
            {
                db.Entry(personalmedico).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(personalmedico);
        }

        //
        // GET: /PersonalMedico/Delete/5
 
        public ActionResult Delete(string id)
        {
            PersonalMedico personalmedico = db.PersonalMedicos.Find(id);
            return View(personalmedico);
        }

        //
        // POST: /PersonalMedico/Delete/5

        [HttpPost, ActionName("Delete")]
        public ActionResult DeleteConfirmed(string id)
        {            
            PersonalMedico personalmedico = db.PersonalMedicos.Find(id);
            db.PersonalMedicos.Remove(personalmedico);
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