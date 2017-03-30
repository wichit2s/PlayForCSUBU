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
<<<<<<< HEAD
=======
        //return ok(index.render("Your new application is ready."));
>>>>>>> e8ca6c447c7b193c76e2bc441ced2925d5b36379
      String[] menus = {
        "เมนู A",
        "เมนู B",
        "เมนู C",
        "เมนู D",
<<<<<<< HEAD
        "เมนู E",
        "Memu F"
=======
<<<<<<< HEAD
        "เมนู E"
      };
        return ok(hello.render(menus));
=======
                "เมนู E"
>>>>>>> ea475fe13b74e54b56c77657618afce2a96b4e97
      };
        return ok(hello.render(menus));
          //.as("text/html");
>>>>>>> e8ca6c447c7b193c76e2bc441ced2925d5b36379
    }

}
