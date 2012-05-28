using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace DSDESBMVCRazor.Controllers
{
    public class LogOnController : Controller
    {
        //
        // GET: /LogOn/

        public ActionResult Index()
        {
            return View();
        }

        //
        // GET: /LogOn/Details/5

        public ActionResult Details(int id)
        {
            return View();
        }

        //
        // GET: /LogOn/Create

        public ActionResult Create()
        {
            return View();
        } 

        //
        // POST: /LogOn/Create

        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            try
            {
                // TODO: Add insert logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
        
        //
        // GET: /LogOn/Edit/5
 
        public ActionResult Edit(int id)
        {
            return View();
        }

        //
        // POST: /LogOn/Edit/5

        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here
 
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        //
        // GET: /LogOn/Delete/5
 
        public ActionResult Delete(int id)
        {
            return View();
        }

        //
        // POST: /LogOn/Delete/5

        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here
 
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
