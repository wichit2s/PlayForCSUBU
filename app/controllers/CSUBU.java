package controllers;

import play.Logger;
import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.*;
import play.data.*;

import java.io.*;

import views.html.*;

public class CSUBU extends Controller {

  private Logger.ALogger log = Logger.of(CSUBU.class);

  public Result index() {
    return ok(csubu.render());
  }

  public Result upload() {
    MultipartFormData<File> body = request().body().asMultipartFormData();
    FilePart<File> picture = body.getFile("picture");
    if (picture != null) {
        String fileName = picture.getFilename();
        String contentType = picture.getContentType();
        File file = picture.getFile();
        log.warn("upload file is at: {}", file.getAbsolutePath());
        try {
          File upload = new File("public/images/gotImages/"+fileName);
          log.warn("renameto: {}", upload.getAbsolutePath());
          file.renameTo(new File("public/images/gotImages/"+fileName));
        } catch (Exception ex) {
          log.warn(ex.toString());
        }
        return redirect("/");
    } else {
        flash("error", "Missing file");
        return badRequest();
    }
  }

}
