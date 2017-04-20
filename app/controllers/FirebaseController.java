package controllers;

import play.mvc.*;
import play.Logger; 
import play.libs.Json;

// form
import javax.inject.*;
import play.data.*;

import java.util.*;
import models.*;

import play.db.ebean.Transactional;

import views.html.*;


/**
 * ตัวอย่าง controller ที่ใช้งานร่วมกับ firebase.
 *
 * ขั้นตอนในการใช้งาน Play framework ร่วมกับ firebase มีดังนี้
 *
 */
public class FirebaseController extends Controller {

  static final Logger.ALogger logger = Logger.of(EbeanController.class);

    @Inject
    FormFactory formFactory;

    @Transactional
    public Result create(String text) {
      Todo t = new Todo();
      //t.id = UUID.randomUUID();
      t.text = text;
      //t.createdDate = new java.util.Date();
      //t.done = false;
      t.save();
      return ok(String.format("Todo(%s, \"%s\") created", t.id, t.text));
    }

    @Transactional
    public Result createFromForm() {
      DynamicForm form = formFactory.form().bindFromRequest();
      Todo t = new Todo();
      //t.id = UUID.randomUUID();
      t.text = form.get("text");
      //t.createdDate = new java.util.Date();
      //t.done = false;
      t.save();
      return redirect("/");
    }

    public Result index() {
      return ok(firebase.render());
    }

}
