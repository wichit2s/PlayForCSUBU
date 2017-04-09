package controllers;

import play.mvc.*;

import views.html.*;

public class CSUBU extends Controller {

  public Result index() {
    return ok(csubu.render());
  }

}
