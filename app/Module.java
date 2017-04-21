import play.Logger;

// firebase
import com.google.firebase.*;
import com.google.firebase.auth.*;
import com.google.firebase.database.*;
import com.google.firebase.tasks.*;

import com.google.inject.AbstractModule;
import java.time.Clock;
import java.io.*;

import services.ApplicationTimer;
import services.AtomicCounter;
import services.Counter;

/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.
 *
 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
public class Module extends AbstractModule {

    static final Logger.ALogger logger = Logger.of(Module.class);

    @Override
    public void configure() {
      logger.warn("calling Module.configure()");

      try {
        FileInputStream serviceAccount = new FileInputStream("conf/Java285UBU-65ae46d9c7cb.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
          .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
          .setDatabaseUrl("https://java285ubu-2ad55.firebaseio.com/")
          .build();

        FirebaseApp.initializeApp(options, "PlayForCSUBU");
      } catch (Exception ex) {
        logger.error(ex.toString());
      }

      // Use the system clock as the default implementation of Clock
      bind(Clock.class).toInstance(Clock.systemDefaultZone());
      // Ask Guice to create an instance of ApplicationTimer when the
      // application starts.
      bind(ApplicationTimer.class).asEagerSingleton();
      // Set AtomicCounter as the implementation for Counter.
      bind(Counter.class).to(AtomicCounter.class);
    }

}
