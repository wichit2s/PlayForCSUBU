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
>>>>>>> e8ca6c447c7b193c76e2bc441ced2925d5b36379
      String[] menus = {
        "เมนู A",
        "เมนู B",
        "เมนู C",
        "เมนู D",
        "เมนู E",
        "Memu F",
        "กี้ เอายา เพื่อน"

      };
        return ok(hello.render(menus));


      };
        return ok(hello.render(menus));
          //.as("text/html");

    }

}
