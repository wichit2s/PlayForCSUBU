package controllers;

import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        //return ok(index.render("Your new application is ready."));
      String[] menus = {
        "เมนู A",
        "เมนู B",
        "เมนู C",
        "เมนู D",
        "เมนู E",
        "Chaiyasit_kh",
        "HiSalakjit"
      };
        return ok(hello.render(menus));
          //.as("text/html");
    }

    public Result paul() {
      return ok(paul.render()).as("text/html");
    }
    public Result tang() {
      return ok(tang.render()).as("text/html");
    }

}
