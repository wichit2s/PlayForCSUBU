package services;

import play.Logger;

import javax.inject.*;

import java.io.*;

import com.google.firebase.*;
import com.google.firebase.auth.*;
import com.google.firebase.database.*;
import com.google.firebase.tasks.*;

@Singleton
public class FirebaseAppSingleton implements FirebaseAppInterface {

  private final static Logger.ALogger logger = Logger.of(FirebaseAppSingleton.class);

  private FirebaseApp app;

  @Override
  public FirebaseApp get() {
    if (app == null) {
      try {
        FileInputStream serviceAccount = new FileInputStream("conf/Java285UBU-65ae46d9c7cb.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
          .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
          .setDatabaseUrl("https://java285ubu-2ad55.firebaseio.com/")
          .build();

        //app = FirebaseApp.getInstance();
        app = FirebaseApp.initializeApp(options);//, "PlayForCSUBU");
      } catch (Exception ex) {
        logger.error(ex.toString());
      }
    }
    return app;
  }

}
